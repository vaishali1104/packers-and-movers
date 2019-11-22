package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.H_HouseholdBean;
import com.KS.bean.H_Office_removalsBean;
import com.KS.bean.H_VehicleBean;
import com.KS.bean.HaulageBean;
import com.KS.bean.UserBean;

import com.KS.dao.H_HouseholdDao;
import com.KS.dao.H_Office_removalsDao;
import com.KS.dao.H_VehicleDao;
import com.KS.dao.HaulageDao;
import com.KS.dao.UserDao;
import com.KS.util.DbConnection;

public class ShowUserDetailsServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		String haulId=request.getParameter("haul_id");
	
		
		UserBean userBean=null;
		HaulageBean haulageBean=null;
		
		HaulageDao haulageDao=new HaulageDao();
		haulageBean=haulageDao.getDataByPk(haulId);
		
		UserDao udao=new UserDao();
		userBean=udao.getDataByPk(haulageBean.getCustId());
		
		H_HouseholdDao h_dao=new H_HouseholdDao();
		ArrayList<H_HouseholdBean> houselist=(ArrayList<H_HouseholdBean>)h_dao.getDataByHaulId(haulId);
	
		H_VehicleDao vehicledao=new H_VehicleDao();
		ArrayList<H_VehicleBean> vehiclelist=(ArrayList<H_VehicleBean>)vehicledao.getDataByHaulId(haulId);
		
		H_Office_removalsDao officedao=new H_Office_removalsDao();
		ArrayList<H_Office_removalsBean> officelist=(ArrayList<H_Office_removalsBean>)officedao.getDataByHaulId(haulId);
		

					
		request.setAttribute("HaulageBean", haulageBean);
		request.setAttribute("UserBean", userBean);
		request.setAttribute("HouseList", houselist);
		request.setAttribute("VehicleList", vehiclelist);
		
		request.setAttribute("OfficeList", officelist);
		request.getRequestDispatcher("Details_vendor.jsp").forward(request, response);
	
	}
}
