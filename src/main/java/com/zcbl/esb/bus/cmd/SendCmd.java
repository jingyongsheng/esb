package com.zcbl.esb.bus.cmd;

import com.zcbl.esb.bus.event.EventManager;
import com.zcbl.esb.bus.event.SendEvent;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;

public class SendCmd implements Cmd
{
	Request request;
	Response response;

	@Override
	public void exe()
	{
		for (int i = 0; i < request.getProvider().getTryTime(); i++)
		{
			EventManager.ans_event(new SendEvent(request, response));
			if (response.getStatus() == Status.SUCCESS)
			{
				break;
			}
		}
	}

	public SendCmd(Request request, Response response)
	{
		this.request = request;
		this.response = response;
	}
}
