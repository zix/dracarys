package demo.brand.service.impl;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import demo.brand.api.IServerInfo;

public class ServerInfoImpl implements IServerInfo {
	private AtomicInteger count = new AtomicInteger(0);
	public String getServerInfo() {
		return System.getProperty("os.name") + ", " + new Date() + ", " + count.incrementAndGet();
	}

	public String getServerInfo(String prop) {
		return System.getProperty(prop) + ", " + count.incrementAndGet();
	}
}
