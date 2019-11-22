package com.KS.bean;


//public 
public class VehicleBean {
	private String vehicleId,vehicleType,vehicleCategory;
	
	public VehicleBean()
	{}
	
	public VehicleBean(String vehicleId,String vehicleType,String vehicleCategory)
	{
		this.vehicleId=vehicleId;
		this.vehicleType=vehicleType;
		this.vehicleCategory=vehicleCategory;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
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
		return vehicleId+" "+vehicleType+" "+vehicleCategory;	
	}
}