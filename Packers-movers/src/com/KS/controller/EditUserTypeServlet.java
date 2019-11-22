package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.UserBean;
import com.KS.bean.UserTypeBean;
import com.KS.dao.UserDao;
import com.KS.dao.UserTypeDao;

public class EditUserTypeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userTypeId = request.getParameter("userTypeId");

		UserTypeDao dao = new UserTypeDao();

		UserTypeBean bean = dao.getDataByPk(userTypeId);
		RequestDispatcher rd = null;
		if (bean == null)
		{
			rd = request.getRequestDispatcher("Error.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("EditUserType.jsp");
			request.setAttribute("UserTypeBean", bean);
		}
		rd.forward(request, response);

	}

}
