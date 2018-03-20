package com.zcbl.esb.connection.http;

import com.zcbl.esb.connection.AbstractReponse;
import com.zcbl.esb.connection.Message;
import com.zcbl.esb.connection.Status;

public class HttpResponse extends AbstractReponse {

	public HttpResponse(Message body, Status s) {
		super(body, s);
	}
	public HttpResponse(){}
}
