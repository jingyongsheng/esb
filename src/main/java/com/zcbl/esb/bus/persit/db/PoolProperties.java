package com.zcbl.esb.bus.persit.db;

import com.zcbl.esb.bus.persit.pool.DataSource;
import com.zcbl.esb.bus.persit.pool.DataSourceCache;
import com.zcbl.esb.config.ApplicationContext;

public class PoolProperties implements PoolSupport
{
	DataSource d;

	public PoolProperties()
	{
		d = new DataSource();
		d.setDriver(ApplicationContext.getProperties().get("esb.jdbc.driver"));
		d.setId(ApplicationContext.getProperties().get("esb.jdbc.id"));
		d.setMaxconn(ApplicationContext.getProperties().get("esb.jdbc.maxconn"));
		d.setMinconn(ApplicationContext.getProperties().get("esb.jdbc.minconn"));
		d.setUsername(ApplicationContext.getProperties().get("esb.jdbc.username"));
		d.setPassword(ApplicationContext.getProperties().get("esb.jdbc.password"));
		d.setType(ApplicationContext.getProperties().get("esb.jdbc.type"));
		d.setUrl(ApplicationContext.getProperties().get("esb.jdbc.url"));
		DataSourceCache.getInstance().addService(d);
	}

	@Override
	public DataSource getDataSource()
	{
		return d;
	}

}
