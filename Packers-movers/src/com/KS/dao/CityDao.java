package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.KS.bean.CityBean;
import com.KS.util.DbConnection;

public class CityDao
{

	public boolean insertCity(CityBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into city (city_name,state_Id) values ('"+bean.getCityName()+"',"+bean.getStateId()+")";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert city....");
			e.printStackTrace();
		}

		return flag;
	}

	public ArrayList<CityBean> listCity() {
		ArrayList<CityBean> list = new ArrayList<CityBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from city";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			CityBean bean = null;
			while (rs.next())
			{
				bean = new CityBean();
				bean.setCityId(rs.getString("city_id"));
				bean.setCityName(rs.getString("city_name"));
				bean.setStateId(rs.getString("state_id"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list city....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteCity(String cityId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from city where city_id = " + cityId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete city....");
			e.printStackTrace();
		}
		return flag;
	}

	public CityBean getDataByPk(String cityId) {
		CityBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from city where city_id = " + cityId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new CityBean();
				bean.setCityId(rs.getString("city_id"));
				bean.setCityName(rs.getString("city_name"));
				bean.setStateId(rs.getString("state_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  city::get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateCity(CityBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update city set city_name='" + bean.getCityName() + "' , state_id=" +bean.getStateId()+ " where city_id = " + bean.getCityId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} 
		catch (Exception e)
		{
			System.out.println("error in update city....");
			e.printStackTrace();
		}
		return flag;
	}
}