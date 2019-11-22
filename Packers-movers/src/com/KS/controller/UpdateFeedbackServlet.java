package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.FeedbackBean;
import com.KS.dao.FeedbackDao;

public class UpdateFeedbackServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String feedId=request.getParameter("feedId");
		String description = request.getParameter("description");
		FeedbackBean bean = new FeedbackBean();

		boolean isError = false;
		
		FeedbackDao dao=new FeedbackDao();
		bean=dao.getDataByPk(feedId);

		bean.setFeedId(feedId);
						

		if (description.trim().length() == 0 || description.trim().length() >50)
		{
			isError = true;
			request.setAttribute("DescriptionError", "<font color='red'>Please Enter proper description</font>");
		}
		
		else {
			bean.setDescription(description);
			request.setAttribute("DescriptionValue", description);
		}
		
/*
		if (user == null || user.equals("-1")) 
		{
			isError = true;
			request.setAttribute("UserIdError", "<font color='red'>Please select User</font>");
		} else {
			bean.setUserId(user);
		}
*/
		RequestDispatcher rd = null;
		if (isError == true) {
			request.setAttribute("FeedbackBean", bean);
			rd = request.getRequestDispatcher("EditFeedback.jsp");
		} 
		else
		{
			dao = new FeedbackDao();
			if (dao.updateFeedback(bean)) {
				System.out.println("done...");
				rd = request.getRequestDispatcher("ListFeedbackServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}