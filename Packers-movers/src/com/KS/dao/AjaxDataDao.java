package com.KS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.KS.bean.VehicleBean;
import com.KS.util.DbConnection;

public class AjaxDataDao {

	public List<VehicleBean> getAllType(String vehCategory) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;	
		ResultSet rs = null;
		List<VehicleBean> list = null;

		VehicleBean bean = null;

		con = DbConnection.getConnection();

		if (con != null) {
		
			stmt = con.createStatement();
			String selectSQL = "select * from  vehicle where  vehicle_category= '"+ vehCategory+"'";
			System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new VehicleBean();
				list = new ArrayList<VehicleBean>();
				bean.setVehicleId("-1");
				bean.setVehicleType(" -- Select Type -- ");
				list.add(bean);

				/*for (long infinit = 0; infinit <= 200000000; infinit++) {
					
					This code will generate delay.
					 *Remove this for loop for in project.
					
				}*/

				while (rs.next()) {
					bean = new VehicleBean();
					bean.setVehicleId(rs.getString("vehicle_id"));
					bean.setVehicleType(rs.getString("vehicle_type"));
					list.add(bean);
				}
			}
		}
		System.out.println("Vehicle Type List : "+list.size());
		return list;
	}
}	