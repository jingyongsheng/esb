package com.zcbl.esb.factory.handler;

import com.zcbl.esb.bus.cmd.CmdManager;
import com.zcbl.esb.config.Context;
import com.zcbl.esb.connection.Message;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.rpc.RpcMessage;
import com.zcbl.esb.connection.rpc.RpcRequest;
import com.zcbl.esb.connection.rpc.RpcResponse;
import com.zcbl.esb.factory.EsbHander;

public class RpcHander extends EsbHander
{
	Response response;

	public boolean validate(Context c)
	{
		if (this.getProvider().getChannel() == Channel.RPC)
		{
			return true;
		}
		return false;
	}

	@Override
	public Response HanderRequest(Context c)
	{
		if (validate(c))
		{
			RpcMessage message = new RpcMessage(c.getUrl(), c.getHeader());
			message.setCron(c.getCron());
			message.setFrom(c.getFrom());
			RpcRequest request = new RpcRequest(message);
			response = new RpcResponse();
			request.setPrivider(this.getProvider());
			CmdManager.greet(request, response);
		}
		return response;
	}

	@Override
	public Message getResponse()
	{
		// TODO Auto-generated method stub
		return response.getMessage();
	}
}
