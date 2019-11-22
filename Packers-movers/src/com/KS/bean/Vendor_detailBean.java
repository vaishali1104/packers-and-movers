package com.KS.bean;


//public 
public class Vendor_detailBean {
	private String vendorDetailId,city,userId,address,maxVehicle,license,companyName;
	
	public Vendor_detailBean()
	{}
	
	public Vendor_detailBean(String city,String vendorDetailId,String userId,String address,String maxVehicle,String license,String companyName)
	{
		this.vendorDetailId=vendorDetailId;
		this.userId=userId;
		this.address=address;
		this.maxVehicle=maxVehicle;
		this.license=license;		
		this.city=city;
		this.companyName=companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVendorDetailId() {
		return vendorDetailId;
	}

	public void setVendorDetailId(String vendorDetailId) {
		this.vendorDetailId = vendorDetailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaxVehicle() {
		return maxVehicle;
	}

	public void setMaxVehicle(String maxVehicle) {
		this.maxVehicle = maxVehicle;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return vendorDetailId+" "+userId+" "+address+" "+maxVehicle+" "+license+" "+city+" "+companyName;	
	}
}