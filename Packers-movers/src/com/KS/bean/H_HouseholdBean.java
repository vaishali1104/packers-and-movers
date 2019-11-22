package com.KS.bean;


//public 
public class H_HouseholdBean {
	private String h_houseId,houseType,haulId;
	
	public H_HouseholdBean()
	{}
	
	public H_HouseholdBean(String h_houseId,String houseType,String haulId)
	{
		this.h_houseId=h_houseId;
		this.houseType=houseType;
		this.haulId=haulId;
	}
	

	
	public String getH_houseId() {
		return h_houseId;
	}

	public void setH_houseId(String h_houseId) {
		this.h_houseId = h_houseId;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	
	
	public String getHaulId() {
		return haulId;
	}

	public void setHaulId(String haulId) {
		this.haulId = haulId;
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
		return h_houseId+" "+houseType+" "+haulId;	
	}
}