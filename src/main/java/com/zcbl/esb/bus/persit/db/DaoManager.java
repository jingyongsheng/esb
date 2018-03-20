package com.zcbl.esb.bus.persit.db;

import java.util.ArrayList;
import java.util.List;

import com.zcbl.esb.bus.persit.bean.Remote;

public class DaoManager
{
	public static int save(Remote r)
	{
		Support s = new RemoteSupport(r, null);
		return Dao.save(s);
	}

	public static int update(Remote r)
	{
		Support s = new RemoteSupport(r, null);
		return Dao.update(s);
	}

	public static int delete(Remote r)
	{
		Support s = new RemoteSupport(r, null);
		return Dao.delete(s);
	}

	public static Remote next()
	{
		Remote r = new Remote();
		return r;
	}

	public static List<Remote> List()
	{
		Remote r = new Remote();
		List<Remote> list = new ArrayList<Remote>();
		return list;
	}
}
