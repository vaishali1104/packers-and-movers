package com.KS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.H_AnimalBean;
import com.KS.bean.H_FoodBean;
import com.KS.bean.H_HouseholdBean;
import com.KS.bean.H_Office_removalsBean;
import com.KS.bean.H_VehicleBean;
import com.KS.bean.HaulageBean;
import com.KS.bean.QuotationBean;
import com.KS.bean.UserBean;
import com.KS.dao.H_AnimalDao;
import com.KS.dao.H_FoodDao;
import com.KS.dao.H_HouseholdDao;
import com.KS.dao.H_Office_removalsDao;
import com.KS.dao.H_VehicleDao;
import com.KS.dao.HaulageDao;
import com.KS.dao.QuotationDao;

public class Customer3Servlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		boolean isError = false;
		int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0;
		int haul_id = 0;
		
		String vp = request.getParameter("vehiclePresent");
		//String fp = request.getParameter("foodPresent");
		String hp = request.getParameter("householdPresent");
		String op = request.getParameter("officePresent");
		//String pp = request.getParameter("petsPresent");

		String shipmentDate = request.getParameter("shipmentDate");
		String serviceType  = request.getParameter("serviceType");
		String haulTitle    = request.getParameter("haulTilte");
		
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = "Gujarat";
		String code = request.getParameter("code");

		//System.out.println("state::"+state);
		String dStreetAddress = request.getParameter("dStreetAddress");
		String dCity = request.getParameter("dCity");
		String dState ="Gujarat";
		String dCode = request.getParameter("dCode");
		String paddress="",daddress="";
		
		if (streetAddress.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("StreetAddressError", "<font color='red'>Please Enter Street address</font>");
		}
		else 
			request.setAttribute("StreetAddressValue",streetAddress);
		
		if(code.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("CodeError", "<font color='red'>Please Enter Postal/Zip Code</font>");
		}
		else
		{
			int flag=0;
			for(int i=0;i<code.trim().length();i++)
			{    
				
				if( (!(code.charAt(i)>=48 && code.charAt(i)<=57))  || code.trim().length()!=6 )
				{	
					isError = true;
					request.setAttribute("CodeError", "<font color='red'>Please Enter valid Code</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				request.setAttribute("CodeValue",code);
			}
		}
		
		if(city==null || city.equals("-1"))
		{
			isError = true;
			request.setAttribute("CityError", "<font color='red'>Please Select city</font>");
			
		}
		
		if(isError==false)
			paddress = streetAddress+", "+city+", "+state+" -"+code;
		
		if (dStreetAddress.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("DStreetAddressError", "<font color='red'>Please Enter Street address</font>");
		} 
		else
			request.setAttribute("DStreetAddressValue",dStreetAddress);
		
		if(dCode.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("DCodeError", "<font color='red'>Please Enter Postal/Zip Code</font>");
		}
		else
		{
			int flag=0;
			for(int i=0;i<dCode.trim().length();i++)
			{    
				
				if( (!(dCode.charAt(i)>=48 && dCode.charAt(i)<=57))  || dCode.trim().length()!=6 )
				{	
					isError = true;
					request.setAttribute("DCodeError", "<font color='red'>Please Enter valid Code</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				request.setAttribute("DCodeValue",dCode);
			}
		}
		
		if(dCity==null || city.equals("-1"))
		{
			isError = true;
			request.setAttribute("DCityError", "<font color='red'>Please Select city</font>");
			
		}
					
		if(isError==false)
		{
			daddress =dStreetAddress+", "+dCity+", "+dState+" -"+dCode;
		}
		

			
		
				
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		String userId = userBean.getUserId();
		

		HaulageBean haulageBean = new HaulageBean();

		if (shipmentDate.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("ShipmentDateError", "<font color='red'>Please Enter shipment date</font>");
		} else {
			haulageBean.setBookingDate(shipmentDate);
			request.setAttribute("ShipmentDateValue", shipmentDate);
		}

		haulageBean.setDeliveryDate("2018-3-24");
		haulageBean.setHaulStatus("estimate");

		if (serviceType == null || serviceType.equals("-1")) 
		{
			isError = true;
			request.setAttribute("ServiceTypeError", "<font color='red'>Please select service type</font>");
		} 
		else 
		{
			haulageBean.setServiceId(serviceType);
		}

		if (paddress.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("PickupLocError", "<font color='red'>Please Enter pickup Loc</font>");
		} else 
		{
			haulageBean.setPickupLoc(paddress);
			request.setAttribute("PickupLocValue", paddress);
		}

		if (daddress.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("DeliveryLocError", "<font color='red'>Please Enter Delivery Loc</font>");
		} else {
			haulageBean.setDeliveryLoc(daddress);
			request.setAttribute("DeliveryLocValue", daddress);
		}

		if (haulTitle.trim().length() == 0) 
		{
			isError = true;
			request.setAttribute("HaulTitleError", "<font color='red'>Please Enter Haulage Title</font>");
		} 
		else 
		{
			int flag=0;
			for(int i=0;i<haulTitle.trim().length();i++)
			{    
				
				if( (haulTitle.charAt(i)>=33 && haulTitle.charAt(i)<=47) || (haulTitle.charAt(i)>=58 && haulTitle.charAt(i)<=63))
				{	
					isError = true;
					request.setAttribute("HaulTitleError", "<font color='red'>Please Enter valid Haulage Title</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				haulageBean.setHaulTitle(haulTitle);
				request.setAttribute("HaulTitleValue", haulTitle);
			}
		}

		haulageBean.setCustId(userId);

		HaulageDao dao = new HaulageDao();
		RequestDispatcher rd=null;
		if(isError==true)
		{
			rd = request.getRequestDispatcher("customer3.jsp");
		}
		else
		{		
			if (dao.insertHaulage(haulageBean)) 
			{
				haul_id = dao.lastHaulage(userId);
	
				if (vp != null) 
				{
					String vehicleCount = request.getParameter("vehicleCount");
	
					H_VehicleBean vBean = null;
			
					for (int i = 0, j = 1; i < Integer.parseInt(vehicleCount); i++,j++) 
					{
						vBean = new H_VehicleBean(); 
						String v_category = request.getParameter("v_category_"+j);
						String v_type = request.getParameter("v_type_"+j);
						System.out.println("vtype::"+v_type);
						vBean.setHaulId(String.valueOf(haul_id));
	
						if (v_category == null || v_category.equals("-1")) 
						{
							isError = true;
							request.setAttribute("VehicleError","<font color='red'>Please fill up proper details</font>");
						} 
						else 
						{
							vBean.setVehicleCategory(v_category);
						}
	
						if (v_type == null || v_type.equals("-1")) 
						{
							isError = true;
							request.setAttribute("VehicleError", "<font color='red'>Please fill up proper details</font>");
	
						} else 
						{
							vBean.setVehicleType(v_type);
						}
	
						// insert query...
						if(isError==true)
						{
							flag1=1;
							rd=request.getRequestDispatcher("customer3.jsp");
						}
						else
						{
							H_VehicleDao vdao = new H_VehicleDao();
							if (vdao.insertH_Vehicle(vBean))
								System.out.println("successfully inserted");
							else
								System.out.println("error in::h_vehicle");
						}	
					} // for for dynamic insert
						// vehicle end
				}
	
				/*if (fp != null) 
				{
					
					String foodCount = request.getParameter("foodCount");
					System.out.println("FoodCount::"+foodCount); 
					H_FoodBean fBean = null;
			
					for (int i = 0, j = 1; i < Integer.parseInt(foodCount); i++,j++) 
					{
						fBean = new H_FoodBean();
						String f_type = request.getParameter("f_type_"+j);
						String approxWeight = request.getParameter("approxWeight_"+j);
		
						fBean.setHaulId(String.valueOf(haul_id));
		
						if (f_type == null || f_type.equals("-1")) 
						{
							isError = true;
							request.setAttribute("FoodError", "<font color='red'>Please fill up proper details</font>");
						} else 
						{
							fBean.setFoodType(f_type);
						}
		
						if (approxWeight.trim().length() == 0) 
						{
							isError = true;
							request.setAttribute("FoodError", "<font color='red'>Please fill up proper details</font>");
						} 
						else if(!(approxWeight.charAt(i)>=48 && approxWeight.charAt(i)<=57))
						{
							isError = true;
							request.setAttribute("FoodError", "<font color='red'>Please Enter valid Approx weight</font>");
						}
						else 
						{
							fBean.setApprox_weight(approxWeight);
							request.setAttribute("ApproxWeightValue"+j, approxWeight);
						}
		
						
						if(isError==true)
						{
							flag2=1;
							rd=request.getRequestDispatcher("customer3.jsp");
						}
						else
						{
							H_FoodDao fdao = new H_FoodDao();
							if (fdao.insertH_Food(fBean))
								System.out.println("successfully inserted::h_food");
							else
								System.out.println("error in::h_food");
						}
					}
				}
*/	
				if (hp != null) 
				{
					String h_type = request.getParameter("h_type");
	
					H_HouseholdBean hBean = new H_HouseholdBean();
	
					hBean.setHaulId(String.valueOf(haul_id));
					if (h_type == null || h_type.equals("-1")) {
						isError = true;
						request.setAttribute("HTypeError", "<font color='red'>Please select household Type</font>");
					} else {
						hBean.setHouseType(h_type);
					}
	
					
					if(isError==true)
					{
						flag3=1;
						rd=request.getRequestDispatcher("customer3.jsp");
					}
					else
					{		
						H_HouseholdDao hdao = new H_HouseholdDao();
						if (hdao.insertH_Household(hBean))
							System.out.println("successfully inserted::h_household");
						else
							System.out.println("error in::h_household");
					}
				}
	
				if (op != null) {
					
					String officeCount = request.getParameter("officeCount");
	
					H_Office_removalsBean oBean = null;
			
					for (int i = 0, j = 1; i < Integer.parseInt(officeCount); i++,j++) 
					{
						
						String o_type = request.getParameter("o_type_"+j);
						String description = request.getParameter("description_"+j);
		
						oBean = new H_Office_removalsBean();
		
						oBean.setHaulId(String.valueOf(haul_id));
						if (o_type == null || o_type.equals("-1")) {
							isError = true;
							request.setAttribute("OfficeError", "<font color='red'>Please fill up proper details</font>");
						} else {
							oBean.setOfficeType(o_type);
						}
		
						if (description.trim().length() == 0) {
							isError = true;
							request.setAttribute("OfficeError", "<font color='red'>Please fill up proper details</font>");
						} else {
							oBean.setDescription(description);
							request.setAttribute("DescriptionValue"+j, description);
						}
		
						
						if(isError==true)
						{
							flag4=1;
							rd=request.getRequestDispatcher("customer3.jsp");
						}
						else
						{
							H_Office_removalsDao odao = new H_Office_removalsDao();
							if (odao.insertH_Office_removals(oBean))
								System.out.println("successfully inserted::h_office");
							else
								System.out.println("error in::h_office");
						}
					}
				}
	
				/*if (pp != null)
				{
					
					String petCount = request.getParameter("petCount");
					System.out.println("PetCount::"+petCount);
					H_AnimalBean pBean = null;
			
					for (int i = 0, j = 1; i < Integer.parseInt(petCount); i++,j++) 
					{
									
						String p_type = request.getParameter("p_type_"+j);
		
						pBean = new H_AnimalBean();
		
						pBean.setHaulId(String.valueOf(haul_id));
						if (p_type == null || p_type.equals("-1"))
						{
							isError = true;
							request.setAttribute("PTypeError", "<font color='red'>Please select animal Type</font>");
						}
						else
						{
							pBean.setAnimalType(p_type);
						}
		
						
						if(isError==true)
						{
							flag5=1;
							rd=request.getRequestDispatcher("customer3.jsp");
						}
						else
						{
							H_AnimalDao pdao = new H_AnimalDao();
							if (pdao.insertH_Animal(pBean))
								System.out.println("successfully inserted::h_animal");
							else
								System.out.println("error in::h_animal");
						}
					}
				}
*/				
				if(flag1==0 && flag2==0 && flag3==0 && flag4==0 && flag5==0)
					rd = request.getRequestDispatcher("CustFinalServlet");
			}
		}
		rd.forward(request, response);
	}
}
