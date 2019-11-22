package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import com.KS.bean.Security_questionBean;

import com.KS.util.DbConnection;

public class Security_questionDao 
{
	public ArrayList<Security_questionBean> listSecurity_question() {
		ArrayList<Security_questionBean> list = new ArrayList<Security_questionBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from Security_question";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			Security_questionBean bean = null;
			while (rs.next()) {
				bean = new Security_questionBean();
				bean.setSecurity_questionId(rs.getString("security_question_id"));
				bean.setSecurity_question(rs.getString("security_question"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list Security_question....");
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertSecurity_question(Security_questionBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into Security_question (security_question_id,security_question) values("+bean.getSecurity_questionId()+",'"+bean.getSecurity_question()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in insert Security_question....");
			e.printStackTrace();
		}

		return flag;
	}

	public Security_questionBean getDataByPk(String security_questionId) {
		Security_questionBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from Security_question where security_question_id = " + security_questionId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next())
			{
				bean = new Security_questionBean();
				bean.setSecurity_questionId(rs.getString("security_question_id"));
				bean.setSecurity_question(rs.getString("security_question"));
			}
		}
		catch (Exception e)
		{
			System.out.println("error in Security_question :get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateSecurity_question(Security_questionBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update security_question set security_question='" + bean.getSecurity_question()	+"' where security_question_id = " + bean.getSecurity_questionId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in update Security_question....");
			e.printStackTrace();
		}

		return flag;

	}
		
	public boolean deleteSecurity_question(String security_questionId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from security_question where security_question_id = "+security_questionId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete Security_question....");
			e.printStackTrace();
		}
		return flag;
	}
}