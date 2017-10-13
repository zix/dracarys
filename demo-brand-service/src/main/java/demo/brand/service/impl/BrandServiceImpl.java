package demo.brand.service.impl;

import java.util.Date;

import demo.brand.api.IBrandService;
import demo.brand.meta.Param;
import demo.brand.vo.Brand;

public class BrandServiceImpl implements IBrandService {

	public Brand createBrand(Brand paramBrand, Long brandId, String username) {
		Brand createdBrand = new Brand(brandId, paramBrand.getBrandName() + "-crated", paramBrand.getBrandEnName() + "-crated");
		createdBrand.setCreateUser(username);
		createdBrand.setCreateTime(new Date());
		return createdBrand;
	}

}
