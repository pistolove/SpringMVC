package com.crys.test;

import java.util.ArrayList;
import java.util.List;

public class TestHttp {

	public static void main(String[] args) {
		while (true) {
			List<String> all = new ArrayList<String>();
			String[] strs = { "" };

			for (String string : strs) {
				StringBuffer buffer = new StringBuffer(string);
				buffer.append("?a=").append(System.currentTimeMillis() + Math.random());
				all.add(buffer.toString());
			}
			System.err.println(getHtml(all));
		}

	}

	private static String getHtml(List<String> urlString) {
		String temp = "";
		for (String urlstr : urlString) {
			try {
				StringBuffer html = new StringBuffer();
				java.net.URL url = new java.net.URL(urlstr); // 根据 String 表示形式创建
																// URL 对象。
				java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// 返回一个
																									// URLConnection
																									// 对象，它表示到
																									// URL
																									// 所引用的远程对象的连接。
				conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				conn.setRequestMethod("GET");
				java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream(), "UTF-8");// 返回从此打开的连接读取的输入流。
				java.io.BufferedReader br = new java.io.BufferedReader(isr);// 创建一个使用默认大小输入缓冲区的缓冲字符输入流。
				System.err.println(Math.random());
				// while ((temp = br.readLine()) != null) { //按行读取输出流
				// if(!temp.trim().equals("")){
				// html.append(temp).append("\n"); //读完每行后换行
				// }
				// }
				// br.close(); //关闭
				// isr.close(); //关闭
				return html.toString(); // 返回此序列中数据的字符串表示形式。
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return temp;
	}
}