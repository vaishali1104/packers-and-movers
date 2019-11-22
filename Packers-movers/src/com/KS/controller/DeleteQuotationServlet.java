package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.QuotationDao;

public class DeleteQuotationServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String quotId = request.getParameter("quotId");

		QuotationDao dao = new QuotationDao();
		if (dao.deleteQuotation(quotId)) {
			response.sendRedirect("ListQuotationServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}