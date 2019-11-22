package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.HaulageDao;
import com.KS.dao.UserDao;

public class DeleteHaulageServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String haulId = request.getParameter("haulId");

		HaulageDao dao = new HaulageDao();
		if (dao.deleteHaulage(haulId)) {
			response.sendRedirect("ListHaulageServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
