package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.StateBean;
import com.KS.dao.StateDao;



public class EditStateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stateId = request.getParameter("stateId");

		StateDao dao = new StateDao();

		StateBean bean = dao.getDataByPk(stateId);
		RequestDispatcher rd = null;
		if (bean == null) {
			rd = request.getRequestDispatcher("Error.jsp");
		} else {
			rd = request.getRequestDispatcher("EditState.jsp");
			request.setAttribute("StateBean", bean);
		}
		rd.forward(request, response);

	}

}
