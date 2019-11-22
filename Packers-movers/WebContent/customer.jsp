
<%@ page import="com.KS.bean.UserBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Her@feri</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords"
	content="Transporters web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!--// Meta tag Keywords -->
<%
	UserBean userBean = (UserBean) session.getAttribute("UserBean");
%>
<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="cssl/fontl-awesome.min.css" />
<link href="csss/style.css" rel='stylesheet' type='text/css' media="all">
<link href="//fontsl.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">


</head>
<body>
	<div class="header">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h1>
					<a href="UserHome.jsp">Her@feri</a>
				</h1>
			</div>

			<!-- navbar-header -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a class="hvr-underline-from-center active"
						href="UserHome.jsp">Home</a></li>
					<li><a href="services.jsp" class="hvr-underline-from-center">Services</a></li>

					<li><a href="gallery.jsp" class="hvr-underline-from-center">Gallery</a></li>


					<li><a href="contact.jsp" class="hvr-underline-from-center">Contact</a>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="CustFinalServlet"
						class="hvr-underline-from-center ">My Shipments</a></li>
					<li><a	href="ShowProfileServlet?userId=<%=userBean.getUserId()%>"
						class="hvr-underline-from-center">My Profile</a></li>
					<li><a href="LogoutServlet" class="hvr-underline-from-center">Logout</a></li>

				</ul>
			</div>

			<div class="clearfix"></div>
		</nav>

	</div>
	 <div class="banner1"></div> 
	<div class="about-breadcrumb">
		<div class="container">
			<ul>
				<li><a href="UserHome.jsp">Home</a><i>></i></li>
				<li>Customer</li>
			</ul>
		</div>
	</div>
	<!-- Customer-->
	<div class="w3ls-banner" style="min-height:80vh;">
		<div class="heading">
			<h1>Customer Details</h1>
		</div>
		<div class="container" style="border:5px double white;">
			<div class="heading">
				<br>
				<br>
				<p>Where do you want to shift??</p>
			</div>
			<div class="agile-form">
			
				<form action="customer1.jsp" method="post">
			
					<div class="field-list">
						<div class="form-input add">
							<center>
								&nbsp;&nbsp;<input type="radio" name="area" value="within" required>&nbsp;&nbsp;&nbsp;&nbsp;Within
								the city<br> 
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="area"
									value="outside" required>&nbsp;&nbsp;&nbsp;&nbsp;Outside the city
							</center>
						</div>
					</div>
					<br>
					<div class="submit_btn">
						<input type="submit" value="Next">
					</div>
					<br><br>
				</form>
			</div>
		</div>
	</div>
		
<!-- Customer-->
		<!-- footer -->
		<footer>
			<div class="agileits-w3layouts-footer">

				<div class="col-md-4 w3-agile-grid">
					<h5>About Us</h5>
					<p>
						We have been established since 2009<br>The vendors are fully
						secure and no malpractice.<br>Till now all Customer are
						satisfied from our work<br>The workers are very well trained.
					</p>
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
							<div class="clearfix"></div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>
									Email :<a href="mailto:example@email.com">heraferi2930@gmail.com</a>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p>
									Navrangpura,Ahmedabad, Gujarat,India. <br>Telephone :
									+91(079)23297201
								</p>
							</div>
							<div class="clearfix"></div>
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
		
			<div class="copyright">
				<div class="container">
					<p>© Her@feri home page</p>
				</div>
			</div>
		</footer>
		<!-- //footer -->



		<!-- js-scripts -->
		<!-- js -->
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<!-- Necessary-JavaScript-File-For-Bootstrap -->
		<!-- //js -->
		<!-- //js-scripts -->

		<!-- start-smoth-scrolling -->
		<script src="js/SmoothScroll.min.js"></script>
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event) {
					event.preventDefault();
					$('html,body').animate({
						scrollTop : $(this.hash).offset().top
					}, 1000);
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

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});
		</script>
		<!-- //here ends scrolling icon -->
		<!-- start-smoth-scrolling -->
</body>
</html>