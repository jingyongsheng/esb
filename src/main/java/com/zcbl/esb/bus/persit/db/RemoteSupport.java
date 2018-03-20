package com.zcbl.esb.bus.persit.db;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.zcbl.esb.bus.persit.bean.Remote;

public class RemoteSupport implements Support
{
	public Remote r;
	public String table = "log";
	public Object[] values = null;
	public String sqls;

	@Override
	public String getTable()
	{
		return table;
	}

	@Override
	public String getSql()
	{
		return sqls;
	}

	private void init()
	{
		StringBuilder sql = new StringBuilder();
		StringBuilder v = new StringBuilder();
		Map<String, String> param = r.toMap();
		if (param != null && !param.isEmpty())
		{
			values = new Object[param.size()];
			sql.append("insert into ").append(getTable()).append(" ( ");
			Set<String> set = param.keySet();
			Iterator<String> ite = set.iterator();
			int i = 0;
			while (ite.hasNext())
			{
				String key = (String) ite.next();
				String value = param.get(key);
				sql.append(key);
				v.append("?");
				values[i] = value;
				i++;
				if (i < param.size())
				{
					sql.append(",");
					v.append(",");
				}
			}
			sql.append(" ) values( ").append(v.toString()).append(" )");
			sqls = sql.toString();
		}
	}

	public RemoteSupport(Remote r, String table)
	{
		this.r = r;
		if (table != null)
			this.table = table;
		init();
	}

	@Override
	public Object[] getValue()
	{
		return values;
	}
}
