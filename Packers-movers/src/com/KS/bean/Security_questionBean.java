package com.KS.bean;

public class Security_questionBean {
	private String security_questionId;
	private String security_question;
	public Security_questionBean(){	}
	
	Security_questionBean(String security_questionId,String security_question)
	{
		this.security_questionId=security_questionId;
		this.security_question=security_question;
	}

	
	public String getSecurity_questionId() {
		return security_questionId;
	}

	public void setSecurity_questionId(String security_questionId) {
		this.security_questionId = security_questionId;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return security_questionId+" "+security_question;
	}
}
