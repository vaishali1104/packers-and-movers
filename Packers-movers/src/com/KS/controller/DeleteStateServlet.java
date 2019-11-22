package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.StateDao;


public class DeleteStateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stateId = request.getParameter("stateId");

		StateDao dao = new StateDao();
		if (dao.deleteState(stateId)) {
			response.sendRedirect("ListStateServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
