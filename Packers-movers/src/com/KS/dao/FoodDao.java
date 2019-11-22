package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.FoodBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class FoodDao 
{
	public boolean insertFood(FoodBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into food (food_type) values ('"+bean.getFoodType()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert food....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<FoodBean> listFood() 
	{
		ArrayList<FoodBean> list = new ArrayList<FoodBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from food";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			FoodBean bean = null;
			while (rs.next())
			{
				bean = new FoodBean();
				bean.setFoodId(rs.getString("food_id"));
				bean.setFoodType(rs.getString("food_type"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list food....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteFood(String foodId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from food where food_id = " + foodId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete food....");
			e.printStackTrace();
		}
		return flag;
	}

	public FoodBean getDataByPk(String foodId) 
	{
		FoodBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from food where food_id = " + foodId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new FoodBean();
				bean.setFoodId(rs.getString("food_id"));
				bean.setFoodType(rs.getString("food_type"));
			
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  food::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateFood(FoodBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update food set food_id=" + bean.getFoodId() + " , food_type='" + bean.getFoodType()
					+ "' where food_id = " + bean.getFoodId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update food....");
			e.printStackTrace();
		}
		return flag;
	}
}