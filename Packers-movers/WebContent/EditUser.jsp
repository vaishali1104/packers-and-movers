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
<%@page import="com.KS.bean.UserBean"%>
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
		UserBean bean = (UserBean) request.getAttribute("UserBean");
	%>

	<%
		Connection con = null;
		Statement stmt = null,stmt1=null;
		ResultSet rs = null, rs1=null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			stmt1=con.createStatement();
			String selectQ = "select * from user_type";
			String Q="select * from security_question";
			rs = stmt.executeQuery(selectQ);
			rs1=stmt1.executeQuery(Q);
		} 
		catch (Exception e) {
			System.out.println("Error EditUser.jsp::in select user_type");
			e.printStackTrace();
		}
	%>


	<%
		String NameError = (String) request.getAttribute("NameError");
		String EmailError = (String) request.getAttribute("EmailError");
		String PasswordError = (String) request.getAttribute("PasswordError");
		String PhoneNoError=(String)request.getAttribute("PhoneNoError");
		String UserTypeError=(String)request.getAttribute("UserTypeError");
		String Security_questionIdError=(String)request.getAttribute("Security_questionIdError");
		String AnswerError=(String)request.getAttribute("AnswerError");
	
	%>



<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="AdminHomeServlet"><i class="fa fa-home nav_icon"></i>Dashboard</a>
						</li>
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
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="forms">
					
					<div class="row">
						<h3 class="title1">Edit User :</h3>
						<div class="form-three widget-shadow">
							<form class="form-horizontal" action="UpdateUserServlet">
								<input type="hidden" class="form-control1" id="disabledinput" name="userId" value="<%=bean.getUserId()%>">
								<input type="hidden" class="form-control1" id="disabledinput" name="userType" value="<%=bean.getUserTypeId()%>">
								<input type="hidden" class="form-control1" id="disabledinput" name="security_questionId" value="<%=bean.getSecurity_questionId()%>">
								<div class="form-group">
									<label class="col-sm-2 control-label">User Type</label>
									<div class="col-sm-8">
										<select class="form-control1" name="userType" disabled>
											<option value="-1">Please select User Type</option>
											<%
												String n, i;
												while (rs.next())
												{
													i = rs.getString("user_type_id");
													n = rs.getString("user_type_name");
											%>
												<%
													if (bean.getUserTypeId().equals(i))
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
												%>

											<%
												}
											%>
										</select>
										<%=UserTypeError == null ? "" : UserTypeError%> 
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">User Name</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="name" value="<%=bean.getUserName()==null? "":bean.getUserName() %>">
										<%=NameError == null ? "" : NameError%>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
									<div class="col-sm-8">
										<input type="email" class="form-control1" id="focusedinput" required name="emailId" value="<%=bean.getUserEmail()==null? "":bean.getUserEmail() %>"/>
										<%=EmailError == null ? "" : EmailError%>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">User Phone No</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="phoneNo" value="<%=bean.getPhoneNo()==null? "":bean.getPhoneNo() %>">
										<%=PhoneNoError==null?"": PhoneNoError %>
									</div>
								</div>
								
								<div class="form-group">
									<label for="disabledinput" class="col-sm-2 control-label">User Password</label>
									<div class="col-sm-8">
										<input disabled type="password" class="form-control1" id="disabledinput" name="password" value="<%=bean.getUserPassword()%>" disabled/>
										<%=PasswordError == null ? "" : PasswordError%>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Security Question</label>
									<div class="col-sm-8">
										<select class="form-control1" name="security_questionId" disabled>
											<option value="-1">Please select Security Question</option>
											<%
												String q, j;
												while (rs1.next())
												{
													j = rs1.getString("security_question_id");
													q = rs1.getString("security_question");
											%>

												<%
													if (bean.getSecurity_questionId().equals(j))
													{
												%>
													<option value="<%=j%>" selected="selected"><%=q%></option>
												<%
													} 
													else
													{
												%>
													<option value="<%=j%>"><%=q%></option>
												<%
													}
												%>

											<%
												}
											%>
										</select>
										<%=Security_questionIdError == null ? "" : Security_questionIdError%> 
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Answer</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" required name="answer" value="<%=bean.getAnswer()%>" disabled/>
										<%=AnswerError == null ? "" : AnswerError%>
									</div>
								</div>
								<input type="submit" value="Update"/>
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