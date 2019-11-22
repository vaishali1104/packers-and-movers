package com.KS.bean;

public class H_Office_removalsBean {
	private String h_officeId,officeType,description,haulId;
	
	public H_Office_removalsBean() 
	{}
	
	public H_Office_removalsBean(String description, String h_officeId,String officeType,String haulId)
	{
		this.h_officeId=h_officeId;
		this.officeType=officeType;
		this.haulId=haulId;
		this.description=description;
	}

		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getH_officeId() {
		return h_officeId;
	}

	public void setH_officeId(String h_officeId) {
		this.h_officeId = h_officeId;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
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
		return h_officeId+" "+officeType+" "+haulId+" "+description;	
	}
}