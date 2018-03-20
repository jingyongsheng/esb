package com.zcbl.esb.connection;

import java.util.Map;

/**
 * @author jys 2017年5月10日
 */
public abstract class AbstractReponse extends Response
{

	public Message message;
	private Map<String, String> header;
	private Status status;

	public Map<String, String> getHeader()
	{
		return header;
	}

	public Message getMessage()
	{
		return message;
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

	public AbstractReponse(Message message, Status s)
	{
		this.message = message;
		this.status = s;
	}

	public void setMessage(Message message)
	{
		this.message = message;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public AbstractReponse()
	{
	}

	public void setHeader(Map<String, String> header)
	{
		this.header = header;
	}

	public Status getStatus()
	{
		return status;
	}
}
