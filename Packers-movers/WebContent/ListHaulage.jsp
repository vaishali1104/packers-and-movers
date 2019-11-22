<%@page import="com.KS.bean.HaulageBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<HaulageBean> list = (ArrayList<HaulageBean>) request.getAttribute("HaulageList");
	HaulageBean bean = null;
	%>

	<table border="1">
		<tr>
			<td>HaulageId</td>
			<td>Haulage Type</td>
			<td>No of items</td>
			<td>CustId</td>
			<td>VenId</td>
			<td>Ad_PaymentStatus</td>
			<td>Shipping status</td>
			<td>Booking Date Time</td>
			<td>Delivery Date</td>
			<td>Service Id</td>
			<td>Total amt</td>
			<td>Route Id</td>
			<td>Payment Id</td>
			<td>Area</td>
			<td>Action</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++)
			{

				bean = list.get(i);
		%>
		<tr>
			<td><%=bean.getHaulId()%></td>
			<td><%=bean.getHaulType()%></td>
			<td><%=bean.getNoOfItems() %></td>
			<td><%=bean.getCustId()%></td>
			<td><%=bean.getVenId()%></td>
			<td><%=bean.getAdPaymentStatus()%></td>
			<td><%=bean.getShipmentStatus() %></td>
			<td><%=bean.getBookingDateTime() %></td>			
			<td><%=bean.getDeliveryDate()%></td>
			<td><%=bean.getServiceId() %></td>
			<td><%=bean.getTotalAmount() %></td>
			<td><%=bean.getRouteId() %></td>
			<td><%=bean.getPaymentId() %></td>
			<td><%=bean.getArea() %></td>
			<td><a href="EditHaulageServlet?haulId=<%=bean.getHaulId()%>">Edit</a> | <a
				href="DeleteHaulageServlet?haulId=<%=bean.getHaulId()%>">Delete</a></td>
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>