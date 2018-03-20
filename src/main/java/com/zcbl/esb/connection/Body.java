package com.zcbl.esb.connection;

/**
 * @author jys 2017骞�5鏈�10鏃�
 */
public interface Body {
	public String getCharsetName();

	public byte[] read();

	public void write(byte[] b);
}
