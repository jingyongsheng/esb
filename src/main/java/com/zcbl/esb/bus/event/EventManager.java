package com.zcbl.esb.bus.event;

public class EventManager
{
	EventLister listener = new EventLister();

	public void syn_event(Event e) throws InterruptedException
	{
		listener.push(e);
	}

	public static void ans_event(Event e)
	{
		e.execute();
	}
}
