package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Vendor_detailBean;
import com.KS.dao.Vendor_detailDao;

public class EditVendor_detailServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vendor_detailId = request.getParameter("vendor_detailId");

		Vendor_detailDao dao = new Vendor_detailDao();

		Vendor_detailBean bean = dao.getDataByPk(vendor_detailId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditVendor_detail.jsp");
			request.setAttribute("Vendor_detailBean", bean);
		}
		rd.forward(request, response);
	}
}
