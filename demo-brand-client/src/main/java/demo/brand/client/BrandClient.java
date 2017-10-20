package demo.brand.client;

import demo.brand.api.IBrandService;
import demo.brand.api.IServerInfo;
import demo.brand.vo.Brand;

import java.util.Date;

/**
 * @author v_hebo
 * @create 2017-10-13 13:45
 */
public class BrandClient {

	public static <T> T getService(Class<T> clazz) {
		return (T) ServiceInvocationHandler.getProxy(clazz);
	}

	public static void main(String[] args) {
		IBrandService brandService = getService(IBrandService.class);
		Brand brand = new Brand();
		brand.setBrandId(1L);
		brand.setBrandName("BrandName");
		brand.setBrandEnName("BrandEnName");
		brand.setCreateUser("白龙吟");
		brand.setCreateTime(new Date());
		brand = brandService.createBrand(brand, 1L, "韩跳跳");
		System.out.println(brand);


		IServerInfo si = getService(IServerInfo.class);
		System.out.println(si.getServerInfo("os.name"));
		System.out.println(si.getServerInfo("java.vm.vendor"));
	}
}
