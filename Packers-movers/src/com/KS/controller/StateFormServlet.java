package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.StateBean;
import com.KS.dao.StateDao;

public class StateFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stateName = request.getParameter("stateName");
		
		StateBean bean = new StateBean();

		boolean isError = false;

		
		if (stateName.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("StateNameError", "<font color='red'>Please Enter name</font>");
		}
		else
		{
            int flag=0;
			for(int i=0;i<stateName.trim().length();i++)
			{    
				
				if( (stateName.charAt(i)>=33 && stateName.charAt(i)<=64) || (stateName.charAt(i)>=91 && stateName.charAt(i)<=96) || (stateName.charAt(i)>=123 && stateName.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("StateNameError", "<font color='red'>Please Enter valid name</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				bean.setStateName(stateName);
				request.setAttribute("StateNameValue", stateName);
			}
		}
		
			
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("StateForm.jsp");
		}
		else 
		{
			StateDao dao = new StateDao();
			if (dao.insertState(bean)) {
				rd = request.getRequestDispatcher("ListStateServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
