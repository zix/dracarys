package org.dracarys.demo.api;

import org.dracarys.commons.annotation.EndPoint;
import org.dracarys.commons.annotation.Param;
import org.dracarys.commons.annotation.Service;

@Service("demo.serverInfo")
public interface IServerInfo {
	
	@EndPoint("getServerInfo")
	public String getServerInfo();
	
	@EndPoint("getServerInfoByPropName")
	public String getServerInfoByPropName(@Param("propName") String prop);
}
