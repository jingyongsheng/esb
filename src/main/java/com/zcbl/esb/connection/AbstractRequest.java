package com.zcbl.esb.connection;

import java.util.Map;

/**
 * @author jys 2017年5月10日
 */
public abstract class AbstractRequest extends Request
{
	private Message message;
	private Map<String, String> header;

	protected AbstractRequest(Message message)
	{
		this.message = message;
	}

	public Message getMessage()
	{
		return message;
	}

	public Map<String, String> getHeader()
	{
		return header;
	}

	public void setHeader(Map<String, String> header)
	{
		this.header = header;
	}

	@Override
	public String getTo()
	{
		return message.getTo();
	}

	@Override
	public String getFrom()
	{
		return message.getFrom();
	}
}
