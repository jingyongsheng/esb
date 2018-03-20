package com.zcbl.esb.bus.cmd;

import com.zcbl.esb.connection.Request;
import com.zcbl.esb.connection.Response;
import com.zcbl.esb.factory.Esb;

public class CmdManager
{
	static CmdListener cmd = new CmdListener();

	public static void greet(Request request, Response response)
	{
		if (request.getProvider().getIo() == Esb.IO.ASYN)
		{
			cmd.exe(new SendCmd(request, response));
			if (request.getProvider().isSave())
			{
				cmd.exe(new PersistCmd(request, response));
			}
		} else if (request.getProvider().getIo() == Esb.IO.SYNC_REMOTE)
		{
			cmd.exe(new PersistCmd(request, response));
		} else if (request.getProvider().getIo() == Esb.IO.SYNC_LOCAL)
		{
			try
			{
				cmd.push(new SendCmd(request, response));
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
