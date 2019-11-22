package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;

public class UpdateProfileServlet extends HttpServlet {

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
		
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("UserBean");
		
		//UserBean bean = new UserBean();

		boolean isError = false;

		UserDao dao = new UserDao();
		userBean = dao.getDataByPk(userId);
		userBean.setUserId(userId);
		
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
				userBean.setUserName(name);
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
				userBean.setPhoneNo(phoneNo);;
				request.setAttribute("PhoneNoValue", phoneNo);
			}
		}

		if (password.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter Password</font>");
		} 
		else if( password.trim().length()<8)
		{
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter minimum 8 characters</font>");
		}
		else
		{
			userBean.setUserPassword(password);
		}

		if (emailId.trim().length() == 0) {
			isError = true;
			request.setAttribute("EmailError", "<font color='red'>Please Enter Email</font>");
		} 
		else
		{
			userBean.setUserEmail(emailId);
			request.setAttribute("EmailValue", emailId);
		}
		
		
		if (answer.trim().length() == 0) {
			isError = true;
			request.setAttribute("AnswerError", "<font color='red'>Please Enter your answer</font>");
		} 
		else
		{
			userBean.setAnswer(answer);
			request.setAttribute("AnswerValue", answer);
		}
	
				
		if(security_questionId == null || security_questionId.equals("-1") ){
			isError = true;
			request.setAttribute("Security_questionIdError", "<font color='red'>Please select security question</font>");
		}else{
			userBean.setSecurity_questionId(security_questionId);
		}
		
		userBean.setUserTypeId(userType);
			
		

		RequestDispatcher rd = null;
		if (isError == true)
		{
			request.setAttribute("UserBean", userBean);
			rd = request.getRequestDispatcher("profile.jsp");
		} 
		else
		{
			dao = new UserDao();
			if (dao.updateUser(userBean)) {
				session.setAttribute("UserBean",userBean);
				request.setAttribute("UserBean", userBean);
				rd = request.getRequestDispatcher("profile.jsp");
			} 
			else
			{
				request.setAttribute("UserBean", userBean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}