package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.ServiceBean;
import com.KS.bean.UserBean;
import com.KS.bean.UserTypeBean;
import com.KS.dao.ServiceDao;
import com.KS.dao.UserDao;
import com.KS.dao.UserTypeDao;

public class EditServiceServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String serviceId = request.getParameter("serviceId");

		ServiceDao dao = new ServiceDao();

		ServiceBean bean = dao.getDataByPk(serviceId);
		RequestDispatcher rd = null;
		if (bean == null)
		{
			rd = request.getRequestDispatcher("Error.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("EditService.jsp");
			request.setAttribute("ServiceBean", bean);
		}
		rd.forward(request, response);
	}
}
