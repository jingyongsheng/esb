package com.zcbl.esb;

import com.zcbl.esb.config.Config;
import com.zcbl.esb.factory.Esb;

/**
 * @author jys
 *
 */
public class EsbClient
{
	public static Config _http(String url)
	{
		return new Config(url, Esb.Channel.HTTP, Esb.IO.SYNC_REMOTE);
	}

	public static Config http(String url)
	{
		return new Config(url, Esb.Channel.HTTP, Esb.IO.ASYN);
	}

	public static Config _rpc(String url)
	{
		return new Config(url, Esb.Channel.RPC, Esb.IO.SYNC_REMOTE);
	}

	public static Config rpc(String url)
	{
		return new Config(url, Esb.Channel.RPC, Esb.IO.ASYN);
	}

	public static Config remote(String url)
	{
		return new Config(url);
	}

	public static void log(String log)
	{
		new Config().sync_remote().rpc().esb("esb.log").request(log).send();
	}
}
