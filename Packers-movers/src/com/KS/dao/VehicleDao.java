package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.AnimalBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.VehicleBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class VehicleDao 
{
	public boolean insertVehicle(VehicleBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into vehicle (vehicle_type,vehicle_category) values ('"+bean.getVehicleType()+"','"+bean.getVehicleCategory()+"')";	
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert vehicle....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<VehicleBean> listVehicle() 
	{
		ArrayList<VehicleBean> list = new ArrayList<VehicleBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from vehicle";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			VehicleBean bean = null;
			while (rs.next())
			{
				bean = new VehicleBean();
				bean.setVehicleId(rs.getString("vehicle_id"));
				bean.setVehicleType(rs.getString("vehicle_type"));
				bean.setVehicleCategory(rs.getString("vehicle_category"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list vehicle....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteVehicle(String vehicleId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from vehicle where vehicle_id = " + vehicleId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete vehicle....");
			e.printStackTrace();
		}
		return flag;
	}

	public VehicleBean getDataByPk(String vehicleId) 
	{
		VehicleBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from vehicle where vehicle_id = " + vehicleId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new VehicleBean();
				bean.setVehicleId(rs.getString("vehicle_id"));
				bean.setVehicleType(rs.getString("vehicle_type"));
				bean.setVehicleCategory(rs.getString("vehicle_category"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  vehicle::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateVehicle(VehicleBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update vehicle set vehicle_id=" + bean.getVehicleId() + " , vehicle_type='" + bean.getVehicleType()
					+ "' , vehicle_category ='" +bean.getVehicleCategory()+"' where vehicle_id = " + bean.getVehicleId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update vehicle....");
			e.printStackTrace();
		}
		return flag;
	}
}