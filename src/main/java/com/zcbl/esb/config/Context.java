package com.zcbl.esb.config;

import java.util.Map;

public class Context
{
	protected String url;
	protected String request;
	protected Map<String, String> header;
	protected String from;
	public String cron;

	public String getCron()
	{
		return cron;
	}

	public void setCron(String cron)
	{
		this.cron = cron;
	}
	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public Context(String url, String request, Map<String, String> header)
	{
		this.request = request;
		this.url = url;
		this.header = header;
	}

	public Context()
	{
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getRequest()
	{
		return request;
	}

	public void setRequest(String request)
	{
		this.request = request;
	}

	public Map<String, String> getHeader()
	{
		return header;
	}

	public void setHeader(Map<String, String> header)
	{
		this.header = header;
	}
}
