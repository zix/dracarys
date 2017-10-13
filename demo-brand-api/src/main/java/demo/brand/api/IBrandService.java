package demo.brand.api;

import demo.brand.meta.Endpoint;
import demo.brand.meta.Param;
import demo.brand.meta.Service;
import demo.brand.vo.Brand;

@Service("demo.brandService")
public interface IBrandService {
	
	@Endpoint("findBrand")
	public Brand findBrand(@Param("brandId") Long brandId, @Param("brandName") String brandName, @Param("brandEnName") String brandEnName);
}
