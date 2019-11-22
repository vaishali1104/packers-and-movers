package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.RouteBean;
import com.KS.dao.RouteDao;


public class EditRouteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String routeId = request.getParameter("routeId");

		RouteDao dao = new RouteDao();

		RouteBean bean = dao.getDataByPk(routeId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditRoute.jsp");
			request.setAttribute("RouteBean", bean);
		}
		rd.forward(request, response);

	}

}
