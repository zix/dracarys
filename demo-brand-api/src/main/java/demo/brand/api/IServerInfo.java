package demo.brand.api;

import demo.brand.meta.EndPoint;
import demo.brand.meta.Param;
import demo.brand.meta.Service;

@Service("demo.serverInfo")
public interface IServerInfo {
	
	@EndPoint("getServerInfo")
	public String getServerInfo();
	
	@EndPoint("getServerInfoByPropName")
	public String getServerInfo(@Param("propName") String prop);
}
