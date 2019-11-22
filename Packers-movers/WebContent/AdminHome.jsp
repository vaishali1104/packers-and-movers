<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Her@Feri Admin Panel :Home</title>
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
<link href='//fontsA.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="cssA/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="jsA/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<script src="jsA/Chart.js"></script>
<!-- //chart -->
<!--Calender-->
<link rel="stylesheet" href="cssA/clndr.css" type="text/css" />
<script src="jsA/underscore-min.js" type="text/javascript"></script>
<script src= "jsA/moment-2.2.1.js" type="text/javascript"></script>
<script src="jsA/clndr.js" type="text/javascript"></script>
<script src="jsA/site.js" type="text/javascript"></script>
<!--End Calender-->
<!-- Metis Menu -->
<script src="jsA/metisMenu.min.js"></script>
<script src="jsA/custom.js"></script>
<link href="cssA/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
					  <li> <a href="AdminHomeServlet" class="active"><i class="fa fa-home nav_icon"></i>Dashboard</a> </li>
					  <li class="">
					  
					  <!-- /nav-second-level -->
					  </li>
						<li></li>
						
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
									<a href="ListUserTypeServlet">User_type</a>								</li>
							</ul>
							<!-- /nav-second-level -->
						</li>
							
							<!-- //nav-second-level --></li>
						
						
						
					</ul>
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
					<a href="AdminHomeServlet">
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
							
						</li>
						<li class="dropdown head-dpdn">
							
								
						</li>	
						<li class="dropdown head-dpdn">
							
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
		
		
<%
	String deliveryCount=(String)request.getAttribute("DeliveryCount");
String orderCount=(String)request.getAttribute("OrderCount");
String userCount=(String)request.getAttribute("UserCount");

%>
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="row-one">
					<div class="col-md-4 widget">
						<div class="stats-left ">
							<h5>Total</h5>
							<h4>Delivery</h4>
						</div>
						<div class="stats-right">
							<label><%=deliveryCount %></label>
						</div>
						<div class="clearfix"> </div>	
					</div>
					<div class="col-md-4 widget states-mdl">
						<div class="stats-left">
							<h5>Total</h5>
							<h4>Orders</h4>
						</div>
						<div class="stats-right">
							<label><%=orderCount %></label>
						</div>
						<div class="clearfix"> </div>	
					</div>
					<div class="col-md-4 widget states-last">
						<div class="stats-left">
							<h5>Total</h5>
							<h4>Users</h4>
						</div>
						<div class="stats-right">
							<label><%=userCount %></label>
						</div>
						<div class="clearfix"> </div>	
					</div>
					<div class="clearfix"> </div>	
				</div>
				
				
			  <div class="row"></div>
				<div class="row calender widget-shadow">
					<h4 class="title">Calender</h4>
					<div class="cal1">
						
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<!--footer-->
		<div class="footer">
		   <p>		&copy; 2018 Her@Feri Admin Panel</p>
      </div>
        <!--//footer-->
	</div>
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