package com.zcbl.esb.connection;

import java.util.Map;

/**
 * @author jys 2017年5月10日
 */
public abstract class Response implements Uri {

	public abstract Message getMessage();

	public abstract void setMessage(Message message);

	public abstract Map<String, String> getHeader();

	public abstract Status getStatus();

	public abstract void setStatus(Status s);
}
