package com.zcbl.esb.factory.handler;

import com.zcbl.esb.bus.cmd.CmdManager;
import com.zcbl.esb.config.Context;
import com.zcbl.esb.connection.Message;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.http.HttpMessage;
import com.zcbl.esb.connection.http.HttpRequest;
import com.zcbl.esb.connection.http.HttpResponse;
import com.zcbl.esb.factory.EsbHander;

public class HttpHander extends EsbHander
{
	Response response;

	public boolean validate(Context c)
	{
		if (this.getProvider().getChannel() != Channel.HTTP)
		{
			return false;
		}
		if (c.getUrl() != null && c.getUrl().startsWith("http"))
			return true;
		return false;
	}

	@Override
	public Response HanderRequest(Context c)
	{
		if (validate(c))
		{
			Message message = new HttpMessage(c.getUrl(), c.getRequest());
			message.setCron(c.getCron());
			message.setFrom(c.getFrom());
			HttpRequest request = new HttpRequest(message);
			request.setHeader(c.getHeader());
			request.setPrivider(this.getProvider());
			response = new HttpResponse();
			CmdManager.greet(request, response);
		}
		return response;
	}

	@Override
	public Message getResponse()
	{
		return response.getMessage();
	}
}
