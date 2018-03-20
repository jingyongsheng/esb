package com.zcbl.esb.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ApplicationContext
{
	static Map<String, String> map = new HashMap<String, String>();
	static Properties properties;
	static
	{
		String configFile = "/esb.properties";
		InputStream in = ApplicationContext.class.getResourceAsStream(configFile);
		if (in != null)
		{
			properties = new Properties();
			try
			{
				properties.load(in);
			} catch (Exception e)
			{
				e.printStackTrace();
			} finally
			{
				try
				{
					in.close();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			initLocalProperties();
		}
	}

	public static Map<String, String> getProperties()
	{
		return map;
	}

	private static void initLocalProperties()
	{
		if (properties != null)
		{
			Set keyValue = properties.keySet();
			for (Iterator it = keyValue.iterator(); it.hasNext();)
			{
				String key = (String) it.next();
				String value = (String) properties.get(key);
				map.put(key, value);
			}
		}
	}

	public static void setProperties(Properties properties)
	{
		ApplicationContext.properties = properties;
		initLocalProperties();
	}
}
