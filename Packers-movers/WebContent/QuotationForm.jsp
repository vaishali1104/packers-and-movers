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
			String selectQ = "select * from user";
			rs = stmt.executeQuery(selectQ);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	%>


	<%
		String QuotPriceError = (String) request.getAttribute("QuotPriceError");
		String DeliveryDateError = (String) request.getAttribute("DeliveryDateError");
		
	%>


	<form action="QuotationFormServlet">
		Quotation price: <input type="text" name="quotPrice" value="${QuotPriceValue}" />
		<%=QuotPriceError == null ? "" : QuotPriceError%>
		
		Delivery date: <input type="date" name="deliveryDate" value="${DeliveryDateValue}" />
		<%=DeliveryDateError == null ? "" : DeliveryDateError%>
		
	 <br> <input type="submit" value="Submit" />
	</form>
</body>
</html>