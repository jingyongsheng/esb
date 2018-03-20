package com.zcbl.esb.bus.event;

import java.util.concurrent.atomic.AtomicInteger;

import com.zcbl.esb.bus.event.annation.Event;
import com.zcbl.esb.bus.persit.PerisitManger;
import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.connection.Status;

@Event
public class PersitEvent extends CommonEvent {
	Request request;
	Response response;
	static AtomicInteger seq = new AtomicInteger();

	@Override
	public void trigger() {
		try {
			PerisitManger.persit(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Status.ERROR);
		}
	}

	public PersitEvent(Request request, Response response) {
		this.request = request;
		this.response = response;
	}
}
