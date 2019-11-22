<%@ page import="com.KS.bean.UserBean" %>
<%@ page import="com.KS.util.*" %>
<%@ page import="java.sql.*" %>

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

<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"><link rel="stylesheet" href="css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> 
<link rel="stylesheet" href="css/font-awesome.css"> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

<% UserBean userBean = (UserBean) session.getAttribute("UserBean");
   System.out.print("hiii ==>> "+userBean); %> 

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
						<%if(userBean==null) {%>
						<ul class="nav navbar-nav navbar-right mt-0">
							<li><a href="login.jsp" class="hvr-underline-from-center">Login</a></li>
							<li><a href="Signup.jsp" class="hvr-underline-from-center">SignUp</a></li>
							
						</ul>
						<%} else {%>
						<ul class="nav navbar-nav navbar-right">
							
							<%if(userBean.getUserTypeId().equals("1")){%>
							<li><a href="CustFinalServlet" class="hvr-underline-from-center">My Shipments</a></li>
							<li><a href="ShowProfileServlet?userId=<%=userBean.getUserId()%>" class="hvr-underline-from-center">My Profile</a></li>
							<%}
							else if(userBean.getUserTypeId().equals("2")){%>
							<li><a href="ShowRequestServlet" class="hvr-underline-from-center">My Shipments</a></li>
							<li><a href="ShowVenProfileServlet?userId=<%=userBean.getUserId()%>" class="hvr-underline-from-center">My Profile</a></li>
							<%}%>
							
							<li><a href="LogoutServlet" class="hvr-underline-from-center">Logout</a></li>
							
						</ul>
						<%} %>
					</div>
					
					<div class="clearfix"> </div>	
				</nav>
	</div>
	
<!-- Slider -->
<div class="slider h-auto">
	<div class="callbacks_container">
		<ul class="rslides" id="slider" name="slider">
			<% for(int i=1;i<5;i++) {%> 
			<li>
				<div class="w3layouts-banner-top<%=i%>">
					<div class="banner-dott">
					<div class="container">
						<div class="slider-info">
							<div class="col-md-8">
							  <div class="bannergrids">
								  <div class="col-md-4 grid1">
										<i class="fa fa-car" aria-hidden="true"></i>
										<p><b>Vehicles</b></p>
									</div>
								 	<!-- <div class="col-md-4 grid1">
										<i class="fa fa-cutlery" aria-hidden="true"></i>
										<p><b>Food</b></p>
									</div>  -->
									<div class="col-md-4 grid1">
										<i class="fa fa-home" aria-hidden="true"></i>
										<p><b>Household Items</b></p>
									</div>
                                    <div class="col-md-4 grid1">
										<i class="fa fa-table" aria-hidden="true"></i>
										<p><b>Office Removal</b></p>
									</div>
                                    <!-- <div class="col-md-4 grid1">
										<i class="fa fa-paw" aria-hidden="true"></i>
										<p><b>Pets</b></p>
									</div> -->
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="banner-form-agileinfo">
									<h5 align="center">Are you a ?</h5>
									<%if(userBean==null) {%>
									<form action="#" method="post">
										<br><br>
										<input type="submit" onclick="form.action='login.jsp';"class="hvr-shutter-in-vertical" value="CUSTOMER">
										<br><br>
									
                                        <input type="submit" onclick="form.action='login.jsp';" class="hvr-shutter-in-vertical" value="VENDOR">  	
									</form>
									<%}else if(userBean.getUserTypeId().equals("1")) { %>
									<form action="#" method="post">
										<br><br>
										<input type="submit" onclick="form.action='customer.jsp';"class="hvr-shutter-in-vertical" value="CUSTOMER">
										<br><br>
									
                                        <input type="submit" onclick="form.action='login.jsp';" class="hvr-shutter-in-vertical" value="VENDOR">  	
									</form>
									<%} else if(userBean.getUserTypeId().equals("2")) { %>
									<form action="#" method="post">
									<br><br>
									<input type="submit" onclick="form.action='login.jsp';"class="hvr-shutter-in-vertical" value="CUSTOMER">
									<br><br>
								
                                    <input type="submit" onclick="form.action='ShowRequestServlet';" class="hvr-shutter-in-vertical" value="VENDOR">  	
								</form>
								<%} %>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
			</li>
			<%} %>
		</ul>
	</div>
<div class="clearfix"></div>
</div>
<!-- //Slider -->	

<!-- banner-bottom -->
<div class="banner-bottom">
	<div class="col-md-7 bannerbottomleft">
			<div class="video-grid-single-page-agileits">
				<div data-video="d3q5mRA5djY" id="video"> <img src="images/bg2.jpg" alt="" class="img-responsive" /> </div>
			</div>
	</div>
	<div class="col-md-5 bannerbottomright">
		<h3>How Does We Work?</h3>
		<p>It Bring the Customer and Vendor together at same platform.</p>
		<h4><i class="fa fa-taxi" aria-hidden="true"></i>Various Service provided. </h4>
		<h4><i class="fa fa-shield" aria-hidden="true"></i>Fast & Best Deliver Service</h4>
		<h4><i class="fa fa-ticket" aria-hidden="true"></i>Standard Courier value</h4>
		<h4><i class="fa fa-space-shuttle" aria-hidden="true"></i>Easy And Auto Shipping Service</h4>
		<h4><i class="fa fa-truck" aria-hidden="true"></i>Packaging & Storage</h4>
	</div>
	<div class="clearfix"></div>
</div>
<!-- //banner-bottom -->
			


<!-- team -->
	<div class="team" id="team">
		<div class="container">
			<div class="heading">
				<h3>Our Transporters</h3>
			</div>
			<div class="wthree_team_grids">
				<% String name[]={"Meena Goswami","Rohan Sharma","Aditya Patel","Dhruvi Shah"}; 
				int cnt=0;
				for(String nme:name) {%>
				<div class="col-md-3 wthree_team_grid">
					<div class="hovereffect">
						<img src="images/team<%=++cnt%>.jpg" class="img-responsive" />
						<div class="overlay">
							<h6>Transporters</h6>
							<div class="rotate">
								<p class="group1">
									<a href="http://www.twitter.com"><i class="fa fa-twitter"></i></a>
									<a href="http://www.facebook.com"><i class="fa fa-facebook"></i></a>
								</p>
									<hr><hr>
								<p class="group2">
									<a href="http://www.instagram.com">
										<i class="fa fa-instagram"></i>
									</a>
									<a href="http://dribbble.com">
										<i class="fa fa-dribbble"></i>
									</a>
								</p>
							</div>
						</div>
					</div>
					<h4><%=nme %></h4>
					
				</div>
				<%} %>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //team -->

<!-- Clients -->
	<div class=" col-md-6 clients">
			<h3>Reviews</h3>
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
								<div class="client">
									<img src="images/t1.jpg" alt="" />
									<h5>Shailesh Gajjar</h5>
									<div class="clearfix"> </div>
								</div>
								<p>Great Service ,Cooperative staff,Best service always recommend first for any future work.<br>The vendors are more supportive and helpful nature.</p>
								
						</li>
						<li>	
								<div class="client">
								<img src="images/t2.jpg" alt="" />
									<h5>Matthew Daniels</h5>
									<div class="clearfix"> </div>
								</div>
								<p>The worker were on time and they provide a good support.<br>The Dealers are professional too.<br>They provide the most cheapest vendors.</p>
								
						</li>
						<li>
								<div class="client">
								<img src="images/t3.jpg" alt="" />
									<h5>Prashant Sharma</h5>
									<div class="clearfix"> </div>
								</div>
								<p>Timely service.Team was efficient,<br>The worker were every particular while packing the haulage and shifted items softly. <br>Very satisfied work done.</p>
								
						</li>
						<li>
								<div class="client">
								<img src="images/t4.jpg" alt="" />
									<h5>Ankita Shah</h5>
									<div class="clearfix"> </div>
								</div>
								<p>The service is very good and they provide a platform for the comparison also.<br>No issue and smooth transfer.<br>Workers are good at packing the haulage.</p>
								
						</li>
					</ul>
				</div>
			</section>
</div>
<!-- //Clients -->

<%
		int countVehicle=0,countCity=0,countClient=0;
		Connection conn=null;
		Statement stmt=null,stmt1=null,stmt2=null;
		ResultSet rs=null,rs1=null,rs2=null;
		
		try
		{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			stmt1=conn.createStatement();
			stmt2=conn.createStatement();
			String VselectQ="select max_vehicle from vendor_detail";
			String cityselectQ="select count(*) from city";
			String clientselectQ="select count(*) from haulage where delivery_status='delivered'";
			System.out.println(VselectQ);
			System.out.println(cityselectQ);
			System.out.println(clientselectQ);
			rs = stmt.executeQuery(VselectQ);
			rs1 = stmt1.executeQuery(cityselectQ);
			rs2 = stmt2.executeQuery(clientselectQ);
			
			while(rs.next())
			{
				countVehicle+=Integer.parseInt(rs.getString("max_vehicle"));
				//System.out.println("in maxvehiclecount");
				
			}
			
			if(rs1.next())
			{
				countCity=Integer.parseInt(rs1.getString("count(*)"));
				System.out.println("in citycount");
			}
			if(rs2.next())
			{
				countClient=Integer.parseInt(rs2.getString("count(*)"));
				System.out.println("in usercount");
			}
		}
		catch(Exception e)
		{
			System.out.println("error in userHome");
		}

%>



<!-- Counter -->
	<div class="col-md-6 services-bottom">
			<div class="col-md-6 agileits_w3layouts_about_counter_left">
				<div class="countericon">
					<i class="fa fa-truck" aria-hidden="true"></i>
				</div>
				<div class="counterinfo">
					<p class="counter"><%=countVehicle%></p> 
					<h3>Transport vehicles</h3>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-6 agileits_w3layouts_about_counter_left">
				<div class="countericon">
					<i class="fa fa-fighter-jet" aria-hidden="true"></i>
				</div>
				<div class="counterinfo">
					<p class="counter"><%=countCity%></p> 
					<h3>Number of cities</h3>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
			<div class="col-md-6 agileits_w3layouts_about_counter_left">
				<div class="countericon">
					<i class="fa fa-calendar" aria-hidden="true"></i>
				</div>
				<div class="counterinfo">
					<p class="counter">1</p>
					<h3>Years Of Service</h3>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-6 agileits_w3layouts_about_counter_left">
				<div class="countericon">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="counterinfo">
					<p class="counter"><%=countClient%></p>
					<h3>Happy clients</h3>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
	</div>
			<div class="clearfix"> </div>
<!-- //Counter -->


<!-- our blog -->
<section class="blog" id="blog">
	<div class="container">
		<div class="heading">
			<h3>Vendors</h3>
		</div>
		<div class="blog-grids">
		<div class="col-md-4 blog-grid">
			<a ><img src="images/bg4.jpg" alt="" /></a>
			
			<h4><a >Saaya Movers and Packers</a></h4>
			<p> Shrinanad Nagar Road,Vejalpur<br>Ahmedabad,Gujarat<br>380051,India</p>
			
		</div>
		<div class="col-md-4 blog-grid">
			<a ><img src="images/bg7.jpg" alt="" /></a>
			
			<h4><a >Rising Star Packers and Movers</a></h4>
			<p>Shrianad Nagar Road,Vastrapur<br>Ahmedabad,Gujarat,<br>380051,India</p>
			
		</div>
		<div class="col-md-4 blog-grid">
			<a ><img src="images/bg8.jpg" alt="" /></a>
			
			<h4><a >Agarwal Care Packers and Movers</a></h4>
			<p>Opposite Star Bazaar<br>Satellite Road,Ahmedabad<br>Gujarat,India</p>
			
		</div>
		<div class="clearfix"></div>
		</div>
	</div>
</section>
<!-- //our blog -->

<!-- footer -->
	<footer>
		<div class="agileits-w3layouts-footer">
			<div class="container">
				<div class="col-md-4 w3-agile-grid">
					<h5>About Us</h5>
					<p>We have been established since 2009<br>The vendors are fully secure and no malpractice.<br>Till now all Customer are satisfied from our work<br>The workers are very well trained.</p>
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
								<p>Email :<a href="mailto:heraferi2930@gmail.com">heraferi2930@gmail.com</a></p>
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
								<a><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a>Vehicle transfer in Ahmedabad</a></h6>
								<p>June 10,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a><img src="images/p2.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a>Household item transfer in Ahmedabad</a></h6>
								<p>June 17,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href><img src="images/p3.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a >Office Removals transfer in Ahmedabad</a></h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6><a >Pets transfer in Ahmedabad</a></h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
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

<!-- Baneer-js -->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function () {
			$("#slider").responsiveSlides({
				auto: true,
				pager:false,
				nav: true,
				speed: 1000,
				namespace: "callbacks",
				before: function () {
					$('.events').append("<li>before event fired.</li>");
				},
				after: function () {
					$('.events').append("<li>after event fired.</li>");
				}
			});
		});
	</script>
<!-- //Baneer-js -->

<!-- banner bottom video script -->
<script src="js/simplePlayer.js"></script>
			<script>
				$("document").ready(function() {
					$("#video").simplePlayer();
				});
</script>
<!-- //banner bottom video script -->

<!-- Stats-Number-Scroller-Animation-JavaScript -->
				<script src="js/waypoints.min.js"></script> 
				<script src="js/counterup.min.js"></script> 
				<script>
					jQuery(document).ready(function( $ ) {
						$('.counter').counterUp({
							delay: 100,
							time: 1000
						});
					});
				</script>
<!-- //Stats-Number-Scroller-Animation-JavaScript -->


<!-- FlexSlider-JavaScript -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(function(){
			SyntaxHighlighter.all();
				});
				$(window).load(function(){
				$('.flexslider').flexslider({
					animation: "slide",
					start: function(slider){
						$('body').removeClass('loading');
					}
			});
		});
	</script>
<!-- //FlexSlider-JavaScript -->

<!-- //js-scripts -->
</body>
</html>