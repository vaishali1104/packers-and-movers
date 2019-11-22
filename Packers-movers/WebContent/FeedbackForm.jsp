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
<title>Feedback Form</title>
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
			String selectQ = "select * from user";
			rs = stmt.executeQuery(selectQ);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	%>


	<%
		String IsResponseError = (String) request.getAttribute("IsResponseError");
		String DescriptionError = (String) request.getAttribute("DescriptionError");
		String CustIdError = (String) request.getAttribute("CustIdError");
		String VenIdError = (String) request.getAttribute("VenIdError");
	%>


	<form action="FeedbackFormServlet">
		Is Response: <input type="text" name="isResponse" value="${IsResponseValue}" />
		<%=IsResponseError == null ? "" : IsResponseError%>
		
		<br>Description: <textarea cols="30" name="description" rows="5" value="${DescriptionValue}"></textarea>
		<%=DescriptionError == null ? "" : DescriptionError%>
		
	<%-- 	<br> User: <select name="user">
			<option value="-1">Please select User</option>
			<%
				String nm, id;
				while (rs.next()) 
				{
					id = rs.getString("user_id");
					nm = rs.getString("user_name");
			%>

			<option value="<%=id%>"><%=nm%></option>
			<%
					}
			%>
			</select><%=UserIdError == null ? "" : UserIdError%>
	--%>
		 
		 <br> <input type="submit" value="Submit" />
	</form>
</body>
</html>