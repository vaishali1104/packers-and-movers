package com.KS.bean;

public class Service_vendorBean {
	private String ser_venId,serviceId,userId;
	
	public Service_vendorBean()
	{}
	
	public Service_vendorBean(String ser_venId,String serviceId,String userId)
	{
		this.ser_venId=ser_venId;
		this.serviceId=serviceId;
		this.userId=userId;
	}
	
	
	public String getSer_venId() {
		return ser_venId;
	}

	public void setSer_venId(String ser_venId) {
		this.ser_venId = ser_venId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return ser_venId+" "+serviceId+" "+userId;	
	}
}