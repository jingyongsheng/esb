package com.zcbl.esb.bus.persit;

import com.zcbl.esb.bus.persit.bean.Remote;
import com.zcbl.esb.bus.persit.db.DaoManager;

public class DbPersist implements Persist
{
	static DbPersist p = new DbPersist();

	public static DbPersist getInstance()
	{
		return p;
	}

	@Override
	public int persit(Remote remote)
	{
		return DaoManager.save(remote);
	}
}
