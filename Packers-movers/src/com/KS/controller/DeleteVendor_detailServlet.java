package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.UserDao;
import com.KS.dao.Vendor_detailDao;

public class DeleteVendor_detailServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vendor_detailId = request.getParameter("vendor_detailId");

		Vendor_detailDao dao = new Vendor_detailDao();
		if (dao.deleteVendor_detail(vendor_detailId)) {
			response.sendRedirect("ListVendor_detailServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}
