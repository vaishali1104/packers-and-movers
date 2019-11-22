package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.RouteDao;


public class DeleteRouteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String routeId = request.getParameter("routeId");

		RouteDao dao = new RouteDao();
		if (dao.deleteRoute(routeId)) {
			response.sendRedirect("ListRouteServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
