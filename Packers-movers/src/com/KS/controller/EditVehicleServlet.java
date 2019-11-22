package com.KS.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.VehicleBean;
import com.KS.dao.VehicleDao;

public class EditVehicleServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String  vehicleId = request.getParameter("vehicleId");
		VehicleDao dao = new VehicleDao();
		VehicleBean bean = dao.getDataByPk(vehicleId);
		RequestDispatcher rd = null;
		if (bean == null)
		{
			rd = request.getRequestDispatcher("Error.jsp");
		} 
		else
		{
			rd = request.getRequestDispatcher("EditVehicle.jsp");
			request.setAttribute("VehicleBean", bean);
		}
		rd.forward(request, response);
	}
}