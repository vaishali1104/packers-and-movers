package com.KS.dao;


import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;

import com.KS.bean.StateBean;

import com.KS.util.DbConnection;


public class StateDao 
{
	public ArrayList<StateBean> listState() {
		ArrayList<StateBean> list = new ArrayList<StateBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from state";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			StateBean bean = null;
			while (rs.next()) {
				bean = new StateBean();
				bean.setStateId(rs.getString("state_id"));
				bean.setStateName(rs.getString("state_name"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list state....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertState(StateBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into State (state_id,state_name) values("+bean.getStateId()+",'"+bean.getStateName()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert user....");
			e.printStackTrace();
		}

		return flag;
	}

	public static StateBean scanData() {
		StateBean typeBean = new StateBean();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter state_ID : ");
		typeBean.setStateId(sc.nextLine());
		sc.nextLine();
		System.out.println("Enter state_Name : ");
		typeBean.setStateName(sc.nextLine());
		return typeBean;
	}

	public StateBean getDataByPk(String stateId) {
		StateBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from State where state_id = " + stateId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next())
			{
				bean = new StateBean();
				bean.setStateId(rs.getString("state_id"));
				bean.setStateName(rs.getString("state_name"));
			}
		}
		catch (Exception e)
		{
			System.out.println("error in  State:get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateState(StateBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update state set state_name='" + bean.getStateName()	+"' where state_id = " + bean.getStateId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in update State....");
			e.printStackTrace();
		}

		return flag;

	}
		
	public boolean deleteState(String stateId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from state where state_id = "+stateId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete state....");
			e.printStackTrace();
		}
		return flag;
	}

/*	public static void main(String[] args) throws IOException, SQLException {
		StateDao dao=null; 
		System.out.println("===== START :: Main Method =====");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice : ");
		System.out.println("1) FOR Get All State Records : ");
		System.out.println("2) FOR Insert State Record : ");
		System.out.println("3) FOR Update State Record : ");
		System.out.println("4) FOR Delete State Record : ");
		int choice = sc.nextInt();
		dao=new StateDao();
		switch (choice) {
		case 1:
			ArrayList<StateBean> listEmps = dao.listState();
			Iterator<StateBean> itr = listEmps.iterator();
			while (itr.hasNext()) {
				StateBean bean = (StateBean) itr.next();
				System.out.println(bean);
			}
			break;
		case 2:
			StateBean bean = scanData();
			if (dao.insertState(bean))
			{
				System.out.println("Records Inserted : ");
			} else 
			{
				System.out.println("Records Not Inserted  ");
			}
			break;
		case 3:
			System.out.println("to Update, Enter StateID : ");
			int StateId = sc.nextInt();
			bean = scanData(); 
			if (dao.updateState(bean)) {
				System.out.println("Records updated : ");
			} else {
				System.out.println("Records Not updated  ");
			}
			break;
		case 4:
			System.out.println("To Delete, Enter User_typeID : ");
			int deleteStateId = sc.nextInt();
			if (dao.deleteState(deleteStateId)) {
				System.out.println("Records Deleted : ");
			} else {
				System.out.println("Records Not Deleted  ");
			}
			break;
		default:
//			fdgxhcvjbknlm,
			break;
		}

		System.out.println("===== EXIT :: Main Method =====");
	}*/
}

