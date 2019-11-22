<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="com.KS.util.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.KS.bean.RouteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Her@Feri Admin Panel :Forms</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="cssA/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="cssA/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="cssA/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
<script src="jsA/jquery-1.11.1.min.js"></script>
<script src="jsA/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="cssA/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="jsA/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="jsA/metisMenu.min.js"></script>
<script src="jsA/custom.js"></script>
<link href="cssA/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
	<%
	RouteBean bean = (RouteBean) request.getAttribute("RouteBean");
	%>

	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from city";
			rs = stmt.executeQuery(selectQ);

		} catch (Exception e) {
			e.printStackTrace();
		}
	%>


	<%
	String OriginError = (String) request.getAttribute("OriginError");
    String DestinationError = (String) request.getAttribute("DestinationError");
	String CityIdError = (String) request.getAttribute("CityIdError");
	String RouteViaError = (String) request.getAttribute("RouteViaError");
	%>


<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="AdminHome.jsp"><i class="fa fa-home nav_icon"></i>Dashboard</a>
						</li>
						<li class="">
					  
					  <!-- /nav-second-level -->
					  </li>
						<li></li>
						<li>
							<a href="#"><i class="fa fa-envelope nav_icon"></i>Mailbox<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="inbox.jsp">Inbox <span class="nav-badge-btm">05</span></a>								</li>
								<li>
									<a href="compose.jsp">Compose email</a>								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						<li>
							<a href="#"><i class="fa fa-table nav_icon"></i>Tables<span class="fa arrow"></span></a>																											
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="ListUserServlet">User<span class="nav-badge-btm"></span></a>								</li>
								<li>
									<a href="ListVendor_detailServlet">Vendor_detail</a>								</li>
								<li>
									<a href="ListStateServlet">State</a>								</li>
								<li>
									<a href="ListCityServlet">City</a>								</li>
								<li>
									<a href="ListFeedbackServlet">Feedback</a>								</li>
								<li>
									<a href="ListServiceServlet">Service</a>								</li>
								<li>
									<a href="ListRouteServlet">Route</a>								</li>
								<li>
									<a href="ListFoodServlet">Food</a>								</li>
								<li>
									<a href="ListVehicleServlet">Vehicle</a>								</li>
								<li>
									<a href="ListHouseholdServlet">Household</a>								</li>
								<li>
									<a href="ListAnimalServlet">Animal</a>								</li>
								<li>
									<a href="ListOffice_removalsServlet">Office_removals</a>			</li>
								<li>
									<a href="ListQuotationServlet">Quotation</a>								</li>
								<li>
									<a href="ListSecurity_questionServlet">Security_question</a>								</li>
								<li>
									<a href="ListService_vendorServlet">Service_vendor</a>								</li>
								<li>
									<a href="ListUserTypeServlet">User_type</a>								</li>
							</ul>
							<!-- /nav-second-level -->
						</li>
							
							<!-- //nav-second-level -->
						<li>
							<a href="#"><i class="fa fa-check-square-o nav_icon"></i>Forms<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="forms.jsp">Basic Forms <span class="nav-badge-btm">07</span></a>								</li>
								<li>
									<a href="validation.jsp">Validation</a>								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
					</ul>
					<div class="clearfix"> </div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="AdminHome.jsp">
						<h1>Her@Feri</h1>
						<span>AdminPanel</span>
					</a>
				</div>
				<!--//logo-->
				<!--search-box-->
				
			</div>
			<div class="header-right">
				<div class="profile_details_left"><!--notifications of menu start -->
					<ul class="nofitications-dropdown">
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3>You have 3 new messages</h3>
									</div>
								</li>
								<li><a href="#">
								   <div class="user_img"><img src="imagesA/1.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet</p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								</a></li>
								<li class="odd"><a href="#">
									<div class="user_img"><img src="imagesA/2.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								  <div class="clearfix"></div>	
								</a></li>
								<li><a href="#">
								   <div class="user_img"><img src="imagesA/3.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								</a></li>
								<li>
									<div class="notification_bottom">
										<a href="#">See all messages</a>
									</div> 
								</li>
							</ul>
						</li>
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3>You have 3 new notification</h3>
									</div>
								</li>
								<li><a href="#">
									<div class="user_img"><img src="imagesA/2.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet</p>
									<p><span>1 hour ago</span></p>
									</div>
								  <div class="clearfix"></div>	
								 </a></li>
								 <li class="odd"><a href="#">
									<div class="user_img"><img src="imagesA/1.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>
								 <li><a href="#">
									<div class="user_img"><img src="imagesA/3.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>
								 <li>
									<div class="notification_bottom">
										<a href="#">See all notifications</a>
									</div> 
								</li>
							</ul>
						</li>	
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">15</span></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3>You have 8 pending task</h3>
									</div>
								</li>
								<li><a href="#">
									<div class="task-info">
										<span class="task-desc">Database update</span><span class="percentage">40%</span>
										<div class="clearfix"></div>	
									</div>
									<div class="progress progress-striped active">
										<div class="bar yellow" style="width:40%;"></div>
									</div>
								</a></li>
								<li><a href="#">
									<div class="task-info">
										<span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
									   <div class="clearfix"></div>	
									</div>
									<div class="progress progress-striped active">
										 <div class="bar green" style="width:90%;"></div>
									</div>
								</a></li>
								<li><a href="#">
									<div class="task-info">
										<span class="task-desc">Mobile App</span><span class="percentage">33%</span>
										<div class="clearfix"></div>	
									</div>
								   <div class="progress progress-striped active">
										 <div class="bar red" style="width: 33%;"></div>
									</div>
								</a></li>
								<li><a href="#">
									<div class="task-info">
										<span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
									   <div class="clearfix"></div>	
									</div>
									<div class="progress progress-striped active">
										 <div class="bar  blue" style="width: 80%;"></div>
									</div>
								</a></li>
								<li>
									<div class="notification_bottom">
										<a href="#">See all pending tasks</a>
									</div> 
								</li>
							</ul>
						</li>	
					</ul>
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="imagesA/a.png" alt=""> </span> 
								  <div class="user-name"><span>Administrator</span> </div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
								<li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> 
								<li> <a href="LogoutServlet"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="forms">
					<div class="row">
						<h3 class="title1">Edit Route Form :</h3>
						<div class="form-three widget-shadow">
							<form class="form-horizontal" action="UpdateRouteServlet">
								<input type="hidden" class="form-control1" id="disabledinput" name="routeId" value="<%=bean.getRouteId()%>" />
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Origin</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="origin" value="<%=bean.getOrigin()==null?"":bean.getOrigin()%>" />
										<%=OriginError == null ? "" : OriginError%>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Destination</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="destination" value="<%=bean.getDestination()==null?"":bean.getDestination()%>" />
										<%=DestinationError == null ? "" : DestinationError%>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">City Id</label>
									<div class="col-sm-8">
										<select class="form-control1"  name="city">
											<option value="-1">Please select City</option>
											<%
												String n, i;
												while (rs.next())
												{
													i = rs.getString("city_id");
													n = rs.getString("city_name");

													if (bean.getCityId().equals(i))
													{
												%>
													<option value="<%=i%>" selected="selected"><%=n%></option>
												<%
													} 
													else
													{
												%>
													<option value="<%=i%>"><%=n%></option>
												<%
													}
												}
											%>
										</select>
										<%=CityIdError == null ? "" : CityIdError%>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Route Via</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="routeVia" value="<%=bean.getRouteVia()==null?"":bean.getRouteVia() %>" />
										<%=RouteViaError == null ? "" : RouteViaError%>
									</div>
								</div>
								<input type="submit" value="Update">
							</form>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
			
		<!--footer-->
		<div class="footer">
		   <p>&copy; 2018 Her@Feri Admin Panel</p>
		</div>
        <!--//footer-->
	<!-- Classie -->
		<script src="jsA/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
	<script src="jsA/jquery.nicescroll.js"></script>
	<script src="jsA/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="jsA/bootstrap.js"> </script>
</body>
</html>