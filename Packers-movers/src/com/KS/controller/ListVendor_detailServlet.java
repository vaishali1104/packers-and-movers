package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Vendor_detailBean;
import com.KS.dao.Vendor_detailDao;

public class ListVendor_detailServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Vendor_detailDao dao = new Vendor_detailDao();
		ArrayList<Vendor_detailBean> list = dao.listVendor_detail();
		request.setAttribute("Vendor_detailList", list);
		request.getRequestDispatcher("ListVendor_detail.jsp").forward(request, response);
	}
}