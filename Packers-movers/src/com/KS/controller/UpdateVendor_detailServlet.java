package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.UserBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.UserDao;
import com.KS.dao.Vendor_detailDao;

public class UpdateVendor_detailServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String vendor_detailId=request.getParameter("vendor_detailId");
		String address = request.getParameter("address");
		String maxVehicle=request.getParameter("maxVehicle");
		String license = request.getParameter("license");
		String companyName=request.getParameter("companyName");
		
		Vendor_detailBean bean = new Vendor_detailBean();
		boolean isError = false;

		Vendor_detailDao dao=new Vendor_detailDao();
		bean=dao.getDataByPk(vendor_detailId);
		
		bean.setVendorDetailId(vendor_detailId);

		if (address.trim().length() == 0) {
			isError = true;
			request.setAttribute("AddressError", "<font color='red'>Please Enter address</font>");
		}
		else
		{
			bean.setAddress(address);
			request.setAttribute("AddressValue", address);
		}
		
		
		if (maxVehicle.trim().length() == 0) {
			isError = true;
			request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter no of vehicles</font>");
		} 
		else 
		{
			int flag=0;
			for(int i=0;i<maxVehicle.trim().length();i++)
			{    
				
				if( !(maxVehicle.charAt(i)>=48 && maxVehicle.charAt(i)<=57))  
				{	
					isError = true;
					request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter valid no. of vehicles</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				bean.setMaxVehicle(maxVehicle);
				request.setAttribute("MaxVehicleValue", maxVehicle);
			}
		}

		
		if (companyName.trim().length() == 0) {
			isError = true;
			request.setAttribute("CompanyNameError", "<font color='red'>Please Enter company Name</font>");
		} 
		else 
		{
			bean.setCompanyName(companyName);
			request.setAttribute("CompanyNameValue", companyName);
		}

		bean.setLicense(bean.getLicense());
		
		

		RequestDispatcher rd = null;
		if (isError == true)
		{
			request.setAttribute("Vendor_detailBean", bean);
			rd = request.getRequestDispatcher("EditVendor_detail.jsp");
		} 
		else
		{
			dao = new Vendor_detailDao();
			if (dao.updateVendor_detail(bean)) {
				rd = request.getRequestDispatcher("ListVendor_detailServlet");
			} 
			else
			{
				request.setAttribute("Vendor_detailBean", bean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
