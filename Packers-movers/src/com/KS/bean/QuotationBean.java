package com.KS.bean;

public class QuotationBean {
	private String quotId,quotPrice,custId,venId,haulId,isApproved,deliveryDate,ven_companyName,haulTitle,userName,haulStatus;
	
	public QuotationBean()
	{}
	
	public QuotationBean(String quotId,String quotPrice,String custId,String venId,String haulId,String isApproved,String deliveryDate,String ven_companyName,String haulTitle,String userName,String haulStatus)
	{
		this.quotId=quotId;
		this.quotPrice=quotPrice;
		this.custId=custId;
		this.venId=venId;
		this.haulId=haulId;
		this.isApproved=isApproved;
		this.deliveryDate=deliveryDate;
		this.ven_companyName=ven_companyName;
		this.haulTitle=haulTitle;
		this.userName=userName;
		this.haulStatus=haulStatus;
	}
	
	
	public String getHaulStatus() {
		return haulStatus;
	}

	public void setHaulStatus(String haulStatus) {
		this.haulStatus = haulStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHaulTitle() {
		return haulTitle;
	}

	public void setHaulTitle(String haulTitle) {
		this.haulTitle = haulTitle;
	}

	public String getHaulId() {
		return haulId;
	}

	public void setHaulId(String haulId) {
		this.haulId = haulId;
	}

	public String getVen_companyName() {
		return ven_companyName;
	}

	public void setVen_companyName(String ven_companyName) {
		this.ven_companyName = ven_companyName;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getVenId() {
		return venId;
	}

	public void setVenId(String venId) {
		this.venId = venId;
	}

	public String getQuotId() {
		return quotId;
	}

	public void setQuotId(String quotId) {
		this.quotId = quotId;
	}

	public String getQuotPrice() {
		return quotPrice;
	}

	public void setQuotPrice(String quotName) {
		this.quotPrice = quotName;
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
		return quotId+" "+quotPrice+" "+custId+" "+venId+" "+haulId+" "+deliveryDate+" "+isApproved+" "+ven_companyName+" "+haulTitle+" "+userName+" "+haulStatus;	
	}
}