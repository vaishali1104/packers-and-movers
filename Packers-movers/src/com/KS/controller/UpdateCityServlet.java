package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.CityBean;
import com.KS.bean.UserBean;
import com.KS.dao.CityDao;
import com.KS.dao.UserDao;

public class UpdateCityServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cityId = request.getParameter("cityId");
		String cityName = request.getParameter("cityName");
		String stateId = request.getParameter("state");
		CityBean bean = new CityBean();

		boolean isError = false;
		CityDao daoC = new CityDao();
		bean = daoC.getDataByPk(cityId);
		
		if (cityName.trim().length() == 0) {
			isError = true;
			request.setAttribute("CityNameError", "<font color='red'>Please Enter City Name</font>");
		}
		else 
		{ 
			int flag=0;
			for(int i=0;i<cityName.trim().length();i++)
			{    
				if( (cityName.charAt(i)>=33 && cityName.charAt(i)<=64) || (cityName.charAt(i)>=91 && cityName.charAt(i)<=96) || (cityName.charAt(i)>=123 && cityName.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("CityNameError", "<font color='red'>Please Enter valid City name</font>");
					flag=1;
					break;
				}
			}
				
			if(flag==0)
			{
				bean.setCityName(cityName);
				request.setAttribute("CityNameValue", cityName);
			}
		}
		 
		if (stateId == null || stateId.equals("-1")) {
			isError = true;
			request.setAttribute("StateIdError", "<font color='red'>Please select State</font>");
		} 
		else
		{
			bean.setStateId(stateId);
		}
		RequestDispatcher rd = null;
		if (isError == true) {
			request.setAttribute("CityBean", bean);
			rd = request.getRequestDispatcher("EditCity.jsp");
		} 
		else
		{
			CityDao dao = new CityDao();
			if (dao.updateCity(bean)) {
				System.out.println("done...");
				rd = request.getRequestDispatcher("ListCityServlet");
			} else {
				request.setAttribute("CityBean", bean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);

	}
}
