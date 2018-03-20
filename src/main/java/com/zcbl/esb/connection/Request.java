package com.zcbl.esb.connection;

import java.util.Map;

import com.zcbl.esb.config.Provider;

/**
 * @author jys 2017年5月10日
 */
public abstract class Request implements Provider, Uri {

	/**
	 * @return
	 * @throws Exception
	 *             第三方发送
	 */
	public abstract void push(Response response) throws Exception;

	public abstract Message getMessage();

	public abstract Map<String, String> getHeader();
}
