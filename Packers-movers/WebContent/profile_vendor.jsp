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
<%@page import="com.KS.bean.Vendor_detailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Her@feri</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords" content="Transporters web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--// Meta tag Keywords -->

<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="cssl/fontl-awesome.min.css" /><!-- login -->
<link href="csss/style.css" rel='stylesheet' type='text/css' media="all"><!-- login -->

	
<link href="//fontsl.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet"><!-- login -->
<!-- //css files -->

<!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>

<%UserBean userBean1=(UserBean) session.getAttribute("UserBean"); %>

	<%
		UserBean bean = (UserBean) request.getAttribute("UserBean");
		Vendor_detailBean vbean = (Vendor_detailBean) request.getAttribute("Vendor_detailBean");
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
			System.out.println("Error EditUser.jsp::in select user_type && security quetsion");
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
	
	
	
	<%
		String AddressError = (String) request.getAttribute("AddressError");
		String MaxVehicleError = (String) request.getAttribute("MaxVehicleError");
		String LicenseError = (String) request.getAttribute("LicenseError");
		String CityError = (String) request.getAttribute("CityError");
		String CompanyNameError = (String) request.getAttribute("CompanyNameError");
		String SucessMessage=(String)request.getAttribute("SucessMessage"); 
	%>
	





<div class="header">
		<nav class="navbar navbar-default">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<h1><a href="UserHome.jsp">Her@feri</a></h1>
					</div>
					
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-left">
							<li><a class="hvr-underline-from-center active" href="UserHome.jsp">Home</a></li>
							<li><a href="services.jsp" class="hvr-underline-from-center">Services</a></li>
							
							<li><a href="gallery.jsp" class="hvr-underline-from-center">Gallery</a></li>
							
									
							<li><a href="contact.jsp" class="hvr-underline-from-center">Contact</a>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="ShowRequestServlet" class="hvr-underline-from-center">My Shipments</a></li>
							<li><a href="ShowVenProfileServlet?userId=<%=userBean1.getUserId() %>" class="hvr-underline-from-center">My Profile</a></li>
							<li><a href="LogoutServlet" class="hvr-underline-from-center">LogOut</a></li>
							
						</ul>
					</div>

					<div class="clearfix"> </div>	
				</nav>
	
	</div>		
<div class="banner1">
</div>
<div class="about-breadcrumb">
		<div class="container">
			<ul>
				<li><a href="UserHome.jsp">Home</a><i>></i></li>
				<li>My Profile</li>
			</ul>
		</div>
</div>
<!-- signup section -->
<div class="w3ls-banner">
	<div class="heading">
		<h1>My Profile</h1>
	</div>
		<div class="container">
			<center><%=SucessMessage==null?" ":SucessMessage%></center>
			<div class="heading">
				<p>*You can edit your Profile here</p>
			</div>
			<div class="agile-form">
				<form action="UpdateVenProfileServlet" method="post">
					<ul class="field-list">
						<li>
							<input type="hidden" name="userId" value="<%=bean.getUserId()%>">
							<input type="hidden" name="vendor_detailId" value="<%=vbean.getVendorDetailId()%>">
							<input type="hidden" name="userType" value="<%=bean.getUserTypeId()%>">
						</li>
						<li> 
							<label class="form-label"> Name <span class="form-required"> * </span></label>
							<div class="form-input">
								<input type="text" name="name" value="<%=bean.getUserName()==null? "":bean.getUserName() %>">
								<%=NameError == null ? "" : NameError%>
							</div>
						</li>
						
						<li>
							<label class="form-label"> User Type<span class="form-required"> * </span></label>
							<div class="form-input">
								<select class="form-dropdown" name="userType" disabled>
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
						</li>
						<li> 
							<label class="form-label"> E-Mail Address </label>
							<div class="form-input">
								<input type="email" name="emailId" value="<%=bean.getUserEmail()==null? "":bean.getUserEmail() %>"/>
								<%=EmailError == null ? "" : EmailError%>
							</div>
						</li>
						<li> 
							<label class="form-label"> Phone Number </label>
							<div class="form-input">
								<input type="text" name="phoneNo" value="<%=bean.getPhoneNo()==null? "":bean.getPhoneNo() %>">
										<%=PhoneNoError==null?"": PhoneNoError %>
							</div>
						</li>
						<li> 
							<label class="form-label">Office Address <span class="form-required"> * </span></label>
							<div class="form-input">
								<input type="text" name="address" value="<%=vbean.getAddress() == null ? "" : vbean.getAddress()%>" />
								<%=AddressError == null ? "" : AddressError%>
							</div>
						</li>
						<li> 
							<label class="form-label">Max. Vehicle <span class="form-required"> * </span></label>
							<div class="form-input">
								<input type="text" required name="maxVehicle" value="<%=vbean.getMaxVehicle() == null ? "" : vbean.getMaxVehicle()%>" />
								<%=MaxVehicleError == null ? "" : MaxVehicleError%>
							</div>
						</li>
						<li> 
							<label class="form-label">Company name <span class="form-required"> * </span></label>
							<div class="form-input">
								<input type="text" required name="companyName" value="<%=vbean.getCompanyName() == null ? "" : vbean.getCompanyName()%>" />
								<%=CompanyNameError == null ? "" : CompanyNameError%>
							</div>
						</li>
						
						<li> 
							<label class="form-label">License: </label>
							<div class="form-input">
								<img name="licence1" src="photos/<%=vbean.getUserId()%>/<%=vbean.getLicense()%>" height="50%" width="50%">
								<%=LicenseError == null ? "" : LicenseError%>							
							</div>
						</li>
						<li> 
							<label class="form-label">Your Password </label>
							<div class="form-input">
								<input type="password" name="password" value="<%=bean.getUserPassword()%>"/>
								<%=PasswordError == null ? "" : PasswordError%>
							</div>
						</li>
						<li>
							<label class="form-label">Security Question<span class="form-required"> * </span></label>
							<div class="form-input">
								<select class="form-dropdown" name="security_questionId">
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
										<%=Security_questionIdError == null ? " " : Security_questionIdError%> 
								</div>
						</li>
						<li> 
							<label class="form-label">Your Answer </label>
							<div class="form-input">
								<input type="text" name="answer" value="<%=bean.getAnswer()%>"/>
								<%=AnswerError == null ? "" : AnswerError%>
							</div>
						</li>
						
						
					</ul>
					<div class="submit_btn">
						<input type="submit" value="Update">
					</div>
				</form>	
			</div>
		</div>
<!--signup close>

<!-- footer -->
	<footer>
		<div class="agileits-w3layouts-footer">
			
				<div class="col-md-4 w3-agile-grid">
					<h5>About Us</h5>
					<p>We have been established since 2009<br>The vendors are fully secure and no malpractice.<br>Till now all Customer are satisfied from our work<br>The works are very well trained.</p>
					<div class="footer-agileinfo-social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-rss"></i></a></li>
							<li><a href="#"><i class="fa fa-vk"></i></a></li>
						</ul>
					</div>
				</div>
				
				<div class="col-md-4 w3-agile-grid">
					<h5>Address</h5>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Phone Number</h6>
								<p>+91(079)23297201</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>Email :<a href="mailto:example@email.com">herafari@gmail.com</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p> Navarangpura,Ahmedabad, Gujarat,India. 
								<br>Telephone : +91(079)23297201
								</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="col-md-4 w3-agile-grid">
					<h5>Recent Posts</h5>
					<div class="w3ls-post-grids">
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a href="#" data-toggle="modal" data-target="#myModal">Vehicle transfer in Ahmedabad</a></h6>
								<p>June 10,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p2.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a href="#" data-toggle="modal" data-target="#myModal">Household item tranfser in Ahmedabad</a></h6>
								<p>June 17,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p3.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a href="#" data-toggle="modal" data-target="#myModal">Office Removals tranfser in Ahmedabad</a></h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a href="#" data-toggle="modal" data-target="#myModal">Pets transfer in Ahmedabad</a></h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		
		<div class="copyright">
			<div class="container">
				<p>© Her@feri home page </p>
			</div>
		</div>
	</footer>
	<!-- //footer -->
<!-- js-scripts -->					
<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
<!-- //js -->	
<!-- //js-scripts -->

<!-- start-smoth-scrolling -->
<script src="js/SmoothScroll.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<!-- //here ends scrolling icon -->
<!-- start-smoth-scrolling -->

</body>
</html>