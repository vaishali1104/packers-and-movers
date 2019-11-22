package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.QuotationBean;
import com.KS.dao.QuotationDao;

public class ListQuotationServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		QuotationDao dao = new QuotationDao();

		ArrayList<QuotationBean> list = dao.listQuotation();
		
		request.setAttribute("QuotationList", list);
		request.getRequestDispatcher("ListQuotation.jsp").forward(request, response);
	}
}