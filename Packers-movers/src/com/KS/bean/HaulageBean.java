package com.KS.bean;


//public 
public class HaulageBean {
	private String haulId,custId,venId,deliveryStatus,BookingDate,deliveryDate,serviceId,totalAmount,pickupLoc,deliveryLoc,haulTitle,haulStatus,authCode,userName;
	
	public HaulageBean()
	{}
	
	public HaulageBean(String authCode,String haulId,String custId,String venId,String deliveryStatus,String BookingDate,String deliveryDate,String haulTitle,String serviceId,String totalAmount,String pickupLoc,String deliveryLoc,String haulStatus,String userName)
	{
		this.haulId=haulId;
		this.haulStatus=haulStatus;
		this.custId=custId;
		this.venId=venId;
		this.haulTitle=haulTitle;
		this.deliveryStatus=deliveryStatus;
		this.BookingDate=BookingDate;
		this.deliveryDate=deliveryDate;
		this.serviceId=serviceId;
		this.totalAmount=totalAmount;
		this.pickupLoc =pickupLoc;
		this.deliveryLoc=deliveryLoc;
		this.authCode=authCode;
		this.userName=userName;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getHaulStatus() {
		return haulStatus;
	}

	public void setHaulStatus(String haulStatus) {
		this.haulStatus = haulStatus;
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPickupLoc() {
		return pickupLoc;
	}

	public void setPickupLoc(String pickupLoc) {
		this.pickupLoc = pickupLoc;
	}

	public String getDeliveryLoc() {
		return deliveryLoc;
	}

	public void setDeliveryLoc(String deliveryLoc) {
		this.deliveryLoc = deliveryLoc;
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
		return haulId+" "+custId+" "+venId+" "+deliveryStatus+" "+BookingDate+" "+deliveryDate+" "+serviceId+" "+totalAmount+" "+pickupLoc+" "+deliveryLoc+" "+haulTitle+" "+haulStatus+" "+authCode+" "+userName;	
	}
}