package com.zcbl.esb.connection.rpc;

import com.zcbl.esb.config.ESBPrivider;
import com.zcbl.esb.connection.AbstractRequest;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;
import com.zcbl.malaka.rpc.common.Malaka;

public class RpcRequest extends AbstractRequest
{
	RpcMessage message;
	ESBPrivider privider;

	public RpcRequest(RpcMessage message)
	{
		super(message);
		this.message = message;
	}

	public void setPrivider(ESBPrivider privider)
	{
		this.privider = privider;
	}

	@Override
	public void push(Response response) throws Exception
	{
		if (this.getTo() != null)
		{
			com.zcbl.malaka.rpc.common.url.Response res = Malaka.remote(this.getTo()).request(message.getRequest())
					.times(getProvider().getTryTime()).route(getProvider().getRoute()).server(getProvider().getServer())
					.strategy(getProvider().isStrategy()).hidden(getProvider().isHidden()).result();
			RpcMessage message = new RpcMessage(this.getTo(), res.getResponse());
			response.setMessage(message);
			response.setStatus(Status.SUCCESS);
		} else
		{
			response.setStatus(Status.ERROR);
		}
	}

	@Override
	public ESBPrivider getProvider()
	{
		return privider;
	}
}
