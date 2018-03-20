package com.zcbl.esb.bus.cmd;

import java.util.concurrent.LinkedBlockingQueue;

public class CmdListener
{
	LinkedBlockingQueue<Cmd> bq = new LinkedBlockingQueue<Cmd>();

	public CmdListener()
	{
		new task().start();
	}

	public void push(Cmd e) throws InterruptedException
	{
		bq.put(e);
	}

	public void exe(Cmd e)
	{
		e.exe();
	}

	public class task extends Thread
	{
		public void run()
		{
			while (true)
			{
				try
				{
					Cmd c = bq.take();
					exe(c);
				} catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
					e.printStackTrace();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
