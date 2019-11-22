package com.KS.bean;


public class ServiceBean 
{
	private String serviceId;
	private String serviceType;
	

	public ServiceBean() 
	{
		// TODO Auto-generated constructor stub
	}

	public ServiceBean(String serviceId, String serviceType)
	{
		this.serviceId = serviceId;
		this.serviceType = serviceType;
	}

	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return serviceId + " " + serviceType;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}

