package com.KS.bean;


public class UserTypeBean 
{
	private String UserTypeId;
	private String UserTypeName;
	

	public UserTypeBean() 
	{
		// TODO Auto-generated constructor stub
	}

	public UserTypeBean(String UserTypeId, String UserTypeName)
	{
		this.UserTypeId = UserTypeId;
		this.UserTypeName = UserTypeName;
	}


	public String getUserTypeId() {
		return UserTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		UserTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return UserTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		UserTypeName = userTypeName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return UserTypeId + " " + UserTypeName;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}

