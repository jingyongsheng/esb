package com.zcbl.esb.connection.rpc;

import com.zcbl.esb.connection.AbstractReponse;
import com.zcbl.esb.connection.Message;
import com.zcbl.esb.connection.Status;

public class RpcResponse extends AbstractReponse {

	public RpcResponse(Message body, Status s) {
		super(body, s);
	}

	public RpcResponse() {
		super();
	}
}
