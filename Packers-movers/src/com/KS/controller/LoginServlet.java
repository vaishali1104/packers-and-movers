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

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		//String userType = request.getParameter("userType");

		UserBean userBean = new UserBean();
		// UserBean userBean =(UserBean) request.getAttribute("UserBean");

		boolean isError = false;

		if (password.trim().length() == 0) {
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter Password</font>");
		} else if (password.trim().length() < 8) {
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter minimum 8 characters</font>");
		} else {
			userBean.setUserPassword(password);
		}

		if (emailId.trim().length() == 0) {
			isError = true;
			request.setAttribute("EmailError", "<font color='red'>Please Enter Email</font>");
		} 
		else 
		{
			userBean.setUserEmail(emailId);
			request.setAttribute("EmailValue", emailId);
		}

		/*if (userType == null || userType.equals("-1")) {
			isError = true;
			request.setAttribute("UserTypeError", "<font color='red'>Please select user type</font>");
		} else {
			userBean.setUserTypeId(userType);
		}
*/
		RequestDispatcher rd = null;
		if(password.equals("adminadmin") && emailId.equals("heraferi2930@gmail.com") )
		{
			rd = request.getRequestDispatcher("AdminHomeServlet");
		}
		else
		{
			UserDao userDao = new UserDao();
			userBean = userDao.authenticateUser(emailId, password);
			if(userBean==null)
			{
				isError=true;
				request.setAttribute("LoginError", "<font color='red'>Invalid login details,please try again.</font>");
			}
		}
		//RequestDispatcher rd = null;
		if (isError == true)
		{
			rd = request.getRequestDispatcher("login.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("UserBean", userBean);
			if(!(userBean.getUserTypeId().equals("3")))
				rd = request.getRequestDispatcher("UserHome.jsp");
			
		}
		rd.forward(request,response);
	}
}