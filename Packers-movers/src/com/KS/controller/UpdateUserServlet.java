package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;

public class UpdateUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userId=request.getParameter("userId");
		String name = request.getParameter("name");
		String phoneNo=request.getParameter("phoneNo");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String security_questionId=request.getParameter("security_questionId");
		String answer = request.getParameter("answer");
		UserBean bean = new UserBean();

		boolean isError = false;

		UserDao dao = new UserDao();
		bean = dao.getDataByPk(userId);
		bean.setUserId(userId);
		
		if (name.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("NameError", "<font color='red'>Please Enter name</font>");
		}
		else
		{
            int flag=0;
			for(int i=0;i<name.trim().length();i++)
			{    
				
				if( (name.charAt(i)>=33 && name.charAt(i)<=64) || (name.charAt(i)>=91 && name.charAt(i)<=96) || (name.charAt(i)>=123 && name.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("NameError", "<font color='red'>Please Enter valid name</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				bean.setUserName(name);
				request.setAttribute("NameValue", name);
			}
		}
		
		
		if (phoneNo.trim().length() == 0 || phoneNo.trim().length()!=10) {
			isError = true;
			request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
		} 
		else 
		{
			int flag=0;
			for(int i=0;i<phoneNo.trim().length();i++)
			{
				if( !(phoneNo.charAt(i)>=48 && phoneNo.charAt(i)<=57) )
				{
					isError = true;
					flag=1;
					request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
				}
			}
			
			if(flag==0)
			{
				bean.setPhoneNo(phoneNo);;
				request.setAttribute("PhoneNoValue", phoneNo);
			}
		}

		if (emailId.trim().length() == 0) {
			isError = true;
			request.setAttribute("EmailError", "<font color='red'>Please Enter Email</font>");
		} 
		else
		{
			bean.setUserEmail(emailId);
			request.setAttribute("EmailValue", emailId);
		}
		
		bean.setUserPassword(password);
		bean.setAnswer(answer);
		bean.setUserTypeId(userType);
		bean.setSecurity_questionId(security_questionId);
	

		RequestDispatcher rd = null;
		if (isError == true)
		{
			request.setAttribute("UserBean", bean);
			rd = request.getRequestDispatcher("EditUser.jsp");
		} 
		else
		{
			dao = new UserDao();
			if (dao.updateUser(bean)) {
				rd = request.getRequestDispatcher("ListUserServlet");
			} 
			else
			{
				request.setAttribute("UserBean", bean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
