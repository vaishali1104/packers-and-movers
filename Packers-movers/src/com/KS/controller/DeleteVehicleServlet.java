package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.AnimalDao;
import com.KS.dao.HouseholdDao;
import com.KS.dao.UserDao;
import com.KS.dao.VehicleDao;
import com.KS.dao.Vendor_detailDao;

public class DeleteVehicleServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vehicleId = request.getParameter("vehicleId");

		VehicleDao dao = new VehicleDao();
		if (dao.deleteVehicle(vehicleId))
		{
			response.sendRedirect("ListVehicleServlet");
		}
		else 
		{
			response.sendRedirect("Error.jsp");
		}
	}
}