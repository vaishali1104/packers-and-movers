package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.KS.bean.HaulageBean;
import com.KS.util.DbConnection;

public class HaulageDao {
	public boolean insertHaulage(HaulageBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String insertQ = "insert into haulage (Cust_id,Ven_id,Delivery_status,Booking_date,Delivery_date,Service_id,Total_amt,Pickup_loc,Delivery_loc,haul_title,haul_status,auth_code) values ("
					+ bean.getCustId() + "," + bean.getVenId() + ","
					+ bean.getDeliveryStatus() + ",'" + bean.getBookingDate() + "','"+ bean.getDeliveryDate() + "'," + bean.getServiceId() + "," + bean.getTotalAmount() + ",'"
					+ bean.getPickupLoc() + "','" + bean.getDeliveryLoc() + "','" + bean.getHaulTitle() +"','" + bean.getHaulStatus() +"','"+bean.getAuthCode()+"')";
			System.out.println(insertQ);
			int i = stmt.executeUpdate(insertQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in insert haulage....");
			e.printStackTrace();
		}
		return flag;
	}

	public int lastHaulage(String userId) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from haulage where cust_id = " + userId + " order by haul_id desc limit 1";

			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) {
				return rs.getInt("haul_id");
			}
		} catch (Exception e) {
			System.out.println("error in  haulage::get last haulage....");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<HaulageBean> listHaulage() {
		ArrayList<HaulageBean> list = new ArrayList<HaulageBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from haulage";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			HaulageBean bean = null;
			while (rs.next()) {
				bean = new HaulageBean();
				bean.setHaulId(rs.getString("haul_id"));
				bean.setCustId(rs.getString("cust_id"));
				bean.setVenId(rs.getString("ven_id"));
				bean.setDeliveryStatus(rs.getString("delivery_status"));
				bean.setBookingDate(rs.getString("booking_date"));
				bean.setDeliveryDate(rs.getString("delivery_date"));
				bean.setServiceId(rs.getString("service_id"));
				bean.setTotalAmount(rs.getString("total_amt"));
				bean.setPickupLoc(rs.getString("pickup_loc"));
				bean.setDeliveryLoc(rs.getString("delivery_loc"));
				bean.setHaulTitle(rs.getString("haul_title"));
				bean.setHaulStatus(rs.getString("haul_status"));
				bean.setAuthCode(rs.getString("auth_code"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list haulage....");
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<HaulageBean> getVenQuotationRequestHaulage() {
		ArrayList<HaulageBean> list = new ArrayList<HaulageBean>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select user.user_name , haulage.haul_id from user , haulage where user.user_id = haulage.cust_id and haulage.haul_status ='estimate'";
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			HaulageBean bean = null;
			while (rs.next())
			{
				bean = new HaulageBean();
				bean.setHaulId(rs.getString("haulage.haul_id"));
				bean.setUserName(rs.getString("user.user_name"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("error in  list haulage....");
			e.printStackTrace();
		}
		return list;
	}
	
	

	public boolean deleteHaulage(String haulId) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String deleteQ = "delete from haulage where haul_id = " + haulId;
			System.out.println(deleteQ);
			int i = stmt.executeUpdate(deleteQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in delete haulage....");
			e.printStackTrace();
		}
		return flag;
	}

	public HaulageBean getDataByPk(String haulId) {
		HaulageBean bean = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from haulage where haul_id = " + haulId;
			System.out.println(selectQ);
			rs = stmt.executeQuery(selectQ);
			if (rs.next()) {
				bean = new HaulageBean();
				bean.setHaulId(rs.getString("haul_id"));
				bean.setCustId(rs.getString("cust_id"));
				bean.setVenId(rs.getString("ven_id"));
				bean.setDeliveryStatus(rs.getString("delivery_status"));
				bean.setBookingDate(rs.getString("booking_date"));
				bean.setDeliveryDate(rs.getString("delivery_date"));
				bean.setServiceId(rs.getString("service_id"));
				bean.setTotalAmount(rs.getString("total_amt"));
				bean.setPickupLoc(rs.getString("pickup_loc"));
				bean.setDeliveryLoc(rs.getString("delivery_loc"));
				bean.setHaulTitle(rs.getString("haul_title"));
				bean.setHaulStatus(rs.getString("haul_status"));
				bean.setAuthCode(rs.getString("auth_code"));
				
			}
		} catch (Exception e) {
			System.out.println("error in  haulage::get data by pk....");
			e.printStackTrace();
		}
		return bean;
	}

	public boolean updateHaulage(HaulageBean bean) {
		boolean flag = false;

		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update haulage set cust_id = "+ bean.getCustId() + " , ven_id = " + bean.getVenId() + " , delivery_status = "
					+ bean.getDeliveryStatus() + ", booking_date = '" + bean.getBookingDate() + "' , delivery_date = '" + bean.getDeliveryDate()
					+ "' , service_id = " + bean.getServiceId() + " , total_amt = " + bean.getTotalAmount()
					+ " , pickup_loc = '" + bean.getPickupLoc() + "' , delivery_loc = '" + bean.getDeliveryLoc()
					+ "', haul_title='"+bean.getHaulTitle()+"', haul_status='"+bean.getHaulStatus()+"',auth_code='"+bean.getAuthCode()+"' where haul_id = " + bean.getHaulId();
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in update haulage....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public boolean updateHaulageStatus(String haulId,String venId,String authCode,String deliveryDate,int amount) {
		boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update haulage set ven_id= "+venId+" , delivery_status ='pending' , haul_status='approved',auth_code='"+authCode+"',delivery_date='"+deliveryDate+"',total_amt="+amount+" where haul_id = " +haulId;
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in update haulage....");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateHaulStatus(String haulId) {
		boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String updateQ = "update haulage set haul_status='quoted' where haul_id ="+haulId;
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in update haulage....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public boolean updateDeliveryStatus(String haulId,String delStatus) {
		boolean flag = false;
		
		Connection con = null;
		Statement stmt = null;
		System.out.println("delivery status:"+delStatus+"\n haulId:"+haulId);
		String updateQ="";
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			if(delStatus.equals("delivered"))
				updateQ = "update haulage set delivery_status ='delivered' , haul_status='delivered' where haul_id = " +haulId;
			else
				updateQ = "update haulage set delivery_status ='pending' , haul_status='approved' where haul_id = " +haulId;
			System.out.println(updateQ);
			int i = stmt.executeUpdate(updateQ);
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("error in update haulage....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
