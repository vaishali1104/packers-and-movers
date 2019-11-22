package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class Vendor_detailDao 
{
	public boolean insertVendor_detail(Vendor_detailBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			
			stmt = con.createStatement();
			//String license = bean.getLicense();
			
			String insertQ = "insert into vendor_detail (User_id,Address,City,Max_vehicle,License,Company_name) values ("+bean.getUserId()+",'"+bean.getAddress()+"','"+bean.getCity()+"',"+bean.getMaxVehicle()+",'"+bean.getLicense()+"','"+bean.getCompanyName()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert vendor_detail....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Vendor_detailBean> listVendor_detail() 
	{
		ArrayList<Vendor_detailBean> list = new ArrayList<Vendor_detailBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from vendor_detail";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			Vendor_detailBean bean = null;
			while (rs.next())
			{
				bean = new Vendor_detailBean();
				bean.setVendorDetailId(rs.getString("vendor_detail_id"));
				bean.setUserId(rs.getString("user_id"));
				bean.setAddress(rs.getString("address"));
				bean.setCity(rs.getString("city"));
				bean.setLicense(rs.getString("license"));
				bean.setMaxVehicle(rs.getString("max_vehicle"));
				bean.setCompanyName(rs.getString("company_name"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list vendor detail....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteVendor_detail(String vendorDetailId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from vendor_detail where vendor_detail_id = " + vendorDetailId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete vendor Detail....");
			e.printStackTrace();
		}
		return flag;
	}

	
	public Vendor_detailBean getDataByPk(String vendorDetailId) 
	{
		Vendor_detailBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from vendor_detail where vendor_detail_id = " + vendorDetailId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new Vendor_detailBean();
				bean.setVendorDetailId(rs.getString("vendor_detail_id"));
				bean.setUserId(rs.getString("user_id"));
				bean.setAddress(rs.getString("address"));
				bean.setCity(rs.getString("city"));
				bean.setLicense(rs.getString("license"));
				bean.setMaxVehicle(rs.getString("max_vehicle"));
				bean.setCompanyName(rs.getString("company_name"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  vendor_detail::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}


	public Vendor_detailBean getDataByUserId(String userId) 
	{
		Vendor_detailBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from vendor_detail where user_id = " + userId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new Vendor_detailBean();
				bean.setVendorDetailId(rs.getString("vendor_detail_id"));
				bean.setUserId(rs.getString("user_id"));
				bean.setAddress(rs.getString("address"));
				bean.setCity(rs.getString("city"));
				bean.setLicense(rs.getString("license"));
				bean.setMaxVehicle(rs.getString("max_vehicle"));
				bean.setCompanyName(rs.getString("company_name"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  vendor_detail::get data by userId....");
			e.printStackTrace();
		}
		return bean;
	}

	
	
	
	public boolean updateVendor_detail(Vendor_detailBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
	
			String updateQ = "update vendor_detail set user_id=" + bean.getUserId() + " , address='" + bean.getAddress()
					+ "',city='"+bean.getCity()+"', max_vehicle = " +bean.getMaxVehicle()+ " , license = '" + bean.getLicense()
					+ "',company_name='"+bean.getCompanyName()+"' where vendor_detail_id = " + bean.getVendorDetailId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update vendor_detail....");
			e.printStackTrace();
		}
		return flag;
	}
}