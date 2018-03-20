package com.zcbl.esb.factory;

import com.zcbl.esb.connection.Message;

public interface Esb
{
	public Message getResponse();

	public static enum Channel
	{
		RPC, HTTP;
	}

	public static enum IO
	{
		ASYN, SYNC_REMOTE, SYNC_LOCAL;
	}

	public static enum PERSIT
	{
		LOCAL, REMOTE;
	}

}
