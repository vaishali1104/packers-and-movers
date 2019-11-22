package com.KS.bean;

public class RouteBean {
	private String routeId,origin,destination,cityId,routeVia;
	
	public RouteBean()
	{}
	
	public RouteBean(String routeId,String origin,String destination,String cityId,String routeVia)
	{
		this.routeId=routeId;
		this.origin=origin;
		this.destination=destination;
		this.cityId=cityId;
		this.routeVia=routeVia;
	}
	
	
	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getRouteVia() {
		return routeVia;
	}

	public void setRouteVia(String routeVia) {
		this.routeVia = routeVia;
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
		return routeId+" "+origin+" "+destination+" "+cityId+" "+routeVia;	
	}
}