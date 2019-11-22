<%@ page import="java.sql.ResultSet" %>
<%@page import="com.KS.util.DbConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Form</title>
</head>
<body>

	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from service";
			rs = stmt.executeQuery(selectQ);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	%>


	<%
		String ServiceIdError = (String) request.getAttribute("ServiceIdError");//null
		String UserIdError = (String) request.getAttribute("UserIdError");
	%>


	<form action="Service_vendorFormServlet">
		<br> Service: <select name="serviceId">
			<option value="-1">Please select Service</option>
			<%
				String type, id;
				while (rs.next()) {
					id = rs.getString("service_id");
					type = rs.getString("service_type");
			%>

			<option value="<%=id%>"><%=type%></option>
			<%
				}
			%>
		</select><%=UserIdError == null ? "" : UserIdError%>
		 <br> <input type="submit" value="Submit" />
	</form>
</body>
</html>