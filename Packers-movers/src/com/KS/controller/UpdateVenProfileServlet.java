package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.UserBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.UserDao;
import com.KS.dao.Vendor_detailDao;

public class UpdateVenProfileServlet extends HttpServlet {

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
		
		
		String vendor_detailId=request.getParameter("vendor_detailId");
		
		
		String maxVehicle=request.getParameter("maxVehicle");
		String license = request.getParameter("license");
		String companyName=request.getParameter("companyName");
		String address=request.getParameter("address");

		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("UserBean");
		
		//UserBean bean = new UserBean();
		Vendor_detailBean vbean = new Vendor_detailBean();
		
		boolean isError = false;

		UserDao dao = new UserDao();
		userBean = dao.getDataByPk(userId);
		userBean.setUserId(userId);
		
	
		Vendor_detailDao vdao=new Vendor_detailDao();
		vbean=vdao.getDataByPk(vendor_detailId);
		vbean.setVendorDetailId(vendor_detailId);
		
		
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
	
				
		if(security_questionId == null || security_questionId.equals("-1") )
		{
			isError = true;
			System.out.println("security Quest5ion:"+security_questionId);
			request.setAttribute("Security_questionIdError", "<font color='red'>Please select security question</font>");
		}else{
			userBean.setSecurity_questionId(security_questionId);
		}
		
		userBean.setUserTypeId(userType);
			


		if (address.trim().length() == 0) {
			isError = true;
			request.setAttribute("AddressError", "<font color='red'>Please Enter address</font>");
		}
		else
		{
			vbean.setAddress(address);
			request.setAttribute("AddressValue", address);
		}
		
		
		if (maxVehicle.trim().length() == 0) {
			isError = true;
			request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter no of vehicles</font>");
		} 
		/*else
		{	for(int i=0;i<phoneNo.trim().length();i++)
			{
				if((phoneNo.charAt(i)>=65 && phoneNo.charAt(i)<=90) || (phoneNo.charAt(i)>=97 && phoneNo.charAt(i)<=122))
				{
					isError = true;
					request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
				}
			}
		}*/
		else 
		{
			
			int flag=0;
			for(int i=0;i<maxVehicle.trim().length();i++)
			{    
				
				if( !(maxVehicle.charAt(i)>=48 && maxVehicle.charAt(i)<=57))  
				{	
					isError = true;
					request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter valid no. of vehicles</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				vbean.setMaxVehicle(maxVehicle);
				request.setAttribute("MaxVehicleValue", maxVehicle);
			}
		}

	
		if (companyName.trim().length() == 0) {
			isError = true;
			request.setAttribute("CompanyNameError", "<font color='red'>Please Enter company Name</font>");
		} 
		else 
		{
			vbean.setCompanyName(companyName);
			request.setAttribute("CompanyNameValue", companyName);
		}

		vbean.setLicense(vbean.getLicense());
		
			
		
		RequestDispatcher rd = null;
		if (isError == true)
		{
			request.setAttribute("UserBean", userBean);
			request.setAttribute("Vendor_detailBean", vbean);
			rd = request.getRequestDispatcher("profile_vendor.jsp");
		} 
		else
		{
			int flag=0;
			dao = new UserDao();
			if (dao.updateUser(userBean)) 
			{
				request.setAttribute("SucessMessage","<font size='20' color='green'><b>Sucessfully updated</b></font>");
				session.setAttribute("UserBean",userBean);
				request.setAttribute("UserBean", userBean);
				
				rd = request.getRequestDispatcher("profile_vendor.jsp");
			} 
			else
			{
				flag=1;
				request.setAttribute("UserBean", userBean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
			
			
			vdao = new Vendor_detailDao();
			if (vdao.updateVendor_detail(vbean)) 
			{
				request.setAttribute("SucessMessage","<font size='20.5' color='blue'><b>Sucessfully updated</b></font>");
				request.setAttribute("Vendor_detailBean", vbean);
				if(flag==0)
					rd = request.getRequestDispatcher("profile_vendor.jsp");
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