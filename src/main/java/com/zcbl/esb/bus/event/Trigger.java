package com.zcbl.esb.bus.event;

public interface Trigger {
	public Event trigger(Event parent);
}
