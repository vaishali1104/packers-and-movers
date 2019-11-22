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
<%@page import="java.util.ArrayList"%>
<%@page import="com.KS.bean.HaulageBean"%>
<%@page import="com.KS.bean.QuotationBean"%>
<%@page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Her@feri</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Transporters web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
<script type="application/x-javascript"> 
	addEventListener("load", function()
		{ 
		setTimeout(hideURLbar, 0);
		}, false);
function hideURLbar()
	{ 
		window.scrollTo(0,1);
	}
	
</script>
<!--// Meta tag Keywords -->

<link rel="stylesheet" href="css/lightbox.css"> <!-- portfolio-CSS -->

<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!--table--->

  
<!--table--->
  <!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>
<% 	
	ArrayList<HaulageBean> list2 = (ArrayList<HaulageBean>) request.getAttribute("QuotationRequestList");
	ArrayList<QuotationBean> listQuot = (ArrayList<QuotationBean>) request.getAttribute("PendingQuotList");
	ArrayList<QuotationBean> list = (ArrayList<QuotationBean>) request.getAttribute("ApprovedQuotList");
	ArrayList<QuotationBean> deliverList = (ArrayList<QuotationBean>) request.getAttribute("DeliveredQuotList");
	
	HaulageBean haulageBean=null;
	QuotationBean quotBean=null;
%>
	
	
<%

UserBean userBean1=(UserBean) session.getAttribute("UserBean");

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
							<li><a href="ShowVenProfileServlet?userId=<%=userBean1.getUserId()%>" class="hvr-underline-from-center">My Profile</a></li>
							<li><a href="LogoutServlet" class="hvr-underline-from-center">Logout</a></li>
							
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
			<li>Vendor</li>
		</ul>
	</div>
</div>
<!-- portfolio-inner-page -->
	<div id="portfolio" class="portfolio">
		<div class="heading">
			<h3>Shipment</h3>
		</div>
		<div class="container">
			<div class="sap_tabs">			
				<div id="horizontalTab">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item"><span>Quotation Request</span></li>
						<li class="resp-tab-item"><span>Sent Quotation</span></li>
						<li class="resp-tab-item"><span>Approved</span></li>
						<li class="resp-tab-item"><span>Delivered</span></li>
						
					</ul>	
					<div class="clearfix"> </div>	
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
								<!--<a href="images/g1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">-->
								<!--<img src="images/g1.jpg" class="img-responsive zoom-img" alt=""/>-->
        
							  <table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Customer Name</th>
									<th>Details</th>
									<th>Quotation</th>
									
								</tr>
								</thead>
								<tbody>
								<%int cnt=1;
								for (int i = 0; i < list2.size(); i++)
								{
									haulageBean=list2.get(i);
								%>
								<tr>
									<td><%=cnt%></td>
									<td><%=haulageBean.getUserName()%></td>
									<td><a href="ShowUserDetailsServlet?haul_id=<%=haulageBean.getHaulId()%>"><input type="submit" value="View User Details"></a></td>
									<td><a href="PlaceQuotation.jsp?haul_id=<%=haulageBean.getHaulId()%>"><input type="submit" value="Place Quotation"></a></td>
								</tr>
								 <%cnt++;} %>
								</tbody>
							  </table>
								
							</div>
						
							<div class="clearfix"> </div>
						</div>		
						<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                            
							<table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Customer Name</th>
									<th>Haulage Details</th>
									<th>Your Quotation</th>
									<th>Status</th>
								</tr>
								</thead>
								<tbody>
								<%int cnt1=1;
								for (int i = 0; i < listQuot.size(); i++)
								{
									
									//haulageBean=list2.get(i);
									quotBean=listQuot.get(i);
								%>
								<tr>
									<td><%=cnt1%></td>
									<td><%=quotBean.getUserName()%></td>
									<td><a href="ShowUserDetailsServlet?haul_id=<%=quotBean.getHaulId()%>"><input type="submit" value="View User Details"></a></td>
									<td><%=quotBean.getQuotPrice()%></td>
									<td><%=quotBean.getIsApproved()%></td>
								 </tr>
								  <% cnt1++;} %>
								 
								</tbody>
							  </table>
								<!--<a href="images/ship1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/ship1.jpg" class="img-responsive zoom-img" alt=""/>-
            
-->									<!--<div class="b-wrapper">
										<h5>Ship Transport</h5>
									</div>
								</a>-->
							</div>
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid2">
								<a href="images/ship2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="images/ship2.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Ship Transport</h5>
				</div>
								</a>
							</div>-->
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid3">
								<a href="images/ship3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/ship3.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Ship Transport</h5>
									</div>
								</a>
							</div>-->
								<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/ship4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/ship4.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Ship Transport</h5>
									</div>
								</a>
							</div>-->
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid5">
								<a href="images/ship5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/ship5.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Ship Transport</h5>
									</div>
								</a>
							</div>
-->                            
              
                            
						<div class="clearfix"> </div>
						</div>
						<div class="tab-1 resp-tab-content">

							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                            
								<table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Customer Name</th>
									<th>Haulage Detials</th>
									<th>Delivery Date</th>
									<th>Quotation</th>
									<th>Payment Status</th>
									
								</tr>
								</thead>
								<tbody>
								<%int cnt2=1;
								for (int i = 0; i < list.size(); i++)
								{
									
									//haulageBean=list2.get(i);
									quotBean=list.get(i);
								%>
								<tr>
									<td><%=cnt2%></td>
									<td><%=quotBean.getUserName()%></td>
									<td><a href="ShowUserDetailsServlet?haul_id=<%=quotBean.getHaulId()%>"><input type="submit" value="View User Details"></a></td>
									<td><%=quotBean.getDeliveryDate() %></td>
									<td><%=quotBean.getQuotPrice() %></td>
									<td>Received Successfully</td>
									<td><a href="UpdateDelStatusServlet?delStatus=delivered&haulId=<%=quotBean.getHaulId()%>"><button>delivered</button></a></td>
								 	<td>
								 </tr>
								 <%cnt2++;} %>
								</tbody>
							  </table>
								<!--<a href="images/train1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="images/train1.jpg" class="img-responsive zoom-img" alt=""/>

								<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>-->
							</div>
							<!--<div class="col-md-4 col-sm-4 portfolio-grids  portfolio-grid2">
								<a href="images/train2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/train2.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids  portfolio-grid3">
								<a href="images/truck3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/truck3.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>
							</div>-->
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid1">
								<a href="images/truck4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/truck4.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>
							</div>
							
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid2">
								<a href="images/truck5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/truck5.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>
							</div>-->
							<div class="clearfix"> </div>
						</div>
						<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                           
								<table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Customer Name</th>
									<th>Haulage Detials</th>
									<th>Shipment Date</th>
									<th>Quotation</th>
									<th>Shipment Status</th>
									<th>Mark</th>
								</tr>
								</thead>
								<tbody>
								<%int cnt3=1;
								for (int i = 0; i < deliverList.size(); i++)
								{
									quotBean=deliverList.get(i);
								%>
								<tr>
									<td><%=cnt3%></td>
									<td><%=quotBean.getUserName()%></td>
									<td><a href="ShowUserDetailsServlet?haul_id=<%=quotBean.getHaulId()%>"><input type="submit" value="View User Details"></a></td>
									<td><%=quotBean.getDeliveryDate() %></td>
									<td><%=quotBean.getQuotPrice() %></td>
									<td>Delivered Successfully</td>
									<td><a href="UpdateDelStatusServlet?delStatus=Notdelivered&haulId=<%=quotBean.getHaulId()%>"><button>Not delivered</button></a></td>
								 <%} %>
								 </tr>
								</tbody>
							  </table>
								<!--<a href="images/flight1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight1.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>-->
							</div>
							<!--
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid2">
								<a href="images/flight2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight2.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids  portfolio-grid3">
								<a href="images/flight3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight3.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/flight4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight4.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/flight5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight5.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>--><!--
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/flight6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight6.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>-->
							<div class="clearfix"> </div>
						</div>
					</div>						
				</div>
			</div>
		</div>
	</div>
	<!-- //portfolio-inner-page -->


<!-- footer -->
	<footer>
		<div class="agileits-w3layouts-footer">
			<div class="container">
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
<!-- //js-scripts -->

	<!--script for portfolio-->
			<script src="js/lightbox-plus-jquery.min.js"> </script>
			<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
			<script type="text/javascript">
				$(document).ready(function () {
					$('#horizontalTab').easyResponsiveTabs({
						type: 'default', //Types: default, vertical, accordion           
						width: 'auto', //auto or any width like 600px
						fit: true   // 100% fit in a container
					});
				});		
			</script>
	<!--//script for portfolio-->
			

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