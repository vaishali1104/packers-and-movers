package com.KS.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Office_removalsBean;
import com.KS.dao.Office_removalsDao;

public class EditOffice_removalsServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String  officeId = request.getParameter("officeId");
		Office_removalsDao dao = new Office_removalsDao();
		Office_removalsBean bean = dao.getDataByPk(officeId);
		RequestDispatcher rd = null;
		if (bean == null)
		{
			rd = request.getRequestDispatcher("Error.jsp");
		} 
		else
		{
			rd = request.getRequestDispatcher("EditOffice_removals.jsp");
			request.setAttribute("Office_removalsBean", bean);
		}
		rd.forward(request, response);
	}
}