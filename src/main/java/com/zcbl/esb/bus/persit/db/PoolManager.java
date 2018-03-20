package com.zcbl.esb.bus.persit.db;

import com.zcbl.esb.bus.persit.pool.DataSource;

public class PoolManager
{
	static PoolManager manager = new PoolManager();
	PoolSupport pool;

	private PoolManager()
	{
		this.pool = new PoolProperties();
	}

	public static PoolManager getPoolManager()
	{
		return manager;
	}

	public DataSource getDataSource()
	{
		if (pool == null)
			return null;
		return pool.getDataSource();
	}

	public void setPool(PoolSupport p)
	{
		this.pool = p;
	}
}
