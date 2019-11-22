package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.ServiceBean;
import com.KS.bean.UserTypeBean;
import com.KS.dao.ServiceDao;
import com.KS.dao.UserTypeDao;

public class ListServiceServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceDao dao = new ServiceDao();

		ArrayList<ServiceBean> list = dao.listService();
		
		request.setAttribute("ServiceList", list);
		request.getRequestDispatcher("ListService.jsp").forward(request, response);
	}
}