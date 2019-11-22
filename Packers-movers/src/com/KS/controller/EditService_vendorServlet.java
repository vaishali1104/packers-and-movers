package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Service_vendorBean;
import com.KS.dao.Service_vendorDao;

public class EditService_vendorServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ser_venId = request.getParameter("ser_venId");

		Service_vendorDao dao = new Service_vendorDao();

		Service_vendorBean bean = dao.getDataByPk(ser_venId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditService_vendor.jsp");
			request.setAttribute("Service_vendorBean", bean);
		}
		rd.forward(request, response);
	}
}