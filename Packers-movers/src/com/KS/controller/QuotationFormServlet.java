package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.QuotationBean;
import com.KS.dao.QuotationDao;

public class QuotationFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String quotPrice = request.getParameter("quotPrice");
		String deliveryDate = request.getParameter("deliveryDate");
		QuotationBean bean = new QuotationBean();

		boolean isError = false;

		if (quotPrice.trim().length() == 0) {
			isError = true;
			request.setAttribute("QuotPriceError", "<font color='red'>Please Enter Quotation Price</font>");
		}
		/*else 
		{
			for(int i=0;i<name.trim().length();i++)
			{
				if(name.charAt(i)>0 && name.charAt(i)<9)
				{	
					isError = true;
					request.setAttribute("nameError", "<font color='red'>Please Enter valid name</font>");
				}
			}
		}*/
		else
		{
			bean.setQuotPrice(quotPrice);
			request.setAttribute("QuotPriceValue", quotPrice);
		}
		
		if (deliveryDate.trim().length() == 0) {
			isError = true;
			request.setAttribute("DeliveryDateError", "<font color='red'>Please Enter Delivery Date</font>");
		}
		/*else 
		{
			for(int i=0;i<name.trim().length();i++)
			{
				if(name.charAt(i)>0 && name.charAt(i)<9)
				{	
					isError = true;
					request.setAttribute("nameError", "<font color='red'>Please Enter valid name</font>");
				}
			}
		}*/
		else
		{
			bean.setDeliveryDate(deliveryDate);
			request.setAttribute("DeliveryDateValue",deliveryDate);
		}
		
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("QuotationForm.jsp");
		}
		else 
		{
			QuotationDao dao = new QuotationDao();
			if (dao.insertQuotation(bean)) {
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
