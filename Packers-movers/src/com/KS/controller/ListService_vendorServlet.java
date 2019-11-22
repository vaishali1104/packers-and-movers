package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Service_vendorBean;
import com.KS.dao.Service_vendorDao;

public class ListService_vendorServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Service_vendorDao dao = new Service_vendorDao();

		ArrayList<Service_vendorBean> list = dao.listService_vendor();
		
		request.setAttribute("Service_vendorList", list);
		request.getRequestDispatcher("ListService_vendor.jsp").forward(request, response);
	}
}