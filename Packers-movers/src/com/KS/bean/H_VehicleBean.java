package com.KS.bean;


//public 
public class H_VehicleBean {
	private String h_vehicleId,vehicleType,vehicleCategory,haulId;
	
	public H_VehicleBean()
	{}
	
	public H_VehicleBean(String h_vehicleId,String vehicleType,String vehicleCategory,String haulId)
	{
		this.h_vehicleId=h_vehicleId;
		this.vehicleType=vehicleType;
		this.vehicleCategory=vehicleCategory;
		this.haulId=haulId;
	}
	
	
	public String getH_vehicleId() {
		return h_vehicleId;
	}

	public void setH_vehicleId(String h_vehicleId) {
		this.h_vehicleId = h_vehicleId;
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
		return h_vehicleId+" "+vehicleType+" "+vehicleCategory+" "+haulId;	
	}
}