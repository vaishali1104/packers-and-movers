package com.KS.bean;

//public 
public class UserBean {
	private String userId,userName,userEmail,userPassword,phoneNo,userTypeId,security_questionId,answer,security_question;
	

	public UserBean()
	{}
	
	public UserBean(String userId,String userName,String userEmail,String userPassword,String phoneNo,String userTypeId,String security_questionId,String answer,String security_question)
	{
		this.userId=userId;
		this.userName=userName;
		this.userEmail=userEmail;
		this.userPassword=userPassword;
		this.phoneNo=phoneNo;
		this.userTypeId=userTypeId;
		this.security_questionId=security_questionId;
	this.security_question=security_question;
		this.answer=answer;
	}
	
	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	
	public String getSecurity_questionId() {
		return security_questionId;
	}

	public void setSecurity_questionId(String security_questionId) {
		this.security_questionId = security_questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
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
		return userId+" "+ userName+" "+userEmail+" "+userPassword+" "+phoneNo+" "+userTypeId+" "+security_questionId+" "+answer;	
	}
}