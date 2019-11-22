package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.CityBean;
import com.KS.dao.CityDao;


public class EditCityServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityId = request.getParameter("cityId");

		CityDao dao = new CityDao();

		CityBean bean = dao.getDataByPk(cityId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditCity.jsp");
			request.setAttribute("CityBean", bean);
		}
		rd.forward(request, response);

	}

}
