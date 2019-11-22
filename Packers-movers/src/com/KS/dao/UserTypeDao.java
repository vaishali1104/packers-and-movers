package com.KS.dao;


import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;

import com.KS.bean.UserTypeBean;

import com.KS.util.DbConnection;


public class UserTypeDao 
{
	public ArrayList<UserTypeBean> listUserType() {
		ArrayList<UserTypeBean> list = new ArrayList<UserTypeBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from user_type";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			UserTypeBean bean = null;
			while (rs.next())
			{
				bean = new UserTypeBean();
				bean.setUserTypeId(rs.getString("user_type_id"));
				bean.setUserTypeName(rs.getString("user_type_name"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list user_type....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertUserType(UserTypeBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into user_type(user_type_name) values('"+bean.getUserTypeName()+"')";
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

	public static UserTypeBean scanData() {
		UserTypeBean typeBean = new UserTypeBean();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User_typeID : ");
		typeBean.setUserTypeId(sc.nextLine());
		sc.nextLine();
		System.out.println("Enter User_typeName : ");
		typeBean.setUserTypeName(sc.nextLine());
		return typeBean;
	}
	public UserTypeBean getDataByPk(String userTypeId) {
		UserTypeBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from user_type where user_type_id = " + userTypeId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next())
			{
				bean = new UserTypeBean();
				bean.setUserTypeId(rs.getString("user_type_id"));
				bean.setUserTypeName(rs.getString("user_type_name"));
			}
		}
		catch (Exception e)
		{
			System.out.println("error in  Usertype:get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateUserType(UserTypeBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update user_type set user_type_name='" + bean.getUserTypeName()	+"' where user_type_id = " + bean.getUserTypeId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in update user_type....");
			e.printStackTrace();
		}

		return flag;

	}
	
	public boolean deleteUserType(String userTypeId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from user_type where user_type_id = "+userTypeId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete user_type....");
			e.printStackTrace();
		}
		return flag;
	}

/*	public static void main(String[] args) throws IOException, SQLException {
		UserTypeDao dao=null; 
		System.out.println("===== START :: Main Method =====");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice : ");
		System.out.println("1) FOR Get All User_type Records : ");
		System.out.println("2) FOR Insert User_type Record : ");
		System.out.println("3) FOR Update User_type Record : ");
		System.out.println("4) FOR Delete User_type Record : ");
		int choice = sc.nextInt();
		dao=new UserTypeDao();
		switch (choice) {
		case 1:
			ArrayList<UserTypeBean> listEmps = dao.listUserType();
			Iterator<UserTypeBean> itr = listEmps.iterator();
			while (itr.hasNext()) {
				UserTypeBean bean = (UserTypeBean) itr.next();
				System.out.println(bean);
			}
			break;
		case 2:
			UserTypeBean bean = scanData();
			if (dao.insertUserType(bean))
			{
				System.out.println("Records Inserted : ");
			} else 
			{
				System.out.println("Records Not Inserted  ");
			}
			break;
		case 3:
			System.out.println("to Update, Enter User_typeID : ");
			int User_typeId = sc.nextInt();
			bean = scanData(); 
			if (dao.updateUserType(bean)) {
				System.out.println("Records updated : ");
			} else {
				System.out.println("Records Not updated  ");
			}
			break;
		case 4:
			System.out.println("To Delete, Enter User_typeID : ");
			int deleteUser_typeId = sc.nextInt();
			if (dao.deleteUserType(deleteUser_typeId)) {
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
	}
*/
}
