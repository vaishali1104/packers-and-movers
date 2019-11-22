package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.QuotationBean;
import com.KS.bean.UserBean;
import com.KS.dao.HaulageDao;
import com.KS.dao.QuotationDao;

public class PlaceQuotationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String haulId = request.getParameter("haulId");
		String custId = request.getParameter("custId");
		String quotPrice = request.getParameter("quotPrice");
		String deliveryDate = request.getParameter("deliveryDate");
		QuotationBean quotbean = new QuotationBean();

		boolean isError = false;
		
		HttpSession session =request.getSession();
		UserBean userbean=(UserBean)session.getAttribute("UserBean");
		
		quotbean.setCustId(custId);
		quotbean.setHaulId(haulId);
		quotbean.setVenId(userbean.getUserId());
		quotbean.setIsApproved("pending");
	

		if (quotPrice.trim().length() == 0) {
			isError = true;
			request.setAttribute("QuotPriceError", "<font color='red'>Please Enter Quotation Price</font>");
		}
		else
		{
			
			int flag=0;
			for(int i=0;i<quotPrice.trim().length();i++)
			{    
				
				if( !(quotPrice.charAt(i)>=48 && quotPrice.charAt(i)<=57))  
				{	
					isError = true;
					request.setAttribute("QuotPriceError", "<font color='red'>Please Enter Quote price</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				quotbean.setQuotPrice(quotPrice);
				request.setAttribute("QuotPriceValue", quotPrice);
			}
		}
		
		if (deliveryDate.trim().length() == 0) {
			isError = true;
			request.setAttribute("DeliveryDateError", "<font color='red'>Please Enter Delivery Date</font>");
		}
		else
		{
			quotbean.setDeliveryDate(deliveryDate);
			request.setAttribute("DeliveryDateValue",deliveryDate);
		}
		
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("PlaceQuotation.jsp?haul_id="+quotbean.getHaulId());
		}
		else 
		{
			QuotationDao quotDao = new QuotationDao();
			HaulageDao haulDao=new HaulageDao();
			if (quotDao.insertQuotation(quotbean) && haulDao.updateHaulStatus(quotbean.getHaulId())) {
				rd = request.getRequestDispatcher("ShowRequestServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}