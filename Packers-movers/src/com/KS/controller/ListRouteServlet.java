package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.RouteBean;
import com.KS.dao.RouteDao;

public class ListRouteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RouteDao dao = new RouteDao();

		ArrayList<RouteBean> list = dao.listRoute();
		
		request.setAttribute("RouteList", list);
		request.getRequestDispatcher("ListRoute.jsp").forward(request, response);
		
		
		
	}

}




