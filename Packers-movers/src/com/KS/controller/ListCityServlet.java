package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.CityBean;
import com.KS.dao.CityDao;


public class ListCityServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		CityDao dao = new CityDao();

		ArrayList<CityBean> list = dao.listCity();
		
		request.setAttribute("CityList", list);
		request.getRequestDispatcher("ListCity.jsp").forward(request, response);
	}
}




