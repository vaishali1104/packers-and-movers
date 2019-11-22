<!--/
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page import="java.sql.ResultSet"%>
<%@page import="com.KS.util.DbConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.KS.bean.UserBean"%>
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
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 

</script>

     <script type='text/javascript' src='/Project_final/dwr/interface/AjaxDataDao.js'></script>
  	 <script type='text/javascript' src='/Project_final/dwr/engine.js'></script>
     <script type='text/javascript' src='/Project_final/dwr/util.js'></script>


<!--// Meta tag Keywords -->

<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="cssl/fontl-awesome.min.css" />
<!-- login -->
<link href="csss/style.css" rel='stylesheet' type='text/css' media="all">
<!-- login -->


<link href="//fontsl.googleapis.com/css?family=Roboto:300,400,500"
	rel="stylesheet">
<!-- login -->
<!-- //css files -->

<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<!-- //web-fonts -->
</head>
<%
	String vehicle = (String)session.getAttribute("vehicle");
	//String food = (String)session.getAttribute("food");
	String household = (String)session.getAttribute("household");
	String office =(String) session.getAttribute("office");
	//String pets = (String)session.getAttribute("pets");


	UserBean userBean = (UserBean) session.getAttribute("UserBean");
%>

<body>
	
	 <script type="text/javascript">
 
	 var veh = 1;
		function showMoreVehicle() {
			veh++;
			if (veh == 2)
				$("#v2").show();
			else if (veh == 3)
				$("#v3").show();
			else if (veh == 4)
				$("#v4").show();

			
			$("#vehicleCount").val(veh);
		} 
				
		var office = 1;
		function showMoreOffice() {
			office++;
			if (office == 2)
				$("#o2").show();
			else if (office == 3)
				$("#o3").show();
			else if (office == 4)
				$("#o4").show();

			$("#officeCount").val(office);
		}
		
		/* var food = 1;
		function showMoreFood() {
			food++;
			if (food == 2)
				$("#f2").show();
			$("#foodCount").val(food);
		} 
		
		var pet = 1;
		function showMorePet() {
			pet++;
			if (pet == 2)
				$("#p2").show();
			else if (pet == 3)
				$("#p3").show();
			else if (pet == 4)
				$("#p4").show();
			$("#petCount").val(pet);
	
		} 
 */				

		function getReply(vehicle_category)
		{
			       // stateId='';
					//alert(stateId);
					dwr.util.removeAllOptions("v_type_1");
					
					document.getElementById('v_type_1Loader').style.visibility = 'visible';
					
					if(vehicle_category== '')
					{
						alert("...blank...");
						var data=[{ vehicle_type:'-- Select --', vehicle_type:'' }];
						dwr.util.addOptions("v_type_1",data,"vehicle_type");
						document.getElementById('v_type_1Loader').style.visibility = 'hidden';
					}
					else
					{
						//alert("sp1");
					    document.getElementById('v_type_1Loader').style.visibility = 'visible';
						AjaxDataDao.getAllType(vehicle_category,function(data){
						dwr.util.addOptions("v_type_1",data,"vehicleType","vehicleType");
						});
		 			     document.getElementById('v_type_1Loader').style.visibility = 'hidden';
						
					}
		}
		
//2nd vehicle		
		function getReply2(vehicle_category)
		{
			       // stateId='';
					//alert(stateId);
					dwr.util.removeAllOptions("v_type_2");
					
					document.getElementById('v_type_2Loader').style.visibility = 'visible';
					
					if(vehicle_category== '')
					{
						alert("...blank...");
						var data=[{ vehicle_type:'-- Select --', vehicle_type:'' }];
						dwr.util.addOptions("v_type_2",data,"vehicle_type");
						document.getElementById('v_type_2Loader').style.visibility = 'hidden';
					}
					else
					{
						//alert("sp1");
					    document.getElementById('v_type_2Loader').style.visibility = 'visible';
						AjaxDataDao.getAllType(vehicle_category,function(data){
						dwr.util.addOptions("v_type_2",data,"vehicleType","vehicleType");
						});
		 			     document.getElementById('v_type_2Loader').style.visibility = 'hidden';
						
					}
		}	

//3rd vehicle
		function getReply3(vehicle_category)
		{
			       // stateId='';
					//alert(stateId);
					dwr.util.removeAllOptions("v_type_3");
					
					document.getElementById('v_type_3Loader').style.visibility = 'visible';
					
					if(vehicle_category== '')
					{
						alert("...blank...");
						var data=[{ vehicle_type:'-- Select --', vehicle_type:'' }];
						dwr.util.addOptions("v_type_3",data,"vehicle_type");
						document.getElementById('v_type_3Loader').style.visibility = 'hidden';
					}
					else
					{
						//alert("sp1");
					    document.getElementById('v_type_3Loader').style.visibility = 'visible';
						AjaxDataDao.getAllType(vehicle_category,function(data){
						dwr.util.addOptions("v_type_3",data,"vehicleType","vehicleType");
						});
		 			     document.getElementById('v_type_3Loader').style.visibility = 'hidden';
						
					}
		}	


//4th vehicle		
		
		function getReply4(vehicle_category)
		{
			       // stateId='';
					//alert(stateId);
					dwr.util.removeAllOptions("v_type_4");
					
					document.getElementById('v_type_4Loader').style.visibility = 'visible';
					
					if(vehicle_category== '')
					{
						alert("...blank...");
						var data=[{ vehicle_type:'-- Select --', vehicle_type:'' }];
						dwr.util.addOptions("v_type_4",data,"vehicle_type");
						document.getElementById('v_type_4Loader').style.visibility = 'hidden';
					}
					else
					{
						//alert("sp1");
					    document.getElementById('v_type_4Loader').style.visibility = 'visible';
						AjaxDataDao.getAllType(vehicle_category,function(data){
						dwr.util.addOptions("v_type_4",data,"vehicleType","vehicleType");
						});
		 			     document.getElementById('v_type_4Loader').style.visibility = 'hidden';
						
					}
		}	

		
	</script>

	

	<%
		Connection con = null;
		Statement city2stmt=null,citystmt=null,stmt = null, stmt1 = null, stmt2 = null, stmt3 = null, stmt4 = null, stmt5 = null, stmt6 = null,stmt7 = null;
		Statement stmt2o=null,stmt3o=null,stmt4o=null,stmt2v = null, stmt3v = null, stmt4v = null,stmt2vtype = null, stmt3vtype = null, stmt4vtype = null;
		ResultSet city2rs=null,cityrs=null,rso2=null,rso3=null,rso4=null,rsv2 = null, rsv3 = null,rsv4=null,rsv2type = null, rsv3type = null,rsv4type=null;
		ResultSet rs = null, rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null,rs6 = null, rs7 = null;
		
		try
		{
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			stmt1 = con.createStatement();
			stmt2 = con.createStatement();
			stmt3 = con.createStatement();
			stmt4 = con.createStatement();
			stmt5 = con.createStatement();
			stmt6 = con.createStatement();
			stmt7 = con.createStatement();
			
			citystmt=con.createStatement();
			city2stmt=con.createStatement();
			
			stmt2v = con.createStatement();
			stmt3v = con.createStatement();
			stmt4v = con.createStatement();
			

			stmt2vtype = con.createStatement();
			stmt3vtype = con.createStatement();
			stmt4vtype = con.createStatement();
			
			//stmt2f =con.createStatement();
			
			stmt2o=con.createStatement();
			stmt3o=con.createStatement();
			stmt4o=con.createStatement();
			
			/* stmt2p=con.createStatement();
			stmt3p=con.createStatement();
			stmt4p=con.createStatement();
		 */
			
			String vselectQ = "select distinct(vehicle_category)  from vehicle";
			String vselectQ1 = "select * from vehicle";
			//String vselectQ2="select * from vehicle where vehicle_category='4-wheeler'";
			String hselectQ = "select * from household";
			//String fselectQ = "select * from food";
			String oselectQ = "select * from office_removals";
			//String pselectQ = "select * from animal";
			String selectQ = "select * from service";
			String cityQ="select * from city";
			rs = stmt.executeQuery(vselectQ);
			rs1 = stmt1.executeQuery(hselectQ);
			//rs2 = stmt2.executeQuery(fselectQ);
			rs3 = stmt3.executeQuery(oselectQ);
			//rs4 = stmt4.executeQuery(pselectQ);
			rs5 = stmt5.executeQuery(selectQ);
			rs6 = stmt6.executeQuery(vselectQ1);
	
			cityrs=citystmt.executeQuery(cityQ);
			city2rs=city2stmt.executeQuery(cityQ);
			
			rsv2 = stmt2v.executeQuery(vselectQ);
			rsv3 = stmt3v.executeQuery(vselectQ);
			rsv4 = stmt4v.executeQuery(vselectQ);

			rsv2type = stmt2vtype.executeQuery(vselectQ1);
			rsv3type = stmt3vtype.executeQuery(vselectQ1);
			rsv4type = stmt4vtype.executeQuery(vselectQ1);
			
			//rsf2= stmt2f.executeQuery(fselectQ);

			rso2 = stmt2o.executeQuery(oselectQ);
			rso3 = stmt3o.executeQuery(oselectQ);
			rso4 = stmt4o.executeQuery(oselectQ);

			/* rsp2 = stmt2p.executeQuery(pselectQ);
			rsp3 = stmt3p.executeQuery(pselectQ);
			rsp4 = stmt4p.executeQuery(pselectQ);
 */
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
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
					<li><a href="CustFinalServlet"	class="hvr-underline-from-center">My Shipments</a></li>
					<li><a href="ShowProfileServlet?userId=<%=userBean.getUserId()%>" class="hvr-underline-from-center">My Profile</a></li>
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
	
	<%
		String HaulTitleError=(String)request.getAttribute("HaulTitleError");
		String VCategoryError=(String)request.getAttribute("VCategoryError");
		String VTypeError=(String)request.getAttribute("VTypeError");
		String HTypeError=(String)request.getAttribute("HTypeError");
		//String FoodError=(String)request.getAttribute("FoodError");
		
		String OfficeError=(String)request.getAttribute("OfficeError");
		
		String PTypeError=(String)request.getAttribute("PTypeError");
		String ServiceTypeError=(String)request.getAttribute("ServiceTypeError");
		String DStreetAddressError=(String)request.getAttribute("DStreetAddressError");
		String DCityError=(String)request.getAttribute("DCityError");
		String DCodeError=(String)request.getAttribute("DCodeError");
		
		String ShipmentDateError=(String)request.getAttribute("ShipmentDateError");
		
		String StreetAddressError=(String)request.getAttribute("StreetAddressError");
		String CityError=(String)request.getAttribute("CityError");
		String CodeError=(String)request.getAttribute("CodeError");
	%>
	
	
	
	
	
	<!-- Customer-->
	<div class="w3ls-banner">
		<div class="heading">
			<h1>Customer Details</h1>
		</div>
		<div class="container">
			<form action="Customer3Servlet" method="post">
				<div class="heading">
					<p>Please Select Haulage details ?</p>
				</div>
				<div class="agile-form">
					<ul class="field-list">
						<div class="form-input add">
							<ul class="field-list">
								<li>
								<label class="form-label">Haulage Title<span class="form-required"> * </span></label>
								<div class="form-input">
									<input type="text" name="haulTilte"	placeholder="eg. House Shift" required value="${HaulTitleValue}"><%=HaulTitleError==null?" ":HaulTitleError%>
								</div>
								</li>
								<%
									if (vehicle != null) {
								%>
								
				<!-- add more 1 start -->
								<li>
									<input type="hidden" name="vehicleCount" value="1"	id="vehicleCount" />
									<input type="hidden" name="vehiclePresent" value="true" />
									<button class="button">Vehicle</button><%=VCategoryError==null?" ":VCategoryError%><br><%=VTypeError==null?" ":VTypeError%>
									<li>
										<label class="form-label">Category<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_category_1" onChange="java:getReply(this.value)">
												<option value="-1">Please select Category</option>
													<%
														String vc, id;
															while (rs.next()) {
																//id = rs.getString("vehicle_id");
																vc = rs.getString("vehicle_category");
													%>
												<option value="<%=vc%>"><%=vc%></option>
													<%
														}
													%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_type_1" id="v_type_1" required>
												<option value="-1">Please select Type</option>
										 	 		<%	String vt, i;
										 				while (rs6.next()) {
															i = rs6.getString("vehicle_id");
															vt = rs6.getString("vehicle_type");
													%>
												<option value="<%=vt%>"><%=vt%></option>
													<%
														}
													%>
											
											</select>
											<span id="v_type_1Loader" style="visibility:hidden">
		    									<img src="images/ajax-loader.gif">		
	   										</span>
										</div>
									</li>
				<!-- add more 1 end -->


								<!-- add more 2 start -->
								<div id="v2" style="display: none">
									<li><label class="form-label">Category<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_category_2" onChange="java:getReply2(this.value)">
												<option value="-1">Please select Category</option>
												<%
													while (rsv2.next()) {
															//id = rs.getString("vehicle_id");
															vc = rsv2.getString("vehicle_category");
												%>

												<option value="<%=vc%>"><%=vc%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li><label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_type_2" id="v_type_2">
												<option value="-1">Please select Type</option>
												<%//change
													//String vt="";
													while (rsv2type.next()) {
															vt = rsv2type.getString("vehicle_type");
												%>

												<option value="<%=vt%>"><%=vt%></option>
												<%
													}
												%>
											</select>
											<span id="v_type_2Loader" style="visibility:hidden">
		    									<img src="images/ajax-loader.gif">		
	   										</span>
										</div>
									</li>
								</div>
								<!-- add more 2 end-->

								<!-- add more 3 start -->
								<div id="v3" style="display: none">
									<li><label class="form-label">Category<span
											class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_category_3" onChange="java:getReply3(this.value)" >
												<option value="-1">Please select Category</option>
												<%
													while (rsv3.next()) {
														vc = rsv3.getString("vehicle_category");
												%>

												<option value="<%=vc%>"><%=vc%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Type<span
											class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_type_3" id="v_type_3">
												<option value="-1">Please select Type</option>
												<%
												//change
													while (rsv3type.next()) {
															vt = rsv3type.getString("vehicle_type");
												%>

												<option value="<%=vt%>"><%=vt%></option>
												<%
													}
												%>
											</select>
											<span id="v_type_3Loader" style="visibility:hidden">
		    									<img src="images/ajax-loader.gif">		
	   										</span>
										</div>
									</li>
								</div>
								<!-- add more 3 end -->
	
								<!-- add more 4 start -->
								<div id="v4" style="display: none">
									<li><label class="form-label">Category<span
											class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_category_4" onChange="java:getReply4(this.value)">
												<option value="-1">Please select Category</option>
												<%
													while (rsv4.next()) {
															vc = rsv4.getString("vehicle_category");
												%>

												<option value="<%=vc%>"><%=vc%></option>
												<%
													}
												%>
											</select>
										</div></li>
									<li><label class="form-label">Type<span
											class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="v_type_4" id="v_type_4">
												<option value="-1">Please select Type</option>
												<%//change
													while (rsv4type.next()) {
															vt = rsv4type.getString("vehicle_type");
												%>

												<option value="<%=vt%>"><%=vt%></option>
												<%
													}
												%>
											</select>
											<span id="v_type_4Loader" style="visibility:hidden">
		    									<img src="images/ajax-loader.gif">		
	   										</span>
										</div></li>
								</div>
								<!-- add more 4 end-->
		
								<button class="button2" onclick="showMoreVehicle()">Add	More</button>
								<br>
							</li>
								<%
									}
								%>



								<%
								if (household != null) {
								%>
								<li>
									<input type="hidden" name="householdPresent" value="true" />
									<button class="button">Household</button><%=HTypeError==null?" ":HTypeError%>
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="h_type" required>
												<option value="-1">Please select Category</option>
												<%
													String id1, ht;
														while (rs1.next()) {
															id1 = rs1.getString("house_id");
															ht = rs1.getString("house_type");
												%>
	
												<option value="<%=ht%>"><%=ht%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
								</li>
								<%
									}
								%>



								<%
								//if (food != null) {
								%>
								<%-- <li>
									<input type="hidden" name="foodCount" value="1" id="foodCount" />
									<input type="hidden" name="foodPresent" value="true" />
									<button class="button">Food</button><%=FoodError==null?" ":FoodError%>
									<li>
										<label class="form-label">Select Food Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="f_type_1" required>
												<option value="-1">Please select Category</option>
												<%
													String ft, id2;
														while (rs2.next()) {
															id2 = rs2.getString("food_id");
															ft = rs2.getString("food_type");
												%>
	
												<option value="<%=ft%>"><%=ft%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Approx Weight<span class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="approxWeight_1"	placeholder="Approx weight in Kg" required value="${ApproxWeightValue1}">
										</div>
									</li>
					<!-- add more 1 end -->

					<!-- add more 2 start -->								
								<div id="f2" style="display: none">
									<li>
										<label class="form-label">Select Food Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="f_type_2" >
												<option value="-1">Please select Category</option>
												<%
														while (rsf2.next()) {
															ft = rsf2.getString("food_type");
												%>
	
												<option value="<%=ft%>"><%=ft%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Approx Weight<span class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="approxWeight_2"	placeholder="Approx weight in Kg" value="${ApproxWeightValue2}">
										</div>
									</li>
								</div>
					<!--add more 2 end -->								
				
									<button class="button2" onclick="showMoreFood()">Add More</button>
								</li> --%>
								<%
								//}
								%>

								<%
								if (office != null) {
								%>
					<!-- add more 1 start -->
								<li>
									<br>
									<input type="hidden" name="officeCount" value="1" id="officeCount" />
									<input type="hidden" name="officePresent"	value="true" />
									<button class="button">Office Removals</button><%=OfficeError==null?" ":OfficeError%>
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="o_type_1" required>
												<option value="-1">Please select Type</option>
												<%
													String ot, id3;
														while (rs3.next()) {
															id3 = rs3.getString("office_id");
															ot = rs3.getString("office_type");
												%>
	
												<option value="<%=ot%>"><%=ot%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Description<span	class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="description_1" placeholder="eg. Computer table of 120*200" value="${DescriptionValue1}" required>
										</div>
									</li>
						<!-- add more 1 end -->
								
							
						<!-- add more 2 start -->
								<div id="o2" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="o_type_2">
												<option value="-1">Please select Type</option>
												<%
										
														while (rso2.next()) {
															id3 = rso2.getString("office_id");
															ot = rso2.getString("office_type");
												%>
	
												<option value="<%=ot%>"><%=ot%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Description<span	class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="description_2" placeholder="eg. Computer table of 120*200" value="${DescriptionValue2}">
										</div>
									</li>									
								</div>	
						<!-- add more 2 end -->								
		
		
						<!-- add more 3 start -->
								<div id="o3" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="o_type_3">
												<option value="-1">Please select Type</option>
												<%
										//			String ot, id3;
														while (rso3.next()) {
															id3 = rso3.getString("office_id");
															ot = rso3.getString("office_type");
												%>
	
												<option value="<%=ot%>"><%=ot%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Description<span	class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="description_3" placeholder="eg. Computer table of 120*200" value="${DescriptionValue3}">
										</div>
									</li>									
								</div>
						<!-- add more 3 end -->								
		
		
						<!-- add more 4 start -->
								<div id="o4" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="o_type_4">
												<option value="-1">Please select Type</option>
												<%
										//			String ot, id3;
														while (rso4.next()) {
															id3 = rso4.getString("office_id");
															ot = rso4.getString("office_type");
												%>
												<option value="<%=ot%>"><%=ot%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
									<li>
										<label class="form-label">Description<span	class="form-required"> * </span></label>
										<div class="form-input">
											<input type="text" name="description_4" placeholder="eg. Computer table of 120*200" value="${DescriptionValue4}">
										</div>
									</li>									
								</div>	
						<!-- add more 4 end -->								
																		
									<button class="button2" onclick="showMoreOffice()">Add More</button>
								
								<%
									}
								%>
								
								<% 
								//if (pets != null) {
								%>
								<%-- <li>
									<br>
									<input type="hidden" name="petCount" value="1" id="petCount" />
									
									<input type="hidden" name="petsPresent" value="true" />
									<button class="button">Pets</button><%=PTypeError==null?" ":PTypeError%>
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="p_type_1" required>
												<option value="-1">Please select</option>
												<%
													String pt, id4;
														while (rs4.next()) {
															id4 = rs4.getString("animal_id");
															pt = rs4.getString("animal_type");
												%>
	
												<option value="<%=pt%>"><%=pt%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
						<!-- add more 1 end -->
									
									
						<!-- add more 2 start -->			
								<div id="p2" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="p_type_2">
												<option value="-1">Please select</option>
												<%
													//String pt, id4;
														while (rsp2.next()) {
															id4 = rsp2.getString("animal_id");
															pt = rsp2.getString("animal_type");
												%>
	
												<option value="<%=pt%>"><%=pt%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
								</div>		
							<!-- add more 2 end -->			
									

							<!-- add more 3 start -->			
								<div id="p3" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="p_type_3" >
												<option value="-1">Please select</option>
												<%
													//String pt, id4;
														while (rsp3.next()) {
															id4 = rsp3.getString("animal_id");
															pt = rsp3.getString("animal_type");
												%>
	
												<option value="<%=pt%>"><%=pt%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
								</div>		
							<!-- add more 3 end -->			
							
							<!-- add more 4 start -->			
								<div id="p4" style="display: none">	
									<li>
										<label class="form-label">Type<span	class="form-required"> * </span></label>
										<div class="form-input">
											<select class="form-dropdown" name="p_type_4" >
												<option value="-1">Please select</option>
												<%
													//String pt, id4;
														while (rsp4.next()) {
															id4 = rsp4.getString("animal_id");
															pt = rsp4.getString("animal_type");
												%>
	
												<option value="<%=pt%>"><%=pt%></option>
												<%
													}
												%>
											</select>
										</div>
									</li>
								</div>		
							<!-- add more 4 end -->
								<button class="button2" onclick="showMorePet()">Add More</button>
							
 --%>								<%
 									//}
								%>
								<li>
									<label class="form-label"> Select Pickup Date? <span class="form-required"> * </span>
									</label>
									<div class="form-input">
										<br> <input type="date" name="shipmentDate"	placeholder="Date" min="2018-05-04" max="2018-08-04" required value="${ShipmentDateValue}"><%=ShipmentDateError==null?" ":ShipmentDateError%>
									</div>
								</li>
								<li><label class="form-label"> Service Type<span
										class="form-required"> * </span></label>
									<div class="form-input">
										<select class="form-dropdown" name="serviceType" required>
											<option value="-1">Please select Category</option>
											<%
												String t, j;
												while (rs5.next()) {
													j = rs5.getString("service_id");
													t = rs5.getString("service_type");
											%>

											<option value="<%=j%>"><%=t%></option>
											<%
												}
											%>

										</select><%=ServiceTypeError==null?" ":ServiceTypeError%>
									</div>
								</li>
								<li> 
									<label class="form-label">
									  pickup Address
									<span class="form-required"> * </span>
									</label>
									<div class="form-input">
										<input type="text" name="streetAddress"	placeholder="Street Address" required value="${StreetAddressValue}"><%=StreetAddressError==null?" ":StreetAddressError%>
										<span class="form-sub-label">
											<br><br>
											<select  name="city" required>
												<option value="-1">Please select city</option>
												<%
													String cityid,cityname;
													while (cityrs.next()) {
														cityid = cityrs.getString("city_id");
														cityname = cityrs.getString("city_name");
												%>
												<option value="<%=cityname%>"><%=cityname%></option>
												<%
													}
												%>
											</select><%=CityError==null?" ":CityError%>
										</span>
										<br><br>
										<span class="form-sub-label last">
											<input type="text" name="state"  value="Gujarat" disabled>
										</span>
										<span class="form-sub-label last">
											<input type="text" name="code" placeholder="Postal / Zip Code " required value="${CodeValue}">
										</span>
										<%=CodeError==null?" ":CodeError%>
									</div>
								</li>
								<li> 
									<label class="form-label">
									  Delivery Address
										<span class="form-required"> * </span>
									</label>
									<div class="form-input">
										<input type="text" name="dStreetAddress" placeholder="Street Address" required value="${DStreetAddressValue}"><%=DStreetAddressError==null?" ":DStreetAddressError%>
										<span class="form-sub-label">
											<br><br>
											<select  name="dCity" required>
												<option value="-1">Please select city</option>
												<%
													//String city2id,city2name;
													while (city2rs.next()) {
														cityid = city2rs.getString("city_id");
														cityname = city2rs.getString("city_name");
												%>
												<option value="<%=cityname%>"><%=cityname%></option>
												<%
													}
												%>
											</select><%=DCityError==null?" ":DCityError%>
										</span>
										<br><br>
										<span class="form-sub-label last">
											<input type="text" name="dState"  value="Gujarat" disabled>
										</span>
										<span class="form-sub-label last">
											<input type="text" name="dCode" placeholder="Postal / Zip Code " value="${DCodeValue}" required><%=DCodeError==null?" ":DCodeError%>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</ul>
				</div>
				<div class="submit_btn">
					<input type="submit" value="Send Request">
				</div>
				<br>
				<br>
			</form>
		</div>
	</div>
	<!--signup close -->
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
								Navrangpura, Ahmedabad, Gujarat,India. <br>Telephone :
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