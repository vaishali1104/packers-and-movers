package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.RouteBean;
import com.KS.bean.UserBean;
import com.KS.dao.CityDao;
import com.KS.dao.RouteDao;
import com.KS.dao.UserDao;

public class UpdateRouteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String routeId = request.getParameter("routeId");
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String routeVia = request.getParameter("routeVia");
		String city = request.getParameter("city");
		RouteBean bean = new RouteBean();

		boolean isError = false;

		RouteDao dao = new RouteDao();
		bean = dao.getDataByPk(routeId);
		
		bean.setRouteId(routeId);
		
		if (origin.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("OriginError", "<font color='red'>Please Enter Origin</font>");
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
		else {
			bean.setOrigin(origin);
			request.setAttribute("OriginValue", origin);
		}
		

		if (destination.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("DestinationError", "<font color='red'>Please Enter Destination</font>");
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
			bean.setDestination(destination);
			request.setAttribute("DestinationValue", destination);
		}
		
		
		if (routeVia.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("RouteViaError", "<font color='red'>Please Enter Route</font>");
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
			bean.setRouteVia(routeVia);
			request.setAttribute("RouteViaValue", routeVia);
		}
		
		
		if (city == null || city.trim().equals("-1")) 
		{
			isError = true;
			request.setAttribute("CityIdError", "<font color='red'>Please select city</font>");
		} else {
			bean.setCityId(city);
		}

		RequestDispatcher rd = null;
		if (isError == true) {
			request.setAttribute("RouteBean", bean);
			rd = request.getRequestDispatcher("EditRoute.jsp");
		} 
		else
		{
			dao = new RouteDao();
			if (dao.updateRoute(bean)) {
				rd = request.getRequestDispatcher("ListRouteServlet");
			} 
			else
			{
				request.setAttribute("RouteBean", bean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);

	}
}
