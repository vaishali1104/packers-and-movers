package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.HouseholdDao;
import com.KS.dao.Vendor_detailDao;

public class ListHouseholdServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HouseholdDao dao = new HouseholdDao();

		ArrayList<HouseholdBean> list = dao.listHousehold();
		
		request.setAttribute("HouseholdList", list);
		request.getRequestDispatcher("ListHousehold.jsp").forward(request, response);
	}
}