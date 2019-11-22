package com.KS.bean;

public class Office_removalsBean {
	private String officeId,officeType;
	
	public Office_removalsBean() 
	{}
	
	public Office_removalsBean(String officeId,String officeType)
	{
		this.officeId=officeId;
		this.officeType=officeType;
		
	}

		
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
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
		return officeId+" "+officeType;	
	}
}