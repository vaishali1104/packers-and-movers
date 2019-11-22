package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.FeedbackBean;
import com.KS.dao.FeedbackDao;

public class EditFeedbackServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String feedId = request.getParameter("feedId");

		FeedbackDao dao = new FeedbackDao();
		FeedbackBean bean = dao.getDataByPk(feedId);
		
		RequestDispatcher rd = null;
		if(bean==null)
			rd=request.getRequestDispatcher("Error.jsp");
		else
		{
			rd = request.getRequestDispatcher("EditFeedback.jsp");
			request.setAttribute("FeedbackBean", bean);
		}
		rd.forward(request, response);
	}
}