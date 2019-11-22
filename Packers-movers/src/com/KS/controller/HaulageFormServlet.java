package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.HaulageBean;
import com.KS.bean.UserBean;
import com.KS.dao.HaulageDao;
import com.KS.dao.UserDao;

public class HaulageFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String haulType = request.getParameter("haulType");
		String noOfItems=request.getParameter("noOfItems");
		String shipmentStatus =(String) request.getParameter("shipmentStatus");
		String adPaymentStatus = request.getParameter("adPaymentStatus");
		String bookingDateTime = request.getParameter("bookingDateTime");
		String deliveryDate=request.getParameter("deliveryDate");
		String service = request.getParameter("service");
		String totalAmt=request.getParameter("totalAmt");
		String route = request.getParameter("route");
		String area = request.getParameter("area");
		HaulageBean haulBean = new HaulageBean();

		boolean isError = false;

		if (haulType.trim().length() == 0) {
			isError = true;
			request.setAttribute("HaulTypeError", "<font color='red'>Please Enter haulage type</font>");
		}
		
		/*if(true) 
		{
			for(int i=0;i<name.trim().length();i++)
			{
				if(name.charAt(i)>0 && name.charAt(i)<9)
				{	
					isError = true;
					request.setAttribute("NameError", "<font color='red'>Please Enter valid name</font>");
					break;
				}
			}
		}*/
		else
		{
			haulBean.setHaulType(haulType);
			request.setAttribute("HaulTypeValue", haulType);
		}
		
		
		if (noOfItems.trim().length() == 0) {
			isError = true;
			request.setAttribute("NoOfItemsError", "<font color='red'>Please Enter valid No Of Items</font>");
		} 
		/*else
		{	for(int i=0;i<phoneNo.trim().length();i++)
			{
				if((phoneNo.charAt(i)>=65 && phoneNo.charAt(i)<=90) || (phoneNo.charAt(i)>=97 && phoneNo.charAt(i)<=122))
				{
					isError = true;
					request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
				}
			}
		}*/
		else 
		{
			haulBean.setNoOfItems(noOfItems);;
			request.setAttribute("NoOfItemsValue", noOfItems);
		}

		System.out.println("shipment status==>"+shipmentStatus);
		if (shipmentStatus.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("ShipmentStatusError", "<font color='red'>Please Enter Shipment status</font>");
		} 
		else
		{
			haulBean.setShipmentStatus(shipmentStatus);
			request.setAttribute("ShipmentStatusValue", shipmentStatus);
		}

		if (adPaymentStatus ==null) {
			isError = true;
			request.setAttribute("AdPaymentStatusError", "<font color='red'>Please Enter Advance Payment Status</font>");
		} 
		else
		{
			haulBean.setAdPaymentStatus(adPaymentStatus);
			request.setAttribute("AdPaymentStatusValue", adPaymentStatus);
		}
		
		
		if (bookingDateTime.trim().length() == 0) {
			isError = true;
			request.setAttribute("BookingDateTimeError", "<font color='red'>Please Enter your Booking Date Time</font>");
		} 
		else
		{
			haulBean.setBookingDateTime(bookingDateTime);
			request.setAttribute("BookingDateTimeValue", bookingDateTime);
		}
	
		
		if (deliveryDate.trim().length() == 0) {
			isError = true;
			request.setAttribute("DeliveryDateError", "<font color='red'>Please Enter your Delivery Date</font>");
		} 
		else
		{
			haulBean.setDeliveryDate(deliveryDate);
			request.setAttribute("DeliveryDateValue", deliveryDate);
		}
	
		if (totalAmt.trim().length() == 0) {
			isError = true;
			request.setAttribute("TotalAmtError", "<font color='red'>Please Enter your Total Amt</font>");
		} 
		else
		{
			haulBean.setTotalAmount(totalAmt);
			request.setAttribute("TotalAmtValue", totalAmt);
		}		
		
		
		if (area.trim().length() == 0) {
			isError = true;
			request.setAttribute("AreaError", "<font color='red'>Please Enter your area</font>");
		} 
		else
		{
			haulBean.setTotalAmount(area);
			request.setAttribute("AreaValue", area);
		}		
		
		
		
		if(service == null || service.equals("-1") )
		{
			isError = true;
			request.setAttribute("ServiceError", "<font color='red'>Please select service</font>");
		}else
		{
			haulBean.setServiceId(service);
		}
		
		
		if(route == null || route.equals("-1") ){
			isError = true;
			request.setAttribute("RouteError", "<font color='red'>Please select Route</font>");
		}else{
			haulBean.setRouteId(route);
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("HaulageForm.jsp");
		}
		else 
		{
			HaulageDao dao = new HaulageDao();
			if (dao.insertHaulage(haulBean))
			{
				/*HttpSession session = request.getSession();
				session.setAttribute("UserBean", userBean);
				*/
				//request.setAttribute("UserBean", bean);
				rd = request.getRequestDispatcher("ListHaulageServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
