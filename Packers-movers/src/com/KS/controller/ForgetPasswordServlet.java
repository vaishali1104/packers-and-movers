package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;


public class ForgetPasswordServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String emailId = request.getParameter("emailId");
		UserDao userDao = new UserDao();

		
		HttpSession session  = request.getSession();
		session.setAttribute("UserEmailId", emailId);
		
		
		UserBean userBean = userDao.getDataByEmail(emailId);
		RequestDispatcher rd = null;
		if (userBean == null) {
			request.setAttribute("EmailError", "<font color='red'> Invalid Email Address...</font>");
			rd = request.getRequestDispatcher("ForgetPassword.jsp");
		} else {
			 session = request.getSession();
			session.setAttribute("UserBean", userBean);
			rd = request.getRequestDispatcher("SecurityQuestion.jsp");
		}
		rd.forward(request, response);
	}

}
