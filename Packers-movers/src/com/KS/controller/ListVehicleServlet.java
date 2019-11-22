package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.VehicleBean;
import com.KS.dao.VehicleDao;

public class ListVehicleServlet extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		VehicleDao dao = new VehicleDao();
		ArrayList<VehicleBean> list = dao.listVehicle();
		request.setAttribute("VehicleList", list);
		request.getRequestDispatcher("ListVehicle.jsp").forward(request, response);
	}
}