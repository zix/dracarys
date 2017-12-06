package org.dracarys.commons.impl.client;

import java.util.Date;

public class Brand {
	private Long brandId;
	private String brandName;
	private String brandEnName;
	private String createUser;
	private Date createTime;

	public Brand(){}
	public Brand(Long brandId, String brandName, String brandEnName) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandEnName = brandEnName;
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
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandEnName=" + brandEnName + ", createUser=" + createUser + ", createTime=" + createTime + "]";
	}
}
