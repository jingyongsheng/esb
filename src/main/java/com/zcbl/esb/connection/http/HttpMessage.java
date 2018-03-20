package com.zcbl.esb.connection.http;

import com.zcbl.esb.connection.Message;

public class HttpMessage extends Message {

	public HttpMessage(String url, String content) {
		super(url, content);
	}

	@Override
	public Object content() {
		return this.getStr();
	}
}
