package org.dracarys.demo.application;

import org.dracarys.commons.impl.netty.server.NettyServer;
import org.dracarys.commons.impl.netty.server.ServiceManager;


public class Application {
	public static final int PORT = 13900;
	public static void main(String[] args) throws Exception{
		ServiceManager.init();
	    new NettyServer().bind(PORT);
	    System.out.println("服务器启动成功,port=" + PORT);
	}
}
