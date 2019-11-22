package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.FoodBean;
import com.KS.bean.H_FoodBean;
import com.KS.bean.H_HouseholdBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class H_FoodDao 
{
	public boolean insertH_Food(H_FoodBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into h_food (food_type,haul_id,approx_weight) values ('"+bean.getFoodType()+"',"+bean.getHaulId()+","+bean.getApprox_weight()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert h_food....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<H_FoodBean> listH_Food() 
	{
		ArrayList<H_FoodBean> list = new ArrayList<H_FoodBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_food";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_FoodBean bean = null;
			while (rs.next())
			{
				bean = new H_FoodBean();
				bean.setH_foodId(rs.getString("h_food_id"));
				bean.setFoodType(rs.getString("food_type"));
				bean.setHaulId(rs.getString("haul_id"));
				bean.setApprox_weight(rs.getString("approx_weight"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list h_food....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteH_Food(String h_foodId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from h_food where h_food_id = " + h_foodId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete h_food....");
			e.printStackTrace();
		}
		return flag;
	}

	public H_FoodBean getDataByPk(String h_foodId) 
	{
		H_FoodBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_food where h_food_id = " + h_foodId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new H_FoodBean();
				bean.setH_foodId(rs.getString("h_food_id"));
				bean.setFoodType(rs.getString("food_type"));
				bean.setHaulId(rs.getString("haul_id"));
				bean.setApprox_weight(rs.getString("approx_weight"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  h_food::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateH_Food(H_FoodBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update h_food set h_food_id=" + bean.getH_foodId() + " , food_type='" + bean.getFoodType()
					+ "', haul_id="+bean.getHaulId()+", approx_weight="+bean.getApprox_weight()+" where h_food_id = " + bean.getH_foodId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update h_food....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public ArrayList<H_FoodBean> getDataByHaulId(String haulId) 
	{
		ArrayList<H_FoodBean> list = new ArrayList<H_FoodBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_food where haul_id="+haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_FoodBean bean = null;
			while (rs.next())
			{

				bean = new H_FoodBean();
				bean.setH_foodId(rs.getString("h_food_id"));
				bean.setFoodType(rs.getString("food_type"));
				bean.setHaulId(rs.getString("haul_id"));
				bean.setApprox_weight(rs.getString("approx_weight"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list h_food....");
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
}