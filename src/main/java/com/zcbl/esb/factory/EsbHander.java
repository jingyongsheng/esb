package com.zcbl.esb.factory;

import com.zcbl.esb.config.Context;
import com.zcbl.esb.config.ESBPrivider;
import com.zcbl.esb.config.Provider;
import com.zcbl.esb.connection.Response;

public abstract class EsbHander implements Provider, Esb {
	ESBPrivider privider;

	public abstract Response HanderRequest(Context context);

	public ESBPrivider getProvider() {
		return privider;
	}

	public void setPrivider(ESBPrivider privider) {
		this.privider = privider;
	}
}
