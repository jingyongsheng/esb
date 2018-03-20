package com.zcbl.esb.bus.persit.db;

import java.util.List;

import com.zcbl.esb.bus.persit.pool.DataSource;
import com.zcbl.esb.bus.persit.pool.JdbcUtil;

public class Dao
{
	public static int save(Support s)
	{
		DataSource dataSource = PoolManager.getPoolManager().getDataSource();
		return JdbcUtil.getInstance().executeUpdate(dataSource.getId(), s.getSql(), s.getValue());
	}

	public static List<Object> get()
	{
		DataSource dataSource = PoolManager.getPoolManager().getDataSource();
		return JdbcUtil.getInstance().query(dataSource.getId(), null, null);
	}

	public static int list()
	{
		DataSource dataSource = PoolManager.getPoolManager().getDataSource();
		return JdbcUtil.getInstance().query(dataSource.getId(), null, null);
	}

	public static int update(Support s)
	{
		return 0;
	}

	public static int delete(Support s)
	{
		return 0;
	}
}
