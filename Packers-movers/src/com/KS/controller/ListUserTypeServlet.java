package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.KS.bean.UserTypeBean;
import com.KS.dao.UserTypeDao;

public class ListUserTypeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserTypeDao dao = new UserTypeDao();

		ArrayList<UserTypeBean> list = dao.listUserType();
		
		request.setAttribute("UserTypeList", list);
		request.getRequestDispatcher("ListUserType.jsp").forward(request, response);
		
		
		
	}

}




