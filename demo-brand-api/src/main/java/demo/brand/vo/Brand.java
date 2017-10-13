package demo.brand.vo;

import java.lang.reflect.Method;
import java.util.Date;

public class Brand {
	private Long brandId;
	private String brandName;
	private String brandEnName;
	private Date createTime;
	
	public Brand(){}
	public Brand(Long brandId, String brandName, String brandEnName, Date createTime) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandEnName = brandEnName;
		this.createTime = createTime;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getBrandEnName() {
		return brandEnName;
	}
	public void setBrandEnName(String brandEnName) {
		this.brandEnName = brandEnName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandEnName=" + brandEnName + ", createTime=" + createTime + "]";
	}
	public static void test(String s1, int i1) {
		System.out.println(s1);
		System.out.println(i1);
	}
	public static void main(String[] args) throws Exception{
		Method m =  Brand.class.getMethod("test", String.class, int.class);
		m.invoke(null, "a", 10);
	}
	
	
}
