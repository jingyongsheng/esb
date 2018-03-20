package com.zcbl.esb.connection;

/**
 * @author jys 2017年5月10日
 */
public abstract class Message extends Content
{
	private String to;
	private String from;
	private String cron;

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

	public abstract Object content();

	public Message(String url, String content)
	{
		this.to = url;
		super.write(content);
	}

	public void addContent(String content)
	{
		super.write(content);
	}

	public String getTo()
	{
		return to;
	}

	@Override
	public String toString()
	{
		return "Message [to=" + to + ", from=" + from + ", cron=" + cron + ", getCron()=" + getCron() + ", getFrom()="
				+ getFrom() + ", content()=" + content() + ", getTo()=" + getTo() + ", getStr()=" + getStr() + "]";
	}

	public String getStr()
	{
		String str = null;
		if (this.read() == null)
			return null;
		try
		{
			str = new String(this.read(), this.getCharsetName());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
}
