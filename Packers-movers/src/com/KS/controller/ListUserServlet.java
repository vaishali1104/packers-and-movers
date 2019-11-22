package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;

public class ListUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao dao = new UserDao();

		ArrayList<UserBean> list = dao.listUser();
		
		request.setAttribute("userList", list);
		request.getRequestDispatcher("ListUser.jsp").forward(request, response);
	}
}