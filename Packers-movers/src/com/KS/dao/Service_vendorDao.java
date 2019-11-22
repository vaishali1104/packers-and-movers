package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.CityBean;
import com.KS.bean.Service_vendorBean;
import com.KS.util.DbConnection;

public class Service_vendorDao
{

	public boolean insertService_vendor(Service_vendorBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into service_vendor (service_id,user_id) values ("+bean.getServiceId()+","+bean.getUserId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert service_vendor....");
			e.printStackTrace();
		}

		return flag;
	}

	public ArrayList<Service_vendorBean> listService_vendor() {
		ArrayList<Service_vendorBean> list = new ArrayList<Service_vendorBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from Service_vendor";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			Service_vendorBean bean = null;
			while (rs.next())
			{
				bean = new Service_vendorBean();
				bean.setSer_venId(rs.getString("ser_ven_id"));
				bean.setServiceId(rs.getString("service_id"));
				bean.setUserId(rs.getString("user_id"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list Service_vendor....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteService_vendor(String ser_venId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from service_vendor where ser_ven_id = " + ser_venId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete Service_vendor....");
			e.printStackTrace();
		}
		return flag;
	}

	public Service_vendorBean getDataByPk(String ser_venId) {
		Service_vendorBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from Service_vendor where ser_ven_id = " + ser_venId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new Service_vendorBean();
				bean.setSer_venId(rs.getString("ser_ven_id"));
				bean.setServiceId(rs.getString("service_id"));
				bean.setUserId(rs.getString("user_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  Service_vendor::get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateService_vendor(Service_vendorBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update service_vendor set service_id=" + bean.getServiceId()+ " , user_id=" +bean.getUserId()+ " where ser_ven_id = " + bean.getSer_venId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} 
		catch (Exception e)
		{
			System.out.println("error in update Service_vendor....");
			e.printStackTrace();
		}
		return flag;

	}
}