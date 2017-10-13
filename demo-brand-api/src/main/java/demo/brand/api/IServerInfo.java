package demo.brand.api;

import demo.brand.meta.Endpoint;
import demo.brand.meta.Param;
import demo.brand.meta.Service;

@Service("demo.serverInfo")
public interface IServerInfo {
	
	@Endpoint("getServerInfo")
	public String getServerInfo();
	
	@Endpoint("getServerInfoByPropName")
	public String getServerInfo(@Param("propName") String prop);
}
