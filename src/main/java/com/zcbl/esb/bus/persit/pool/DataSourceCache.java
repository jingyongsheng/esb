package com.zcbl.esb.bus.persit.pool;

import java.util.Hashtable;
import java.util.Map;

public class DataSourceCache {
	private Map<String, DataSource> map = new Hashtable<String, DataSource>();
	static DataSourceCache cache = new DataSourceCache();

	public static DataSourceCache getInstance() {
		return cache;
	}

	private DataSourceCache() {
	}

	public DataSource getService(String id) {
		return getMap().get(id);
	}

	public void addService(DataSource service) {
		getMap().put(service.getId(), service);
	}

	public Map<String, DataSource> getMap() {
		return getInstance().map;
	}
}
