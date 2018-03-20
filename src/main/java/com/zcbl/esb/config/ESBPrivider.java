package com.zcbl.esb.config;

import com.zcbl.esb.factory.Esb;
import com.zcbl.malaka.rpc.client.context.Route;

public class ESBPrivider
{
	public String service;
	public int tryTime = 3;
	public Esb.Channel channel;
	public Esb.IO io;
	public boolean save = true;
	public Esb.PERSIT persit = Esb.PERSIT.REMOTE;
	public Route route = Route.BALANCE;
	public String server;
	public boolean strategy = true;
	public boolean hidden = false;
	

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}

	public boolean isStrategy()
	{
		return strategy;
	}

	public void setStrategy(boolean strategy)
	{
		this.strategy = strategy;
	}

	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public Route getRoute()
	{
		return route;
	}

	public void setRoute(Route route)
	{
		this.route = route;
	}

	public Esb.PERSIT getPersit()
	{
		return persit;
	}

	public void setPersit(Esb.PERSIT persit)
	{
		this.persit = persit;
	}

	public boolean isSave()
	{
		return save;
	}

	public void setSave(boolean save)
	{
		this.save = save;
	}

	public Esb.Channel getChannel()
	{
		return channel;
	}

	public void setChannel(Esb.Channel channel)
	{
		this.channel = channel;
	}

	public Esb.IO getIo()
	{
		return io;
	}

	public void setIo(Esb.IO io)
	{
		this.io = io;
	}

	public String getService()
	{
		return service;
	}

	public void setService(String service)
	{
		this.service = service;
	}

	public int getTryTime()
	{
		if (tryTime <= 0)
			return 1;
		return tryTime;
	}

	public void setTryTime(int tryTime)
	{
		this.tryTime = tryTime;
	}

	public ESBPrivider()
	{
	}

	public ESBPrivider(String service, int tryTime)
	{
		super();
		this.service = service;
		this.tryTime = tryTime;
	}

}
