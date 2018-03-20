package com.zcbl.esb.bus.persit;

import java.util.concurrent.atomic.AtomicInteger;

import com.zcbl.esb.bus.persit.bean.Remote;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.factory.Esb;

public class PerisitManger
{
	static AtomicInteger seq = new AtomicInteger();

	public static boolean persit(Request request, Response response) throws Exception
	{
		Remote r = build(request, response);
		if (request.getProvider().getPersit() == Esb.PERSIT.LOCAL)
		{
			DbPersist.getInstance().persit(r);
		} else if (request.getProvider().getPersit() == Esb.PERSIT.REMOTE)
		{
			new RemotePersit(request, response).persit(r);
		}
		return true;
	}

	private static Remote build(Request request, Response response)
	{
		Remote r = new Remote(request.getFrom(), request.getTo(), request.getMessage().getStr(),
				response.getMessage() == null ? null : response.getMessage().getStr(),
				String.valueOf(seq.incrementAndGet()), String.valueOf(request.getProvider().getTryTime()),
				request.getMessage().getCron());
		return r;
	}
}
