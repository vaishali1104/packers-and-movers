package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.FoodBean;
import com.KS.bean.H_AnimalBean;
import com.KS.bean.H_Office_removalsBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Office_removalsBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class H_Office_removalsDao 
{
	
	
	public boolean insertH_Office_removals(H_Office_removalsBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into h_office_removals (office_type,description,haul_Id) values ('"+bean.getOfficeType()+"','"+bean.getDescription()+"',"+bean.getHaulId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert H_Office_removals...");
			e.printStackTrace();
		}
		return flag;
	}

	
	public ArrayList<H_Office_removalsBean> getDataByHaulId(String haulId) 
	{
		ArrayList<H_Office_removalsBean> list = new ArrayList<H_Office_removalsBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_office_removals where haul_id="+haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_Office_removalsBean bean = null;
			while (rs.next())
			{
				bean = new H_Office_removalsBean();
				bean.setH_officeId(rs.getString("h_office_id"));
				bean.setOfficeType(rs.getString("office_type"));
				bean.setDescription(rs.getString("description"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  getDataByHaulId h_office removals....");
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	public ArrayList<H_Office_removalsBean> listH_Office_removals() 
	{
		ArrayList<H_Office_removalsBean> list = new ArrayList<H_Office_removalsBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_office_removals";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_Office_removalsBean bean = null;
			while (rs.next())
			{
				bean = new H_Office_removalsBean();
				bean.setH_officeId(rs.getString("h_office_id"));
				bean.setOfficeType(rs.getString("office_type"));
				bean.setDescription(rs.getString("description"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list H_Office_removals....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteH_Office_removals(String h_officeId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from h_office_removals where h_office_id = " + h_officeId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete H_Office_removals....");
			e.printStackTrace();
		}
		return flag;
	}

	public H_Office_removalsBean getDataByPk(String h_officeId) 
	{
		H_Office_removalsBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_office_removals where h_office_id = " + h_officeId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new H_Office_removalsBean();
				bean.setH_officeId(rs.getString("h_office_id"));
				bean.setOfficeType(rs.getString("office_type"));
				bean.setDescription(rs.getString("description"));
				bean.setHaulId(rs.getString("haul_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  H_Office_removals::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateH_Office_removals(H_Office_removalsBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update h_office_removals set h_office_id=" + bean.getH_officeId()+ " , office_type='" + bean.getOfficeType()
					+ "', description='" + bean.getDescription()+ "', haul_Id="+bean.getHaulId()+" where h_office_id = " + bean.getH_officeId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update H_Office_removals....");
			e.printStackTrace();
		}
		return flag;
	}
}