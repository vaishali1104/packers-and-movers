package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.FeedbackDao;

public class DeleteFeedbackServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String feedId = request.getParameter("feedId");

		FeedbackDao dao = new FeedbackDao();
		if (dao.deleteFeedback(feedId)) {
			response.sendRedirect("ListFeedbackServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}