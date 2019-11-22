package com.KS.bean;

public class CityBean {
	private String cityId,cityName,stateId;
	
	public CityBean()
	{}
	
	public CityBean(String cityId,String cityName,String stateId)
	{
		this.cityId=cityId;
		this.cityName=cityName;
		this.stateId=stateId;
	}
	
	
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
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
		return cityId+" "+cityName+" "+stateId;	
	}

	
}