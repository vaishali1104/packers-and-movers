package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.FeedbackBean;
import com.KS.dao.FeedbackDao;

public class ListFeedbackServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		FeedbackDao dao = new FeedbackDao();

		ArrayList<FeedbackBean> list = dao.listFeedback();
		
		request.setAttribute("FeedbackList", list);
		request.getRequestDispatcher("ListFeedback.jsp").forward(request, response);
	}
}