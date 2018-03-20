package com.zcbl.esb.connection;

import java.io.UnsupportedEncodingException;

public abstract class Content implements Body
{
	private byte[] buffer;
	private String charset;

	@Override
	public String getCharsetName()
	{
		if (charset == null)
		{
			return "utf-8";
		}
		return charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	@Override
	public byte[] read()
	{
		return buffer;
	}

	/**
	 * @param b
	 *            lock is lost
	 */
	public void write(byte[] b)
	{
		if (b == null)
			return;
		if (buffer == null)
		{
			buffer = b;
		} else
		{
			byte[] temp = new byte[b.length + buffer.length];
			System.arraycopy(buffer, 0, temp, 0, buffer.length);
			System.arraycopy(b, 0, temp, buffer.length, b.length);
			buffer = temp;
		}
	}

	/**
	 * @param b
	 *            lock is lost
	 */
	public void write(String b)
	{
		if (b == null)
			return;
		try
		{
			write(b.getBytes(getCharsetName()));
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}

}
