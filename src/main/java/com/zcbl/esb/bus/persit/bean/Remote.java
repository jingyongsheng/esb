package com.zcbl.esb.bus.persit.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Remote
{
	public String _from;
	public String _to;
	public String _request;
	public String _response;
	public String _sequene;
	public String _times;
	public String _cron;
	public String _create_time;

	public Remote()
	{
	}

	public Remote(String _from, String _to, String _request, String _response, String _sequene, String _times,
			String _cron)
	{
		super();
		this._from = _from;
		this._to = _to;
		this._request = _request;
		this._response = _response;
		this._sequene = _sequene;
		this._times = _times;
		this._cron = _cron;
		this._create_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public String get_create_time()
	{
		return _create_time;
	}

	public void set_create_time(String _create_time)
	{
		this._create_time = _create_time;
	}

	public String get_from()
	{
		return _from;
	}

	public void set_from(String _from)
	{
		this._from = _from;
	}

	public String get_to()
	{
		return _to;
	}

	public void set_to(String _to)
	{
		this._to = _to;
	}

	public String get_request()
	{
		return _request;
	}

	public void set_request(String _request)
	{
		this._request = _request;
	}

	public String get_response()
	{
		return _response;
	}

	public void set_response(String _response)
	{
		this._response = _response;
	}

	public String get_sequene()
	{
		return _sequene;
	}

	public void set_sequene(String _sequene)
	{
		this._sequene = _sequene;
	}

	public String get_times()
	{
		return _times;
	}

	public void set_times(String _times)
	{
		this._times = _times;
	}

	public String get_cron()
	{
		return _cron;
	}

	public void set_cron(String _cron)
	{
		this._cron = _cron;
	}

	public void toBean(Map<String, String> map)
	{
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors)
			{
				String key = property.getName();
				if (map.containsKey(key))
				{
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					setter.invoke(this, value);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return;
	}

	public Map<String, String> toMap()
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors)
			{
				String key = property.getName();
				if (!key.equals("class"))
				{
					Method getter = property.getReadMethod();
					Object value = getter.invoke(this);
					map.put(key, value == null ? "" : value.toString());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public String toString()
	{
		return "Remote [_from=" + _from + ", _to=" + _to + ", _request=" + _request + ", _response=" + _response
				+ ", _sequene=" + _sequene + ", _times=" + _times + ", _cron=" + _cron + "]";
	}

}
