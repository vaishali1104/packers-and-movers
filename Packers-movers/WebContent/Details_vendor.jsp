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
<%@page import="java.util.*" %>
<%@page import="com.KS.bean.*"%>



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

<link rel="stylesheet" href="css/lightbox.css">
<!-- portfolio-CSS -->

<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!--table--->

<%
	UserBean userBean = (UserBean) session.getAttribute("UserBean");%>


<!--table--->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>

	<%
	UserBean userbean = (UserBean) request.getAttribute("UserBean");
	HaulageBean haulagebean = (HaulageBean) request.getAttribute("HaulageBean");
	ArrayList<H_VehicleBean> vehiclelist = (ArrayList<H_VehicleBean>) request.getAttribute("VehicleList");
	
	ArrayList<H_HouseholdBean> houselist= (ArrayList<H_HouseholdBean>) request.getAttribute("HouseList");
	
	ArrayList<H_Office_removalsBean> officelist = (ArrayList<H_Office_removalsBean>) request.getAttribute("OfficeList");
	%>
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
					<li><a href="ShowRequestServlet" class="hvr-underline-from-center">My Shipments</a></li>
					<li><a href="ShowVenProfileServlet?userId=<%=userBean.getUserId()%>" class="hvr-underline-from-center">My Profile</a></li>
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
				<li>Vendor</li>
			</ul>
		</div>
	</div>
	<!-- portfolio-inner-page -->
	<div id="portfolio" class="portfolio">
		<div class="heading">
			<h3>Haulage Shipment</h3>
		</div>
		<div class="container">
			<div class="sap_tabs">
				<div id="horizontalTab">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item"><span>Customer Detials</span></li>
						<!--<li class="resp-tab-item"><span>Vendors Quotation</span></li>
						<li class="resp-tab-item"><span>Approved</span></li>
						<li class="resp-tab-item"><span>Deliverd</span></li>
						-->
					</ul>
					<div class="clearfix"></div>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
								<!--<a href="images/g1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">-->
								<!--<img src="images/g1.jpg" class="img-responsive zoom-img" alt=""/>-->

								<table class="table">
									<thead>
										<tr>
											<th>Sr.no</th>
											<th>Customer Information/Haulage</th>
											<th colspan="2">Details</th>
										</tr>
									</thead>
									<tbody>
									<%int cnt=1; %>
										<tr>
											<td><%=cnt %></td>
											<td>Customer Name</td>
											<td><%=userbean.getUserName() %></td>
										<%cnt++; %>
										</tr>
										<tr>
											<td><%=cnt %></td>
											<td>Customer Email Id</td>
											<td><%=userbean.getUserEmail() %></td>
										<%cnt++; %>
										</tr>
										<tr>
											<td><%=cnt %></td>
											<td>Customer Phone_No</td>
											<td><%=userbean.getPhoneNo() %></td>
										<%cnt++; %>
										</tr>
										
										<%
										H_VehicleBean vehiclebean=new H_VehicleBean();
										for(int i=0;i<vehiclelist.size();i++)
										{
											vehiclebean=vehiclelist.get(i);
										%>
										<tr>
											<td><%=cnt %></td>
											<td>Vehicle</td>
											<td><%=vehiclebean.getVehicleCategory() %></td>
											<td><%=vehiclebean.getVehicleType() %></td>
										<%cnt++; %>
										</tr>
										<%} %>
										
										<% 
										H_Office_removalsBean officebean=new H_Office_removalsBean();
										for(int i=0;i<officelist.size();i++)
										{
											officebean=officelist.get(i);
										%>
										<tr>
										<tr>
											<td><%=cnt%></td>
											<td>Office Removals</td>
											<td><%=officebean.getOfficeType() %></td>
											<td><%=officebean.getDescription() %></td>
										<%cnt++; %>
				ltf						</tr>
										<%} %>
										<%-- <% 
										H_AnimalBean animalbean=new H_AnimalBean();
										for(int i=0;i<animallist.size();i++)
										{
											animalbean=animallist.get(i);
										%>
										
										<tr>
											<td><%=cnt %></td>
											<td>Pets</td>
											<td><%=animalbean.getAnimalType() %></td>
										<%cnt++; %>
										</tr>
										<%} %> --%>
										<% 
										H_HouseholdBean housebean=new H_HouseholdBean();
										for(int i=0;i<houselist.size();i++)
										{
											housebean=houselist.get(i);
										%>
										<tr>
											<td><%=cnt %></td>
											<td>Household</td>
											<td><%=housebean.getHouseType() %></td>
										<%cnt++; %>
										</tr>
										<%} %>
										<tr>
											<td><%=cnt %></td>
											<td>Date of Shipment</td>
											<td><%=haulagebean.getBookingDate() %></td>
											<%cnt++; %>
										</tr>
										
<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String serviceType="";
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			String selectQ = "select * from service where service_id="+haulagebean.getServiceId();
			rs = stmt.executeQuery(selectQ);
			if(rs.next())
				serviceType=rs.getString("service_type");

		} catch (Exception e) {
			System.out.println("Error Details_vendor.jsp::in select service");
			e.printStackTrace();
		}
	%>										

										<tr>
											<td><%=cnt %></td>
											<td>Service Taken</td>
											<td><%=serviceType %></td>
											<%cnt++; %>
										</tr>
										<tr>
											<td><%=cnt %></td>
											<td>Pick Up Location</td>
											<td><%=haulagebean.getPickupLoc() %></td>
											<%cnt++; %>
										</tr>
										<tr>
											<td><%=cnt %></td>
											<td>Delivery Location</td>
											<td><%=haulagebean.getDeliveryLoc() %></td>
										</tr>

									</tbody>
								</table>
								<!--<div class="b-wrapper">
										<h2>Transport Area</h2>
									</div>
								</a>-->
							</div>
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid2">
								<a href="images/g4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g4.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid3">
								<a href="images/g3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g3.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/g7.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g7.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid5">
								<a href="images/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g5.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>-->
							<!--<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid6">
								<a href="images/g6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g6.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid6">
								<a href="images/g1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g1.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid6">
								<a href="images/g3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g3.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid6">
								<a href="images/g2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/g2.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Transport Area</h5>
									</div>
								</a>
							</div>-->
							<div class="clearfix"></div>
						</div>
						<!--<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                            
							<table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Vendor</th>
									<th>Quotation</th>
									<th>Payment<th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>1</td>
									<td>Agrawal Packers And Movers</td>
									<td>Rs 5000</td>
									<td><input type="submit" value="Book"></td>
								 </tr>
								
							  
							 
								</tbody>
							  </table>
								<!--<a href="images/ship1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/ship1.jpg" class="img-responsive zoom-img" alt=""/>-
            
-->
						<!--<div class="b-wrapper">
										<h5>Ship Transport</h5>
									</div>
								</a>-->
						<!--</div>-->
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


						<!--<div class="clearfix"> </div>
						</div>
						<div class="tab-1 resp-tab-content">

							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                            
								<table class="table" >
								<thead>
								<tr>
									<th>Sr.no</th>
									<th>Vendor</th>
									<th>Quotation</th>
									<th>Payment Status<th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>1</td>
									<td>Agrawal Packers And Movers</td>
									<td>Rs 5000</td>
									<td>Successfully Done</td>
								 </tr>
								</tbody>
							  </table>
								<!--<a href="images/train1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="images/train1.jpg" class="img-responsive zoom-img" alt=""/>

								<div class="b-wrapper">
										<h5>Truck Transport</h5>
									</div>
								</a>-->
						<!--</div>-->
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
						<!--<div class="clearfix"> </div>
						</div>
						<div class="tab-1 resp-tab-content">
							<div class="col-lg-12 portfolio-grids portfolio-grid1">
                            <p>CLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick HereCLick Here</p>
								<!--<a href="images/flight1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight1.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>-->
						<!--</div>
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
							</div>-->
						<!--
							<div class="col-md-4 col-sm-4 portfolio-grids portfolio-grid4">
								<a href="images/flight6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
									<img src="images/flight6.jpg" class="img-responsive zoom-img" alt=""/>
									<div class="b-wrapper">
										<h5>Flight Transport</h5>
									</div>
								</a>
							</div>-->
						<!--<div class="clearfix"> </div>-->
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
					<p>
						We have been established since 2009<br>The vendors are fully
						secure and no malpractice.<br>Till now all Customer are
						satisfied from our work<br>The works are very well trained.
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
									Email :<a href="mailto:example@email.com">herafari@gmail.com</a>
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
									Navarangpura,Ahmedabad, Gujarat,India. <br>Telephone :
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
								<a href="#"><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6>
									<a href="#" data-toggle="modal" data-target="#myModal">Vehicle
										transfer in Ahmedabad</a>
								</h6>
								<p>June 10,2017</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p2.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6>
									<a href="#" data-toggle="modal" data-target="#myModal">Household
										item tranfser in Ahmedabad</a>
								</h6>
								<p>June 17,2017</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p3.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6>
									<a href="#" data-toggle="modal" data-target="#myModal">Office
										Removals tranfser in Ahmedabad</a>
								</h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3ls-post-grid">
							<div class="w3ls-post-img">
								<a href="#"><img src="images/p1.jpg" alt="" /></a>
							</div>
							<div class="w3ls-post-info">
								<h6>
									<a href="#" data-toggle="modal" data-target="#myModal">Pets
										transfer in Ahmedabad</a>
								</h6>
								<p>June 26,2017</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
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

	<!--script for portfolio-->
	<script src="js/lightbox-plus-jquery.min.js">
		
	</script>
	<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#horizontalTab').easyResponsiveTabs({
				type : 'default', //Types: default, vertical, accordion           
				width : 'auto', //auto or any width like 600px
				fit : true
			// 100% fit in a container
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