package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Office_removalsBean;
import com.KS.dao.Office_removalsDao;

public class ListOffice_removalsServlet extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Office_removalsDao dao = new Office_removalsDao();
		ArrayList<Office_removalsBean> list = dao.listOffice_removals();
		request.setAttribute("Office_removalsList", list);
		request.getRequestDispatcher("ListOffice_removals.jsp").forward(request, response);
	}
}