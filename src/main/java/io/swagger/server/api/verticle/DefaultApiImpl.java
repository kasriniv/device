package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Device;

public class DefaultApiImpl implements DefaultApi {

	@Override
	public Device deviceGet() {
		// TODO Auto-generated method stub
		Device myd=new Device();
		myd.setCategory("android");
		myd.setName("the real device");
		myd.setId(77);
		myd.setRegion("AllReal");
		return myd;
	}

	@Override
	public Device devicePost(Device body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device devicePut(Device body) {
		// TODO Auto-generated method stub
		return null;
	}

}
