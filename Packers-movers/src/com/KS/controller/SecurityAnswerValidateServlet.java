package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.UserBean;

public class SecurityAnswerValidateServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String answer = request.getParameter("answer");

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		RequestDispatcher rd = null;
		if(answer.trim().length()==0)
		{
			request.setAttribute("AnswerError", "<font color='red'>please Enter your answer!</font>");
			rd = request.getRequestDispatcher("SecurityQuestion.jsp");
		}
		if (answer.equals(userBean.getAnswer())) 
		{
			rd = request.getRequestDispatcher("UpdatePassword.jsp");
		}
		else
		{
			request.setAttribute("AnswerError", "<font color='red'>Invalid answer!</font>");
			rd = request.getRequestDispatcher("SecurityQuestion.jsp");
		}
		rd.forward(request, response);
	}
}