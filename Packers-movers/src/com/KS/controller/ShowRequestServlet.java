package com.KS.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.HaulageBean;
import com.KS.bean.QuotationBean;
import com.KS.bean.UserBean;
import com.KS.dao.HaulageDao;
import com.KS.dao.QuotationDao;
import com.KS.util.DbConnection;

public class ShowRequestServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	
				
		HttpSession session=request.getSession();
		UserBean userBean1=(UserBean) session.getAttribute("UserBean");
		
		QuotationDao dao=new QuotationDao();
		HaulageDao hdao=new HaulageDao();
		
		ArrayList<HaulageBean> list2 =hdao.getVenQuotationRequestHaulage(); 
		ArrayList<QuotationBean> listQuot=dao.getVenPendingQuotation(userBean1.getUserId());
		ArrayList<QuotationBean> listQuot1=dao.getVenApprovedQuotation(userBean1.getUserId());
		ArrayList<QuotationBean> deliverList=dao.getVenDeliveredQuotation(userBean1.getUserId());

		request.setAttribute("QuotationRequestList", list2);
		request.setAttribute("PendingQuotList",listQuot);
		request.setAttribute("ApprovedQuotList", listQuot1);
		request.setAttribute("DeliveredQuotList", deliverList);
		
		request.getRequestDispatcher("VendorHome.jsp").forward(request, response);
	}
}
