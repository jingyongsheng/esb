package com.zcbl.esb.bus.cmd;

import com.zcbl.esb.bus.event.EventManager;
import com.zcbl.esb.bus.event.PersitEvent;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;

public class PersistCmd implements Cmd
{
	Request request;
	Response response;
	static EventManager manager = new EventManager();

	@Override
	public void exe()
	{
		try
		{
			manager.syn_event(new PersitEvent(request, response));
		} catch (Exception e)
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
			response.setStatus(com.zcbl.esb.connection.Status.ERROR);
		}
	}

	public PersistCmd(Request request, Response response)
	{
		// TODO Auto-generated constructor stub
		this.request = request;
		this.response = response;
	}

}
