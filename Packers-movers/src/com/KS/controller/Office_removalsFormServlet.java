package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.AnimalBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Office_removalsBean;
import com.KS.bean.VehicleBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.AnimalDao;
import com.KS.dao.HouseholdDao;
import com.KS.dao.Office_removalsDao;
import com.KS.dao.VehicleDao;
import com.KS.dao.Vendor_detailDao;

public class Office_removalsFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String officeType = request.getParameter("officeType");
		
		Office_removalsBean bean = new Office_removalsBean();

		boolean isError = false;
		if (officeType.trim().length() == 0) {
			isError = true;
			request.setAttribute("OfficeTypeError", "<font color='red'>Please Enter Office type</font>");
		}
		else 
		{ 
			int flag=0;
			for(int i=0;i<officeType.trim().length();i++)
			{    
				if( (officeType.charAt(i)>=33 && officeType.charAt(i)<=64) || (officeType.charAt(i)>=91 && officeType.charAt(i)<=96 ) || (officeType.charAt(i)>=123 && officeType.charAt(i)<=127 ) )
				{	
					isError = true;
					request.setAttribute("OfficeTypeError", "<font color='red'>Please Enter valid office type</font>");
					flag=1;
					break;
				}
			}
				
			if(flag==0)
			{
				bean.setOfficeType(officeType);
				request.setAttribute("OfficeTypeValue", officeType);
			}
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Office_removalsForm.jsp");
		}
		else 
		{
			Office_removalsDao dao = new Office_removalsDao();
			if (dao.insertOffice_removals(bean)) {
				rd = request.getRequestDispatcher("ListOffice_removalsServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}