package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.QuotationBean;
import com.KS.dao.QuotationDao;
import com.KS.dao.Vendor_detailDao;

public class UpdateQuotationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String quotId=request.getParameter("quotId");
		String custId=request.getParameter("custId");
		String venId=request.getParameter("venId");
		String haulId=request.getParameter("haulId");
		String isApproved=request.getParameter("isApproved");
		String quotPrice = request.getParameter("quotPrice");
		String deliveryDate = request.getParameter("deliveryDate");
	
		QuotationBean bean = new QuotationBean();

		boolean isError = false;

		QuotationDao dao=new QuotationDao();
		bean=dao.getDataByPk(quotId);
		
		bean.setQuotId(quotId);
		bean.setCustId(custId);
		bean.setHaulId(haulId);
		bean.setVenId(venId);
		bean.setIsApproved(isApproved);
		
		if (quotPrice.trim().length() == 0) {
			isError = true;
			request.setAttribute("QuotPriceError", "<font color='red'>Please Enter Quotation price </font>");
		} 
		else 
		{
			int flag=0;
			for(int i=0;i<quotPrice.trim().length();i++)
			{    
				
				if( !(quotPrice.charAt(i)>=48 && quotPrice.charAt(i)<=57))  
				{	
					isError = true;
					request.setAttribute("QuotPriceError", "<font color='red'>Please Enter valid Quotation price</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				bean.setQuotPrice(quotPrice);
				request.setAttribute("QuotPriceValue", quotPrice);
			}
		}

		
		if (deliveryDate.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("DeliveryDateError", "<font color='red'>Please Enter Delivery date</font>");
		}
		else
		{
			bean.setDeliveryDate(deliveryDate);
			request.setAttribute("DeliveryDateValue", deliveryDate);
		}
		
		
		
		RequestDispatcher rd = null;
		if (isError == true) 
		{
			request.setAttribute("QuotationBean", bean);
			rd = request.getRequestDispatcher("EditQuotation.jsp");
		} 
		else
		{
			dao = new QuotationDao();
			if (dao.updateQuotation(bean)) {
				System.out.println("done...");
				rd = request.getRequestDispatcher("ListQuotationServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);

	}
}
