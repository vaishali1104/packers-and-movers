package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.RouteBean;
import com.KS.util.DbConnection;

public class RouteDao {

	public boolean insertRoute(RouteBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into route (origin,destination,city_Id,route_via) values ('"+bean.getOrigin()+"','"+bean.getDestination()+"',"+bean.getCityId()+",'"+bean.getRouteVia()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert route....");
			e.printStackTrace();
		}

		return flag;
	}

	public ArrayList<RouteBean> listRoute() {
		ArrayList<RouteBean> list = new ArrayList<RouteBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from route";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			RouteBean bean = null;
			while (rs.next())
			{
				bean = new RouteBean();
				bean.setRouteId(rs.getString("route_id"));
				bean.setOrigin(rs.getString("origin"));
				bean.setDestination(rs.getString("destination"));
				bean.setCityId(rs.getString("city_id"));
				bean.setRouteVia(rs.getString("route_via"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list route....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteRoute(String routeId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from route where route_id = " + routeId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete route....");
			e.printStackTrace();
		}
		return flag;
	}

	public RouteBean getDataByPk(String routeId) {
		RouteBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from route where route_id = " + routeId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new RouteBean();
				bean.setRouteId(rs.getString("route_id"));
				bean.setOrigin(rs.getString("origin"));
				bean.setDestination(rs.getString("destination"));
				bean.setCityId(rs.getString("city_id"));
				bean.setRouteVia(rs.getString("route_via"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  route::get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateRoute(RouteBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update route set origin='" + bean.getOrigin() + "' , destination='" + bean.getDestination()
					+ "' , city_id = " +bean.getCityId()+ " , route_via = '" + bean.getRouteVia()
					+ "' where route_id = " + bean.getRouteId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} 
		catch (Exception e)
		{
			System.out.println("error in update route....");
			e.printStackTrace();
		}
		return flag;

	}
}



