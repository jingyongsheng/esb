package com.zcbl.esb.connection.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpInstance
{
	private static final int timeOut = 90000;
	private static final int BUFFERSIZE = 2048;
	protected static Logger log = LoggerFactory.getLogger(HttpInstance.class);
	public final static String SYSTEM_ERROR = "201";
	public final static String SYSTEM_SUCCESS = "200";

	public static String sendPost(String url, String content, Map<String, String> header) throws Exception
	{
		log.info("request url：" + url);
		String result = null;
		StringBuilder out = null;
		CloseableHttpClient httpclient = null;
		HttpPost postmethod = null;
		RequestConfig requestConfig = null;
		HttpEntity entity = null;
		StringEntity strentity = null;
		CloseableHttpResponse response = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		InputStream inputStream = null;
		try
		{
			out = new StringBuilder();
			httpclient = HttpClients.createDefault();
			URI uri = URI.create(url);
			postmethod = new HttpPost(uri.toString());
			requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut).setConnectTimeout(timeOut)
					.setSocketTimeout(timeOut).build();
			postmethod.setConfig(requestConfig);
			String encoding = header == null ? "utf-8"
					: (header.get("Content-Encoding") == null ? "utf-8" : header.get("Content-Encoding"));
			if (content != null)
				strentity = new StringEntity(content.toString(), encoding);
			if (header != null && !header.isEmpty())
			{
				Iterator<String> ite = header.keySet().iterator();
				while (ite.hasNext())
				{
					String key = ite.next();
					String value = header.get(key);
					postmethod.addHeader(key, value);
				}
			}
			postmethod.setEntity(strentity);
			response = httpclient.execute(postmethod);
			int statusCode = response.getStatusLine().getStatusCode();
			entity = response.getEntity();
			inputStream = entity.getContent();
			isr = new InputStreamReader(inputStream, encoding);
			br = new BufferedReader(isr);
			int count = 0;
			char[] b = new char[BUFFERSIZE];
			while ((count = br.read(b, 0, BUFFERSIZE)) != -1)
			{
				out.append(new String(b, 0, count));
			}
			if (statusCode != HttpStatus.SC_OK)
			{
				log.error("##########异常状态:" + statusCode);
				log.error("##########异常信息:" + out.toString());
				throw new Exception(String.valueOf(statusCode));
			}
		} catch (Exception e)
		{
			log.info("##########请求异常:" + e.getMessage());
			throw new Exception(e);
		} finally
		{
			if (br != null)
			{
				br.close();
			}
			if (isr != null)
			{
				isr.close();
			}
			if (inputStream != null)
			{
				inputStream.close();
			}
			if (response != null)
			{
				response.close();
			}
			if (postmethod != null)
			{
				postmethod.releaseConnection();
			}
			if (httpclient != null)
			{
				httpclient.close();
			}
			result = out.toString();
			out.setLength(0);
			out = null;
		}
		return result;
	}
}
