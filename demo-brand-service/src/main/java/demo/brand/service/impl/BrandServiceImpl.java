package demo.brand.service.impl;

import java.util.Date;

import demo.brand.api.IBrandService;
import demo.brand.vo.Brand;

public class BrandServiceImpl implements IBrandService {

	public Brand findBrand(Long brandId, String brandName, String brandEnName) {
		return new Brand(brandId, brandName, brandEnName, new Date());
	}

}
