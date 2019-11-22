package com.KS.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.KS.bean.UserBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.dao.Vendor_detailDao;

public class Vendor_detailFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Vendor_detailBean bean = new Vendor_detailBean();
		String address="";
		boolean isError = false;
		int flag=0,flag1=0,flag2=0,flag3=0,flag4=0,flag5=0;
		
		UserBean userBean=new UserBean();
		HttpSession session=request.getSession();
		userBean=(UserBean)session.getAttribute("UserBean");
		System.out.println("userBean=="+userBean);
		bean.setUserId(userBean.getUserId());
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try 
		{
			List<FileItem> listFile = sf.parseRequest(request);
			if (listFile != null)
			{
				for (FileItem item : listFile) 
				{
					try 
					{
						System.out.println("item ==> " + item.getFieldName() + " ==> " + item.getString());
						if (item.getName() != null) 
						{
							File f=new File("C:\\Users\\PALAL\\eclipse-workspace\\Project_final\\WebContent\\photos\\" + bean.getUserId());
							f.mkdir();
							item.write(new File("C:\\Users\\PALAL\\eclipse-workspace\\Project_final\\WebContent\\photos\\"+bean.getUserId()+"\\"+ item.getName()));
							
							String path = "C:\\Users\\PALAL\\eclipse-workspace\\Project_final\\WebContent\\photos\\"+ bean.getUserId()+"\\"+ item.getName();
							bean.setLicense(item.getName());
							System.out.println("file uploaded");
						} 
						else if(item.getFieldName().equals("streetAddress"))
						{
							String streetAddress=item.getString(); 
							if (streetAddress.trim().length() == 0) 
							{
								flag1=1;
								isError = true;
								request.setAttribute("StreetAddressError", "<font color='red'>Please fill all details</font>");
							} 
							else
								address = item.getString()+" ";
						}
						else if(item.getFieldName().equals("landmark"))
						{
							String landmark=item.getString(); 
							if (landmark.trim().length() == 0) 
							{
								flag3=1;
								isError = true;
								request.setAttribute("StreetAddressError", "<font color='red'>Please fill all details</font>");
							} 
							else
								address += item.getString()+" ";
						}
						else if(item.getFieldName().equals("city"))
						{
							String city=item.getString(); 
							if (city==null || city.equals("-1")) 
							{
								flag4=1;
								isError = true;
								request.setAttribute("CityError", "<font color='red'>Please Enter city</font>");
							} 
							else
							{						
								bean.setCity(item.getString());
								address += item.getString()+" ";
							}
						}
						else if(item.getFieldName().equals("state"))
						{
							//String state=item.getString(); 
							address += item.getString()+" ";
							
						}
						else if(item.getFieldName().equals("code"))
						{
							String code=item.getString(); 
							if (code.trim().length()==0 || code.trim().length()!=6) 
							{
								flag5=1;
								isError = true;
								request.setAttribute("CodeError", "<font color='red'>Please Enter valid Code</font>");
							} 
							else
							{						
								
								int flagC=0;
								for(int i=0;i<code.trim().length();i++)
								{    
									
									if( (!(code.charAt(i)>=48 && code.charAt(i)<=57))  || code.trim().length()!=6 )
									{	
										isError = true;
										request.setAttribute("CodeError", "<font color='red'>Please Enter valid Code</font>");
										flagC=1;
										break;
									}
								}
								
								if(flagC==0)
								{
									address += item.getString()+" ";
								}

														
								
								if(flag1==0 && flag2==0 && flag3==0 && flag4==0 && flag5==0 && flagC==0)
								{
									if (address.trim().length() == 0) {
										isError = true;
										request.setAttribute("AddressError", "<font color='red'>Please Enter address</font>");
									}
									else
									{
										bean.setAddress(address);
									
									}
								}
								else
								{
										flag=1;
								}
								
							}
						}
						else if (item.getFieldName().equals("maxVehicle"))
						{
							String maxVehicle=item.getString(); 
							if (maxVehicle.trim().length() == 0) {
								isError = true;
								request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter no of vehicles</font>");
							} 
							else
							{
								int flag6=0;
								for(int i=0;i<maxVehicle.trim().length();i++)
								{    
									
									if( !(maxVehicle.charAt(i)>=48 && maxVehicle.charAt(i)<=57))  
									{	
										isError = true;
										request.setAttribute("MaxVehicleError", "<font color='red'>Please Enter valid no. of vehicles</font>");
										flag6=1;
										break;
									}
								}
								
								if(flag6==0)
								{
									bean.setMaxVehicle(maxVehicle);
									request.setAttribute("MaxVehicleValue", maxVehicle);
								}
							}
						}
						else if (item.getFieldName().equals("companyName"))
						{
							String companyName=item.getString(); 
							if (companyName.trim().length() == 0) {
								isError = true;
								request.setAttribute("CompanyNameError", "<font color='red'>Please Enter Your Company name</font>");
							} 
							else 
							{
								bean.setCompanyName(item.getString());
								request.setAttribute("CompanyNameValue", companyName);
							}
						}
						else
						{
							System.out.println("in else part--------");
							String license=item.getString();
							if (license.trim().length() == 0)
							{
								isError = true;
								request.setAttribute("LicenseError", "<font color='red'>Please Enter License image</font>");
							} 
							
						}
						
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			} 
			else
			{
				System.out.println("not uploaded");
			}
			//String n = request.getParameter("userName");
			//System.out.println("name is => " + n);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		RequestDispatcher rd = null;
		if (isError == true || flag==1) {
			rd = request.getRequestDispatcher("Vendor_detailForm.jsp");
		}
		else 
		{
			Vendor_detailDao dao = new Vendor_detailDao();
			if (dao.insertVendor_detail(bean)) {
				rd = request.getRequestDispatcher("UserHome.jsp");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}