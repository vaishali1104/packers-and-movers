package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.HaulageBean;
import com.KS.dao.HaulageDao;

public class ListHaulageServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HaulageDao dao = new HaulageDao();
		ArrayList<HaulageBean> list = dao.listHaulage();
		request.setAttribute("HaulageList", list);
		request.getRequestDispatcher("ListHaulage.jsp").forward(request, response);
	}
}