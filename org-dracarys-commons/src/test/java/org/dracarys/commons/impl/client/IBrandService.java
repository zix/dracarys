package org.dracarys.commons.impl.client;

import org.dracarys.commons.annotation.EndPoint;
import org.dracarys.commons.annotation.Param;
import org.dracarys.commons.annotation.Service;

@Service("demo.brandService")
public interface IBrandService {
	
	@EndPoint("createBrand")
	public Brand createBrand(@Param("brandInfo") Brand brandInfo,@Param("brandId")  Long brandId, @Param("username") String username);
}
