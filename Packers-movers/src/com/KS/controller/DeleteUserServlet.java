package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.UserDao;

public class DeleteUserServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		UserDao dao = new UserDao();
		if (dao.deleteUser(userId)) {
			response.sendRedirect("ListUserServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
