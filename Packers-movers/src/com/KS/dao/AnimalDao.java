package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.AnimalBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class AnimalDao 
{
	public boolean insertAnimal(AnimalBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into animal (animal_type) values ('"+bean.getAnimalType()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert animal....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<AnimalBean> listAnimal() 
	{
		ArrayList<AnimalBean> list = new ArrayList<AnimalBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from Animal";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			AnimalBean bean = null;
			while (rs.next())
			{
				bean = new AnimalBean();
				bean.setAnimalId(rs.getString("animal_id"));
				bean.setAnimalType(rs.getString("animal_type"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list Animal....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteAnimal(String animalId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from animal where animal_id = " + animalId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete animal....");
			e.printStackTrace();
		}
		return flag;
	}

	public AnimalBean getDataByPk(String animalId) 
	{
		AnimalBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from animal where animal_id = " + animalId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new AnimalBean();
				bean.setAnimalId(rs.getString("animal_id"));
				bean.setAnimalType(rs.getString("animal_type"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  animal::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateAnimal(AnimalBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update animal set animal_id=" + bean.getAnimalId() + " , animal_type='" + bean.getAnimalType()
					+ "' where animal_id = " + bean.getAnimalId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update animal....");
			e.printStackTrace();
		}
		return flag;
	}
}