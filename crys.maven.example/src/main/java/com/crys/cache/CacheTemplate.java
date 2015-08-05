package com.crys.cache;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 第三方缓存模板类
 */
public abstract class CacheTemplate {

	protected ObjectMapper objectMapper = new ObjectMapper();

	protected CacheTemplate() {
		objectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		objectMapper
				.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
	}

	/**
	 * 写数据
	 * 
	 * @param key
	 * @param value
	 */
	public abstract void set(String key, Object value);

	/**
	 * 读单个key
	 * 
	 * @param key
	 * @param c
	 * @return
	 */
	public abstract <T> T get(String key, Class<T> c);

	/**
	 * 一次性读多个key
	 * 
	 * @param keys
	 * @param c
	 * @return
	 */
	public abstract <T> Map<String, T> mget(List<String> keys, Class<T> c);
}
