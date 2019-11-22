package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class HouseholdDao 
{
	public boolean insertHousehold(HouseholdBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into household (house_type) values ('"+bean.getHouseType()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert household....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<HouseholdBean> listHousehold() 
	{
		ArrayList<HouseholdBean> list = new ArrayList<HouseholdBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from household";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			HouseholdBean bean = null;
			while (rs.next())
			{
				bean = new HouseholdBean();
				bean.setHouseId(rs.getString("house_id"));
				bean.setHouseType(rs.getString("house_type"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list household....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteHousehold(String houseId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from household where house_id = " + houseId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete household....");
			e.printStackTrace();
		}
		return flag;
	}

	public HouseholdBean getDataByPk(String houseId) 
	{
		HouseholdBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from household where house_id = " + houseId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new HouseholdBean();
				bean.setHouseId(rs.getString("house_id"));
				bean.setHouseType(rs.getString("house_type"));
				
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  household::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateHousehold(HouseholdBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update household set house_id=" + bean.getHouseId() + " , house_type='" + bean.getHouseType()
					+ "' where house_id = " + bean.getHouseId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update household....");
			e.printStackTrace();
		}
		return flag;
	}
}