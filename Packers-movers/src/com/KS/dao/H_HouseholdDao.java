package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.H_HouseholdBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class H_HouseholdDao 
{
	public boolean insertH_Household(H_HouseholdBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into h_household (house_type,haul_Id) values ('"+bean.getHouseType()+"',"+bean.getHaulId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert h_household....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<H_HouseholdBean> listH_Household() 
	{
		ArrayList<H_HouseholdBean> list = new ArrayList<H_HouseholdBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_household";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_HouseholdBean bean = null;
			while (rs.next())
			{
				bean = new H_HouseholdBean();
				bean.setH_houseId(rs.getString("h_house_id"));
				bean.setHouseType(rs.getString("house_type"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list h_household....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteH_Household(String h_houseId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from h_household where h_house_id = " + h_houseId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete h_household....");
			e.printStackTrace();
		}
		return flag;
	}

	public H_HouseholdBean getDataByPk(String h_houseId) 
	{
		H_HouseholdBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_household where h_house_id = " + h_houseId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new H_HouseholdBean();
				bean.setH_houseId(rs.getString("h_house_id"));
				bean.setHouseType(rs.getString("house_type"));
				bean.setHaulId(rs.getString("haul_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  h_household::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateH_Household(H_HouseholdBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update h_household set h_house_id=" + bean.getH_houseId() + " , house_type='" + bean.getHouseType()
					+ "' , haul_id =" +bean.getHaulId()+" where h_house_id = " + bean.getH_houseId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update h_household....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public ArrayList<H_HouseholdBean> getDataByHaulId(String haulId) 
	{
		ArrayList<H_HouseholdBean> list = new ArrayList<H_HouseholdBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_household where haul_id="+haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_HouseholdBean bean = null;
			while (rs.next())
			{
				bean = new H_HouseholdBean();
				bean.setH_houseId(rs.getString("h_house_id"));
				bean.setHouseType(rs.getString("house_type"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list h_household....");
			e.printStackTrace();
		}
		return list;
	}

	
	
	
}