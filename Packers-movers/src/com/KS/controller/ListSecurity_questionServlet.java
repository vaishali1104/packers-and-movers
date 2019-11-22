package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Security_questionBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.Security_questionDao;
import com.KS.dao.Vendor_detailDao;

public class ListSecurity_questionServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Security_questionDao dao = new Security_questionDao();
		ArrayList<Security_questionBean> list = dao.listSecurity_question();
		request.setAttribute("Security_questionList", list);
		request.getRequestDispatcher("ListSecurity_question.jsp").forward(request, response);
	}
}