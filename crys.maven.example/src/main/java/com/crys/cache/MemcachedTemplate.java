package com.crys.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.crys.utils.PropertiesUtil;
import com.google.code.yanf4j.core.impl.StandardSocketOption;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

@Component("cacheTemplate")
public class MemcachedTemplate extends CacheTemplate {

	private final static Logger log = LoggerFactory.getLogger(MemcachedTemplate.class);

	private MemcachedClient memcachedClient;

	public MemcachedTemplate() throws Exception {
//		String path = this.getClass().getResource("/conf/memcached.properties").getPath();
		Properties properties = PropertiesUtil.getInstance().getPropertiesByFilePath("D:\\Tomcat 8.0\\wtpwebapps\\crys.maven.example\\WEB-INF\\classes\\conf\\memcached.properties");
		String servers = properties.getProperty("memcached.servers");
		String pool = properties.getProperty("memcached.pool");
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(servers));
		builder.setConnectionPoolSize(Integer.valueOf(pool));// 设置连接池
		builder.setSocketOption(StandardSocketOption.SO_RCVBUF, 32 * 1024);// 设置接收缓存区为32K，默认16K
		builder.setSocketOption(StandardSocketOption.SO_SNDBUF, 16 * 1024); // 设置发送缓冲区为16K，默认为8K
		builder.setSocketOption(StandardSocketOption.TCP_NODELAY, false); // 启用nagle算法，提高吞吐量，默认关闭
		builder.getConfiguration().setStatisticsServer(false);// 是否统计空闲连接

		memcachedClient = builder.build();
		memcachedClient.setOptimizeMergeBuffer(false);// 连接多个操作是否优化为mget
		memcachedClient.setEnableHeartBeat(false);
		memcachedClient.setOpTimeout(2000L);
		memcachedClient.getTranscoder().setCompressionThreshold(1024 * 50);// 设置数据压缩范围
		Object object = memcachedClient.get("key1");
		System.err.println(object.toString());
	}

	/**
	 * 写数据
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value) {
		if (value == null) {
			return;
		}

		long begin = System.currentTimeMillis();
		try {
			String jsonValue = objectMapper.writeValueAsString(value);

			/*
			 * 第一个是存储的key名称
			 * 第二个是expire时间(单位秒),超过这个时间,memcached将这个数据替换出去,0表示永久存储（默认是一个月）
			 * 第三个参数就是实际存储的数据
			 */
			memcachedClient.set(key, 0, jsonValue);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		long end = System.currentTimeMillis();

		log.info("set key:" + key + "," + (end - begin) + "ms");
	}

	/**
	 * 读单个key
	 * 
	 * @param key
	 * @param c
	 * @return
	 */
	public <T> T get(String key, Class<T> c) {
		T jsonValue = null;

		long begin = System.currentTimeMillis();
		try {
			String value = memcachedClient.get(key);
			if (value != null) {
				jsonValue = objectMapper.readValue(value, c);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		long end = System.currentTimeMillis();

		log.info("get key:" + key + "," + (end - begin) + "ms");
		return jsonValue;
	}

	/**
	 * 一次性读多个key
	 * 
	 * @param keys
	 * @param c
	 * @return
	 */
	public <T> Map<String, T> mget(List<String> keys, Class<T> c) {
		Map<String, T> jsonValues = null;
		StringBuilder keys_str = new StringBuilder();

		long begin = System.currentTimeMillis();
		try {
			Map<String, String> values = memcachedClient.get(keys);

			if (values != null) {
				jsonValues = new HashMap<String, T>();
				for (String key : values.keySet()) {
					String value = values.get(key);
					T jsonValue = objectMapper.readValue(value, c);

					jsonValues.put(key, jsonValue);
					if (keys_str.length() > 0) {
						keys_str.append(",");
					}
					keys_str.append(key);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		long end = System.currentTimeMillis();

		log.info("get key:" + keys_str + "," + (end - begin) + "ms");
		return jsonValues;
	}
}
