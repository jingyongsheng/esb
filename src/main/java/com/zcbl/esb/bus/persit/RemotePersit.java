package com.zcbl.esb.bus.persit;

import java.util.concurrent.atomic.AtomicInteger;

import com.zcbl.esb.bus.cmd.SendCmd;
import com.zcbl.esb.bus.persit.bean.Remote;
import com.zcbl.esb.config.ApplicationContext;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;
import com.zcbl.esb.connection.rpc.RpcMessage;
import com.zcbl.esb.connection.rpc.RpcRequest;
import com.zcbl.esb.factory.Esb;

public class RemotePersit implements Persist
{
	static AtomicInteger seq = new AtomicInteger();
	Request request;
	Response response;
	static String service = "esb.mq";
	static
	{
		service = ApplicationContext.getProperties().get(service) == null ? service
				: ApplicationContext.getProperties().get(service);
	}

	@Override
	public int persit(Remote remote)
	{
		if (remote == null)
			return 0;
		RpcMessage message = new RpcMessage(
				request.getProvider().getService() == null ? service : request.getProvider().getService(), null);
		message.setRequest(remote.toMap());
		RpcRequest request = new RpcRequest(message);
		request.setPrivider(this.request.getProvider());
		request.getProvider().setIo(Esb.IO.ASYN);
		new SendCmd(request, response).exe();
		if (response.getStatus() == Status.SUCCESS)
		{
			return 1;
		}
		return 0;
	}

	public RemotePersit(Request request, Response response)
	{
		this.request = request;
		this.response = response;
	}
}
