package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.AnimalBean;
import com.KS.bean.H_Office_removalsBean;
import com.KS.bean.H_VehicleBean;
import com.KS.bean.HouseholdBean;
import com.KS.bean.VehicleBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class H_VehicleDao 
{
	
	public ArrayList<H_VehicleBean> getDataByHaulId(String haulId) 
	{
		ArrayList<H_VehicleBean> list = new ArrayList<H_VehicleBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_vehicle where haul_id="+haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_VehicleBean bean = null;
			while (rs.next())
			{
				bean = new H_VehicleBean();
				bean.setH_vehicleId(rs.getString("h_vehicle_id"));
				bean.setVehicleType(rs.getString("vehicle_type"));
				bean.setVehicleCategory(rs.getString("vehicle_category"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  getDataByHaulId h_Vehicle....");
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	public boolean insertH_Vehicle(H_VehicleBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into h_vehicle (vehicle_type,vehicle_category,haul_id) values ('"+bean.getVehicleType()+"','"+bean.getVehicleCategory()+"',"+bean.getHaulId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in insert h_vehicle....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<H_VehicleBean> listH_Vehicle() 
	{
		ArrayList<H_VehicleBean> list = new ArrayList<H_VehicleBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_vehicle";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			H_VehicleBean bean = null;
			while (rs.next())
			{
				bean = new H_VehicleBean();
				bean.setH_vehicleId(rs.getString("h_vehicle_id"));
				bean.setVehicleType(rs.getString("vehicle_type"));
				bean.setVehicleCategory(rs.getString("vehicle_category"));
				bean.setHaulId(rs.getString("haul_id"));
				list.add(bean);
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  list h_vehicle....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteH_Vehicle(String h_vehicleId) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from h_vehicle where h_vehicle_id = " + h_vehicleId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1)
			{
				flag = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("error in delete h_vehicle....");
			e.printStackTrace();
		}
		return flag;
	}

	public H_VehicleBean getDataByPk(String h_vehicleId) 
	{
		H_VehicleBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from h_vehicle where h_vehicle_id = " + h_vehicleId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new H_VehicleBean();
				bean.setH_vehicleId(rs.getString("h_vehicle_id"));
				bean.setVehicleType(rs.getString("vehicle_type"));
				bean.setVehicleCategory(rs.getString("vehicle_category"));
				bean.setHaulId(rs.getString("haul_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  h_vehicle::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateH_Vehicle(H_VehicleBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update h_vehicle set h_vehicle_id=" + bean.getH_vehicleId() + " , vehicle_type='" + bean.getVehicleType()
					+ "' , vehicle_category ='" +bean.getVehicleCategory()+"',haul_id="+bean.getHaulId()+" where h_vehicle_id = " + bean.getH_vehicleId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update h_vehicle....");
			e.printStackTrace();
		}
		return flag;
	}
}