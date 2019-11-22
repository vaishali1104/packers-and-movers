package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.HouseholdDao;
import com.KS.dao.Vendor_detailDao;

public class HouseholdFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String houseType = request.getParameter("houseType");
		
		
		HouseholdBean bean = new HouseholdBean();

		boolean isError = false;

		if (houseType.trim().length() == 0) {
			isError = true;
			request.setAttribute("HouseTypeError", "<font color='red'>Please Enter House type</font>");
		}
		else 
		{ 
			int flag=0;
			for(int i=0;i<houseType.trim().length();i++)
			{    
				if( (houseType.charAt(i)>=33 && houseType.charAt(i)<=48) || (houseType.charAt(i)>=54 && houseType.charAt(i)<=64) || (houseType.charAt(i)>=91 && houseType.charAt(i)<=96 ) || (houseType.charAt(i)>=123 && houseType.charAt(i)<=127 ) )
				{	
					isError = true;
					request.setAttribute("HouseTypeError", "<font color='red'>Please Enter valid House type</font>");
					flag=1;
					break;
				}
			}
				
			if(flag==0)
			{
				bean.setHouseType(houseType);
				request.setAttribute("HouseTypeValue", houseType);
			}
		}
				
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("HouseholdForm.jsp");
		}
		else 
		{
			HouseholdDao dao = new HouseholdDao();
			if (dao.insertHousehold(bean)) {
				rd = request.getRequestDispatcher("ListHouseholdServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
