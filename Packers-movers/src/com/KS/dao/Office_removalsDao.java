package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.FoodBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Office_removalsBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class Office_removalsDao 
{
	public boolean insertOffice_removals(Office_removalsBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into office_removals (office_type) values ('"+bean.getOfficeType()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert Office_removals...");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Office_removalsBean> listOffice_removals() 
	{
		ArrayList<Office_removalsBean> list = new ArrayList<Office_removalsBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from office_removals";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			Office_removalsBean bean = null;
			while (rs.next())
			{
				bean = new Office_removalsBean();
				bean.setOfficeId(rs.getString("office_id"));
				bean.setOfficeType(rs.getString("office_type"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list Office_removals....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteOffice_removals(String officeId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from office_removals where office_id = " + officeId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete Office_removals....");
			e.printStackTrace();
		}
		return flag;
	}

	public Office_removalsBean getDataByPk(String officeId) 
	{
		Office_removalsBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from office_removals where office_id = " + officeId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new Office_removalsBean();
				bean.setOfficeId(rs.getString("office_id"));
				bean.setOfficeType(rs.getString("office_type"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  Office_removals::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateOffice_removals(Office_removalsBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update office_removals set office_id=" + bean.getOfficeId()+ " , office_type='" + bean.getOfficeType()
					+ "' where office_id = " + bean.getOfficeId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update Office_removals....");
			e.printStackTrace();
		}
		return flag;
	}
}