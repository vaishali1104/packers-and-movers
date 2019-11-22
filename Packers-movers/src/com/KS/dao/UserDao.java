package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.UserBean;
import com.KS.bean.Vendor_detailBean;
import com.KS.util.DbConnection;

public class UserDao {

	public UserBean getDataByEmail(String emailId) {

		UserBean userBean = null;

		try {
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			String selectQ = "select * from user where user_email_id = '" + emailId + "'";
			System.out.println(selectQ);
			ResultSet rs = stmt.executeQuery(selectQ);
			if (rs.next()) {
				userBean = new UserBean();
				userBean.setUserId(rs.getString("user_id"));
				userBean.setUserTypeId(rs.getString("user_type_id"));
				userBean.setUserName(rs.getString("user_name"));
				userBean.setUserEmail(rs.getString("user_email_id"));
				userBean.setPhoneNo(rs.getString("user_phone_no"));
				userBean.setUserPassword(rs.getString("user_password"));
				userBean.setSecurity_questionId(rs.getString("security_questionId"));
				userBean.setAnswer(rs.getString("answer"));
				int securityQuestionId = rs.getInt("security_questionId");
				String selectS = "select * from security_question where security_question_id = " + securityQuestionId;
				System.out.println(selectS);
				ResultSet rs1 = stmt.executeQuery(selectS);
				rs1.next();
				userBean.setSecurity_question(rs1.getString("security_question"));
			}

		} catch (Exception e) {
			System.out.println("Exception in userdao getdatabyemail");
			e.printStackTrace();
		}

		return userBean;

	}

	public UserBean authenticateUser(String email, String password) {

		UserBean userBean = null;
		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from user where user_email_id='" + email + "' and user_password='" + password + "'";
			System.out.println(selectQ);
			ResultSet rs = stmt.executeQuery(selectQ);
			if (rs.next()) {
				userBean = new UserBean();
				// user_id ,email , userType ,name
				userBean.setUserId(rs.getString("user_id"));
				userBean.setUserTypeId(rs.getString("user_type_id"));
				userBean.setUserName(rs.getString("user_name"));
				userBean.setUserEmail(rs.getString("user_email_id"));
				userBean.setPhoneNo(rs.getString("user_phone_no"));
				userBean.setUserPassword(rs.getString("user_password"));
				userBean.setSecurity_questionId(rs.getString("security_questionId"));
				userBean.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			System.out.println("error in authenticate user in user dao ");
			e.printStackTrace();
		}

		return userBean;
	}

	public UserBean insertUser(UserBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into user (User_type_id,User_name,User_email_id,User_phone_no,User_password,security_questionId,answer) values ("
					+ bean.getUserTypeId() + ",'" + bean.getUserName() + "','" + bean.getUserEmail() + "','"
					+ bean.getPhoneNo() + "','" + bean.getUserPassword() + "'," + bean.getSecurity_questionId() + ",'"
					+ bean.getAnswer() + "')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				Connection con1= DbConnection.getConnection();
				Statement stmt1 = con1.createStatement();
				flag = true;
				ResultSet rs1 = stmt1.executeQuery("select user_id from user where user_email_id  = '"+bean.getUserEmail()+"'");
				rs1.next();
				String ss = rs1.getString("user_id");
				bean.setUserId(ss);
				//System.out.println("sssssss======>>>> " + ss);
			}

		} catch (Exception e) {
			System.out.println("error in insert user....");
			e.printStackTrace();
		}

		return bean;
	}

	
	public UserBean insertGoogleUser(UserBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into user (User_type_id,User_name,User_email_id,User_phone_no,User_password,security_questionId,answer) values (1,'" + bean.getUserName() + "','" + bean.getUserEmail() + "','1234567890','1234568',1,'12345678')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1)
			{
				Connection con1= DbConnection.getConnection();
				Statement stmt1 = con1.createStatement();
				flag = true;
				ResultSet rs1 = stmt1.executeQuery("select * from user where user_email_id  = '"+bean.getUserEmail()+"'");
				rs1.next();
				String ss = rs1.getString("user_id");
				bean.setUserId(rs1.getString("user_id"));
				bean.setUserTypeId(rs1.getString("user_type_id"));
				bean.setUserName(rs1.getString("user_name"));
				bean.setUserEmail(rs1.getString("user_email_id"));
				bean.setPhoneNo(rs1.getString("user_phone_no"));
				bean.setUserPassword(rs1.getString("user_password"));
				bean.setSecurity_questionId(rs1.getString("security_questionId"));
				bean.setAnswer(rs1.getString("answer"));
				
				
				System.out.println("sssssss======>>>> " + ss);
			}

		} catch (Exception e) {
			System.out.println("error in insert google user....");
			e.printStackTrace();
		}

		return bean;
	}

	
	public ArrayList<UserBean> listUser() {
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from user";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			UserBean userBean = null;
			while (rs.next()) {
				userBean = new UserBean();
				userBean.setUserId(rs.getString("user_id"));
				userBean.setUserTypeId(rs.getString("user_type_id"));
				userBean.setUserName(rs.getString("user_name"));
				userBean.setUserEmail(rs.getString("user_email_id"));
				userBean.setPhoneNo(rs.getString("user_phone_no"));
				userBean.setUserPassword(rs.getString("user_password"));
				userBean.setSecurity_questionId(rs.getString("security_questionId"));
				userBean.setAnswer(rs.getString("answer"));
				list.add(userBean);
			}
		} catch (Exception e) {
			System.out.println("error in  list user....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteUser(String userId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from user where user_id = " + userId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete user....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	public UserBean getDataByPk(String userId) {
		UserBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from user where user_id = " + userId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) {
				bean = new UserBean();
				bean.setUserId(rs.getString("User_id"));
				bean.setUserTypeId(rs.getString("User_type_id"));
				bean.setUserName(rs.getString("User_name"));
				bean.setUserEmail(rs.getString("User_email_id"));
				bean.setPhoneNo(rs.getString("User_phone_no"));
				bean.setUserPassword(rs.getString("User_password"));
				bean.setSecurity_questionId(rs.getString("security_questionId"));
				bean.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			System.out.println("error in  user::get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateUser(UserBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update user set user_name='" + bean.getUserName() + "' , user_email_id='"
					+ bean.getUserEmail() + "' , user_phone_no = '" + bean.getPhoneNo() + "' , user_type_id = "
					+ bean.getUserTypeId() + ",security_questionId= " + bean.getSecurity_questionId() + " ,answer ='"
					+ bean.getAnswer() + "' where user_id = " + bean.getUserId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in update user....");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updatePassword(String userId, String password) {
		boolean flag = false;
		UserBean bean = new UserBean();

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update user set user_password='" + password + "' where user_id = " + userId;
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in update user....");
			e.printStackTrace();
		}
		return flag;
	}
}