package com.zcbl.esb.factory;

import java.util.LinkedList;
import java.util.Queue;

import com.zcbl.esb.config.Context;
import com.zcbl.esb.config.ESBPrivider;
import com.zcbl.esb.factory.handler.HttpHander;
import com.zcbl.esb.factory.handler.RpcHander;

public class EsbFactory {
	Queue<EsbHander> queue = new LinkedList<EsbHander>();
	{
		queue.add(new HttpHander());
		queue.add(new RpcHander());
	}

	public Esb getESB(Context re, ESBPrivider p) {
		for (EsbHander e : getQueue()) {
			e.setPrivider(p);
			if (e != null && e.HanderRequest(re) != null) {
				return e;
			}
		}
		return null;
	}

	public void pushESB(EsbHander esb) {
		this.queue.add(esb);
	}

	public Queue<EsbHander> getQueue() {
		return queue;
	}
}
