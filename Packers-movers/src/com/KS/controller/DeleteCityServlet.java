package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.CityDao;


public class DeleteCityServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityId = request.getParameter("cityId");

		CityDao dao = new CityDao();
		if (dao.deleteCity(cityId)) {
			response.sendRedirect("ListCityServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
