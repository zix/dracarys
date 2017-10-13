package demo.brand.api;

import demo.brand.meta.EndPoint;
import demo.brand.meta.Param;
import demo.brand.meta.Service;
import demo.brand.vo.Brand;

@Service("demo.brandService")
public interface IBrandService {
	
	@EndPoint("createBrand")
	public Brand createBrand(@Param("brandInfo") Brand brandInfo,@Param("brandId")  Long brandId, @Param("username") String username);
}
