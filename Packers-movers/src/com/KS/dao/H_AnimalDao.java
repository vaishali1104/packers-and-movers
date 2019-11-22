package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.AnimalBean;
import com.KS.bean.H_AnimalBean;
import com.KS.bean.H_FoodBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class H_AnimalDao 
{
	
	public ArrayList<H_AnimalBean> getDataByHaulId(String haulId) 
	{
		ArrayList<H_AnimalBean> list = new ArrayList<H_AnimalBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_animal where haul_id="+haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_AnimalBean bean = null;
			while (rs.next())
			{
				bean = new H_AnimalBean();
				bean.setH_animalId(rs.getString("h_animal_id"));
				bean.setAnimalType(rs.getString("animal_type"));
				bean.setHaulId(rs.getString("haul_id"));
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
	
	
	public boolean insertH_Animal(H_AnimalBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into h_animal (animal_type,haul_id) values ('"+bean.getAnimalType()+"',"+bean.getHaulId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert h_animal....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<H_AnimalBean> listH_Animal() 
	{
		ArrayList<H_AnimalBean> list = new ArrayList<H_AnimalBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from H_Animal";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_AnimalBean bean = null;
			while (rs.next())
			{
				bean = new H_AnimalBean();
				bean.setH_animalId(rs.getString("h_animal_id"));
				bean.setAnimalType(rs.getString("animal_type"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list H_Animal....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteH_Animal(String h_animalId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from h_animal where h_animal_id = " + h_animalId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete h_animal....");
			e.printStackTrace();
		}
		return flag;
	}

	public H_AnimalBean getDataByPk(String h_animalId) 
	{
		H_AnimalBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_animal where h_animal_id = " + h_animalId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new H_AnimalBean();
				bean.setH_animalId(rs.getString("h_animal_id"));
				bean.setAnimalType(rs.getString("animal_type"));
				bean.setHaulId(rs.getString("haul_Id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  h_animal::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateH_Animal(H_AnimalBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update h_animal set h_animal_id=" + bean.getH_animalId() + " , animal_type='" + bean.getAnimalType()
					+ "',haul_id="+bean.getHaulId()+" where h_animal_id = " + bean.getH_animalId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update h_animal....");
			e.printStackTrace();
		}
		return flag;
	}
}