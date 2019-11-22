package com.KS.dao;


import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;

import com.KS.bean.ServiceBean;
import com.KS.bean.UserTypeBean;

import com.KS.util.DbConnection;


public class ServiceDao 
{
	public ArrayList<ServiceBean> listService() {
		ArrayList<ServiceBean> list = new ArrayList<ServiceBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from service";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			ServiceBean bean = null;
			while (rs.next())
			{
				bean = new ServiceBean();
				bean.setServiceId(rs.getString("service_id"));
				bean.setServiceType(rs.getString("service_type"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list service....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertService(ServiceBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into service (service_type) values('"+bean.getServiceType()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert service....");
			e.printStackTrace();
		}

		return flag;
	}


	public ServiceBean getDataByPk(String serviceId) {
		ServiceBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from service where service_id = " + serviceId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next())
			{
				bean = new ServiceBean();
				bean.setServiceId(rs.getString("service_id"));
				bean.setServiceType(rs.getString("service_type"));
			}
		}
		catch (Exception e)
		{
			System.out.println("error in  Service:get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateService(ServiceBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update service set service_type='" + bean.getServiceType()	+"' where service_id = " + bean.getServiceId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in update service....");
			e.printStackTrace();
		}

		return flag;

	}
	
	public boolean deleteService(String serviceId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from service where service_id = "+serviceId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete service....");
			e.printStackTrace();
		}
		return flag;
	}
}
