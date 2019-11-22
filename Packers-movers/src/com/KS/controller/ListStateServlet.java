package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.StateBean;
import com.KS.dao.StateDao;


public class ListStateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StateDao dao = new StateDao();

		ArrayList<StateBean> list = dao.listState();
		
		request.setAttribute("StateList", list);
		request.getRequestDispatcher("ListState.jsp").forward(request, response);
	}
}




