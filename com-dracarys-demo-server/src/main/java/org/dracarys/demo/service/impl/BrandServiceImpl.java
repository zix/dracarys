package org.dracarys.demo.service.impl;

import java.util.Date;

import org.dracarys.demo.api.IBrandService;
import org.dracarys.demo.vo.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements IBrandService {

    public Brand createBrand(Brand paramBrand, Long brandId, String username) {
        Brand createdBrand = new Brand(brandId, paramBrand.getBrandName() + "-crated", paramBrand.getBrandEnName() + "-crated");
        createdBrand.setCreateUser(username);
        createdBrand.setCreateTime(new Date());
        return createdBrand;
    }

}
