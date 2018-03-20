package com.zcbl.esb.bus.event;

public abstract class CommonEvent implements Event {
	public void execute() {
		trigger();
	}
	public abstract void trigger();
}
