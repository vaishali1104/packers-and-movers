<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>Her@feri</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fascinating Checkout Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="cssp/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="cssp/creditly.css" type="text/css" media="all" />
<link rel="stylesheet" href="cssp/easy-responsive-tabs.css">
<script src="jspp/jquery.min.js"></script>
<link href="//fontsp.googleapis.com/css?family=Overpass:100,100i,200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
</head>
<body>


	<%
	String amount = request.getParameter("amount");
	String venId = request.getParameter("ven_id");
	String haulId = request.getParameter("haul_id");
	String quotId = request.getParameter("Quot_id");
	String deliveryDate = request.getParameter("deliveryDate");
	
	String paymentError=(String)request.getAttribute("PaymentError");
	
	%>



	<div class="main">	
		<h1>Checkout</h1>
		<div class="w3_agile_main_grids">
			<div class="agile_main_top_grid">
				<div class="agileits_w3layouts_main_top_grid_left">
					<a href="CustFinalServlet"><img src="images/1.png" alt=" " /></a>
				</div>
				<div class="w3_agileits_main_top_grid_right">
					<h3>*Do not press back or refresh button</h3>
				</div>
				<div class="clear"> </div>
				<div class="wthree_total">
					<h2>total to pay <span><%=amount%><i>Rs</i></span></h2>
				</div>
			</div>
					
			<div class="agileinfo_main_bottom_grid">
				<div id="horizontalTab">
					<ul class="resp-tabs-list">
						<li><img src="images/1.jpg" alt=" " /></li>
						
					</ul>
					<div class="resp-tabs-container">
						<div class="agileits_w3layouts_tab1">
							<form action="ChargeCreditCardServlet" method="post" class="creditly-card-form agileinfo_form">
								<section class="creditly-wrapper wthree, w3_agileits_wrapper">
									<div class="credit-card-wrapper">
										<div class="first-row form-group">
											<input	type="hidden" name="amount" value="<%=amount%>">
											<input	type="hidden" name="venId" value="<%=venId%>">
											<input	type="hidden" name="haulId" value="<%=haulId%>">
											<input	type="hidden" name="quotId" value="<%=quotId%>">
											<input	type="hidden" name="deliveryDate" value="<%=deliveryDate%>">

											<div class="controls">
												<label class="control-label">Card Holder Name</label>
												<input class="billing-address-name form-control" type="text" name="cardName" required value="${CardNameValue}">${CardNameError} 
											</div>
											<div class="w3_agileits_card_number_grids">
												<div class="w3_agileits_card_number_grid_left">
													<div class="controls">
														<label class="control-label">Card Number</label>
														<input class="number credit-card-number form-control" type="text" name="creditCard"
																	  inputmode="numeric" autocomplete="cc-number" autocompletetype="cc-number" x-autocompletetype="cc-number"
																	  placeholder="&#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149;" required>
													</div>
												</div>
												<div class="w3_agileits_card_number_grid_right">
													<div class="controls">
														<label class="control-label">CVV</label>
														<input class="security-code form-control"·inputmode="numeric"  type="text" name="cvv"
																	  placeholder="&#149;&#149;&#149;" required>${CvvError} 
													</div>
												</div>
												<div class="clear"> </div>
											</div>
											<div class="controls">
												<label class="control-label">Expiration Date</label>
												<input class="expiration-month-and-year form-control" type="text" name="expDate" placeholder="MM / YY">
											</div>
										</div>
										<button class="submit"><span>Make payment</span></button>
										<br><br><%=paymentError == null ? "" : paymentError%>
									</div>
								</section>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<!-- credit-card -->
		<script type="text/javascript" src="jsp/creditly.js"></script>
		<script type="text/javascript">
			$(function() {
			  var creditly = Creditly.initialize(
				  '.creditly-wrapper .expiration-month-and-year',
				  '.creditly-wrapper .credit-card-number',
				  '.creditly-wrapper .security-code',
				  '.creditly-wrapper .card-type');

			  $(".creditly-card-form .submit").click(function(e) {
				e.preventDefault();
				var output = creditly.validate();
				if (output) {
				  // Your validated credit card output
				  console.log(output);
				}
			  });
			});
		</script>
	<!-- //credit-card -->
	<!-- tabs -->
	<script src="jspp/easy-responsive-tabs.js"></script>
	<script>
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default', //Types: default, vertical, accordion           
				width: 'auto', //auto or any width like 600px
				fit: true,   // 100% fit in a container
				closed: 'accordion', // Start closed if in accordion view
				activate: function(event) { // Callback function if tab is switched
				var $tab = $(this);
				var $info = $('#tabInfo');
				var $name = $('span', $info);
				$name.text($tab.text());
				$info.show();
				}
			});
		});
	</script>
	<!-- //tabs -->
</body>
</html>