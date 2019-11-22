package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.HaulageBean;
import com.KS.bean.UserBean;
import com.KS.dao.CityDao;
import com.KS.dao.HaulageDao;
import com.KS.dao.UserDao;

public class UpdateDelStatusServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String haulId=request.getParameter("haulId");
		String delStatus = request.getParameter("delStatus");
		HaulageBean haulBean = new HaulageBean();

		
		
		RequestDispatcher rd=null;
		boolean isError = false;
		System.out.println("delivery status:"+delStatus+"\n haulId:"+haulId);
		HaulageDao dao = new HaulageDao();
		if(dao.updateDeliveryStatus(haulId, delStatus))
			{
				request.setAttribute("DeliveryStatus", delStatus);
				rd = request.getRequestDispatcher("ShowRequestServlet");
				System.out.println("Delivery status updated");
			}
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
				System.out.println("Error::Delivery status not updated");
			}
		
		rd.forward(request, response);
	}
}
