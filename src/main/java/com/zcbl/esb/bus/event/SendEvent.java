package com.zcbl.esb.bus.event;

import com.zcbl.esb.bus.event.annation.Event;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;

@Event
public class SendEvent extends CommonEvent {
	Request request;
	Response response;

	@Override
	public void trigger() {
		try {
			request.push(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Status.ERROR);
		}
	}

	public SendEvent(Request request, Response response) {
		this.request = request;
		this.response = response;
	}
}
