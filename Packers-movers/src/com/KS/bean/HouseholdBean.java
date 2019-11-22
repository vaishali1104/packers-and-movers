package com.KS.bean;


//public 
public class HouseholdBean {
	private String houseId,houseType;
	
	public HouseholdBean()
	{}
	
	public HouseholdBean(String houseId,String houseType)
	{
		this.houseId=houseId;
		this.houseType=houseType;
		
	}
	

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
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
		return houseId+" "+houseType;	
	}
}