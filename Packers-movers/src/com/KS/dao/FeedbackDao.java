package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.FeedbackBean;
import com.KS.util.DbConnection;

public class FeedbackDao
{
	public boolean insertFeedback(FeedbackBean bean) 
	{
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into feedback (name,description) values ('"+bean.getName()+"','"+bean.getDescription()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}
		}
		catch (Exception e)
		{
			System.out.println("error in insert feedback....");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<FeedbackBean> listFeedback() 
	{
		ArrayList<FeedbackBean> list = new ArrayList<FeedbackBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from feedback";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			FeedbackBean bean = null;
			while (rs.next())
			{
				bean = new FeedbackBean();
				bean.setFeedId(rs.getString("feed_id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
				list.add(bean);
			}
		}
		catch (Exception e)
		{
			System.out.println("error in  list feedback....");
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteFeedback(String feedId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from feedback where feed_id = " + feedId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("error in delete Feedback....");
			e.printStackTrace();
		}
		return flag;
	}

	public FeedbackBean getDataByPk(String feedId) {
		FeedbackBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from feedback where feed_id = " + feedId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) 
			{
				bean = new FeedbackBean();
				bean.setFeedId(rs.getString("feed_id"));
				bean.setName(rs.getString("name"));
				bean.setDescription(rs.getString("description"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in  Feedback::get data by pk....");
			e.printStackTrace();
		}

		return bean;
	}

	public boolean updateFeedback(FeedbackBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update feedback set name='" +bean.getName()+"',description='"+bean.getDescription()+"' where feed_id = " + bean.getFeedId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) 
			{
				flag = true;
			}
		} 
		catch (Exception e)
		{
			System.out.println("error in update Feedback....");
			e.printStackTrace();
		}
		return flag;
	}
}