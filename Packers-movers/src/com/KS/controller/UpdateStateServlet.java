package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.StateBean;
import com.KS.bean.UserTypeBean;
import com.KS.dao.StateDao;
import com.KS.dao.UserTypeDao;

public class UpdateStateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String stateId=request.getParameter("stateId");
		String stateName = request.getParameter("stateName");
		//System.out.println(stateName);
		StateBean bean = new StateBean();

		boolean isError = false;

		bean.setStateId(stateId);
		
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
				//	System.out.println("Inside loop");
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
			request.setAttribute("StateBean", bean);
			//System.out.println("Inside if");
			rd = request.getRequestDispatcher("EditState.jsp");
		} 
		else
		{
			StateDao dao = new StateDao();
			if (dao.updateState(bean)) {
				request.setAttribute("StateBean", bean);
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
