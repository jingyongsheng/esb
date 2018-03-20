package com.zcbl.esb.bus.event;

import java.util.concurrent.LinkedBlockingQueue;

public class EventLister {
	LinkedBlockingQueue<Event> bq = new LinkedBlockingQueue<Event>();

	public EventLister() {
		new task().start();
	}

	public void push(Event e) throws InterruptedException {
		bq.put(e);
	}

	public class task extends Thread {
		public void run() {
			while (true) {
				try {
					Event c = bq.take();
					c.execute();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
