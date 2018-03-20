package com.zcbl.esb.connection.rpc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import com.zcbl.esb.connection.Message;

public class RpcMessage extends Message {
	private Map<String, String> request = new HashMap<String, String>();

	public void setRequest(Map<String, String> request) {
		this.request = request;
	}

	public RpcMessage(String url, Map<String, String> content) {
		super(url, null);
		setRequest(content);
	}

	public Map<String, String> getRequest() {
		return request;
	}

	@Override
	public Object content() {
		return request;
	}

	@Override
	public String getStr() {
		return mapToString();
	}

	public String mapToString() {
		java.util.Map.Entry<String, String> entry;
		StringBuilder sb = new StringBuilder();
		for (Iterator<java.util.Map.Entry<String, String>> iterator = request.entrySet().iterator(); iterator
				.hasNext();) {
			entry = (java.util.Map.Entry<String, String>) iterator.next();
			sb.append(entry.getKey()).append("'").append(null == entry.getValue() ? "" : entry.getValue())
					.append(iterator.hasNext() ? "^" : "");
		}
		return sb.toString();
	}

	public void stringToMap(String mapString) {
		java.util.StringTokenizer items;
		for (StringTokenizer entrys = new StringTokenizer(mapString, "^"); entrys.hasMoreTokens(); request
				.put(items.nextToken(), items.hasMoreTokens() ? ((String) (items.nextToken())) : null))
			items = new StringTokenizer(entrys.nextToken(), "'");
	}
}
