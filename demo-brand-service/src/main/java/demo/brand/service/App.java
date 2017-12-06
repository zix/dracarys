package demo.brand.service;

import demo.brand.service.server.NettyServer;
import demo.brand.service.server.ServiceManager;


public class App {
	public static final int PORT = 13900;
	public static void main(String[] args) throws Exception{
		ServiceManager.init();
	    new NettyServer().bind(PORT);
	    System.out.println("服务器启动成功,port=" + PORT);
	}
}
