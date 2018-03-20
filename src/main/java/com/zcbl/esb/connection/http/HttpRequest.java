package com.zcbl.esb.connection.http;

import com.zcbl.esb.config.ESBPrivider;
import com.zcbl.esb.connection.AbstractRequest;
import com.zcbl.esb.connection.Message;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;

public class HttpRequest extends AbstractRequest
{
	ESBPrivider privider;

	public HttpRequest(Message message)
	{
		super(message);
	}

	public void setPrivider(ESBPrivider privider)
	{
		this.privider = privider;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public void push(Response response) throws Exception
	{
		HttpResponse http = (HttpResponse) response;
		String url = this.getTo();
		if (url == null || url.trim().equals(""))
			return;
		else
		{
			String result = null;
			try
			{
				result = HttpInstance.sendPost(url, this.getMessage().getStr(), this.getHeader());
				http.setStatus(Status.SUCCESS);
			} catch (Exception e)
			{
				http.setStatus(Status.ERROR);
				result = e.getMessage();
			}
			Message c = new HttpMessage(url, result);
			http.setMessage(c);
		}
	}

	@Override
	public ESBPrivider getProvider()
	{
		return privider;
	}
}
