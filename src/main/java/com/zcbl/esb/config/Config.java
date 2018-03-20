package com.zcbl.esb.config;

import java.util.Map;

import com.zcbl.esb.connection.Message;
import com.zcbl.esb.factory.Esb;
import com.zcbl.esb.factory.EsbFactory;
import com.zcbl.malaka.rpc.client.context.Route;

public class Config
{
	Context t;
	ESBPrivider e;

	public Config()
	{
	}

	public Config(String url)
	{
		t = new Context();
		t.setUrl(url);
		e = new ESBPrivider();
	}

	public Config(String url, Esb.Channel channel, Esb.IO io)
	{
		t = new Context();
		t.setUrl(url);
		e = new ESBPrivider();
		e.setChannel(channel);
		e.setIo(io);
	}

	public Config request(String request)
	{
		t.setRequest(request);
		return this;
	}

	public Config request(Map<String, String> request)
	{
		t.setHeader(request);
		return this;
	}

	public Config hidden()
	{
		e.setHidden(true);
		return this;
	}

	public Config header(Map<String, String> header)
	{
		t.setHeader(header);
		return this;
	}

	public Config esb(String service)
	{
		e.setService(service);
		return this;
	}

	public Config sync_remote()
	{
		e.setIo(Esb.IO.SYNC_REMOTE);
		return this;
	}

	public Config strategy(boolean strategy)
	{
		e.setStrategy(strategy);
		return this;
	}

	public Config local_sync()
	{
		e.setIo(Esb.IO.SYNC_LOCAL);
		return this;
	}

	public Config server(String server)
	{
		e.setServer(server);
		return this;
	}

	public Config from(String from)
	{
		t.setFrom(from);
		return this;
	}

	public Config cron(String cron)
	{
		t.setCron(cron);
		return this;
	}

	public Config asyn()
	{
		e.setIo(Esb.IO.ASYN);
		return this;
	}

	public Config localPerist()
	{
		e.setPersit(Esb.PERSIT.LOCAL);
		return this;
	}

	public Config esbPerist()
	{
		e.setPersit(Esb.PERSIT.REMOTE);
		return this;
	}

	public Config persit(boolean b)
	{
		e.setSave(b);
		return this;
	}

	public Config rpc()
	{
		e.setChannel(Esb.Channel.RPC);
		return this;
	}

	public Config route(Route r)
	{
		e.setRoute(r);
		return this;
	}

	public Config http()
	{
		e.setChannel(Esb.Channel.HTTP);
		return this;
	}

	public Config times(int tryTime)
	{
		e.setTryTime(tryTime);
		return this;
	}

	public Message send()
	{
		Esb esb = new EsbFactory().getESB(t, e);
		if (esb == null)
			return null;
		return esb.getResponse();
	}
}
