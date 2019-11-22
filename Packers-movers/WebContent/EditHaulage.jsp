<%@page import="com.KS.util.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.KS.bean.HaulageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		HaulageBean bean = (HaulageBean) request.getAttribute("HaulageBean");
	%>

	<%
		Connection con = null;
		Statement stmt = null,stmt1=null;
		ResultSet rs = null, rs1=null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			stmt1=con.createStatement();
			String selectQ = "select * from service";
			String Q="select * from route";
			rs = stmt.executeQuery(selectQ);
			rs1=stmt1.executeQuery(Q);
		} 
		catch (Exception e) {
			System.out.println("Error EditHaulage.jsp::in select service/route");
			e.printStackTrace();
		}
	%>


	<%
		String HaulTypeError = (String) request.getAttribute("HaulTypeError");
		String NoOfItemsError = (String) request.getAttribute("NoOfItemsError");
		String ShipmentStatusError=(String)request.getAttribute("ShipmentStatusError");
		String AdPaymentStatusError=(String)request.getAttribute("AdPaymentStatusError");
		String BookingDateTimeError=(String)request.getAttribute("BookingDateTimeError");
		String DeliveryDateError=(String)request.getAttribute("DeliveryDateError");
		String ServiceError=(String)request.getAttribute("ServiceError");
		String TotalAmtError=(String)request.getAttribute("TotalAmtError");
		String RouteError=(String)request.getAttribute("RouteError");
		String AreaError=(String)request.getAttribute("AreaError");
	%>



	<form action="UpdateHaulageServlet">
		<input type="hidden" name="haulId" value="<%=bean.getHaulId()%>" />
		Haulage type:<input type="text" name="haulType"  value="<%=bean.getHaulType()==null? "":bean.getHaulType() %>" />
		<%=HaulTypeError == null ? "" : HaulTypeError%>
		
		<br>No of Items:<input type="number" name="noOfItems"  value="<%=bean.getNoOfItems()==null? "":bean.getNoOfItems() %>" />
		<%=NoOfItemsError == null ? "" : NoOfItemsError%>
		
		<br>Shipment Status:<input type="number" name="shipmemtStatus" value="<%=bean.getShipmentStatus()==null? "":bean.getShipmentStatus() %>" />
		<%=ShipmentStatusError == null ? "" : ShipmentStatusError%>
		
		<br>Advance Payment status:<input type="number" name="adPaymentStatus" value="<%=bean.getAdPaymentStatus()==null? "":bean.getAdPaymentStatus() %>" />
		<%=AdPaymentStatusError == null ? "" : AdPaymentStatusError%>
		
		<br>Booking date-Time:<input type="datetime-local" name="bookingDateTime"  value="<%=bean.getBookingDateTime()==null? "":bean.getBookingDateTime() %>" />
		<%=BookingDateTimeError == null ? "" : BookingDateTimeError%>
		
		<br>Delivery date:<input type="date" name="deliveryDate"  value="<%=bean.getDeliveryDate()==null? "":bean.getDeliveryDate() %>" />
		<%=DeliveryDateError == null ? "" : DeliveryDateError%> 
		
		
		<br> Service: <select name="service">
			<option value="-1">Please select Service</option>
			<%
				String type, id;
				while (rs.next()) {
					id = rs.getString("Service_id");
					type = rs.getString("Service_type");
			
				
					if (bean.getServiceId().equals(id))
					{
				%>
					<option value="<%=id%>" selected="selected"><%=type%></option>
				<% } else { %>
					<option value="<%=id%>"><%=type%></option>
				<% }
				} %>
		</select><%=ServiceError == null ? "" : ServiceError%> 

		<br>Total amount:<input type="text" name="totalAmt"  value="<%=bean.getTotalAmount()==null? "":bean.getTotalAmount() %>" />
		<%=TotalAmtError == null ? "" : TotalAmtError%> 

		<br> Route: <select name="route">
			<option value="-1">Please select route</option>
			<%
				String id1,via;
				while (rs1.next()) {
					id1 = rs1.getString("Route_id");
					via = rs1.getString("Route_via");

					if (bean.getRouteId().equals(id1))
					{
				%>
					<option value="<%=id1%>" selected="selected"><%=via%></option>
				<%
					} 
					else
					{
				%>
					<option value="<%=id1%>"><%=via%></option>
				<%
					}
				
				}
			%>
		</select><%=RouteError == null ? "" : RouteError%> 
		<br>Area:<input type="text" name="area"  value="<%=bean.getArea()==null? "":bean.getArea() %>" />
		<%=AreaError == null ? "" : AreaError%> 
		
		<br> <input type="submit" value="Update" />

	</form>
</body>
</html>