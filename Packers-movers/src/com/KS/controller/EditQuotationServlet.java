package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.QuotationBean;
import com.KS.dao.QuotationDao;

public class EditQuotationServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String quotId = request.getParameter("quotId");

		QuotationDao dao = new QuotationDao();

		QuotationBean bean = dao.getDataByPk(quotId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditQuotation.jsp");
			request.setAttribute("QuotationBean", bean);
		}
		rd.forward(request, response);
	}
}