<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_login.css">
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/background.cycle.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#LandingScreen")
						.backgroundCycle(
								{
									imageUrls : [ 'img/bg1.jpg', 'img/bg4.jpg',
											'img/bg2.jpg', 'img/bg3.jpg',
											'img/bg5.jpg' ],
									fadeSpeed : 2000,
									duration : 5000,
									backgroundSize : SCALING_MODE_STRETCH
								});
			});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#iframeDisp").hide();
		$("#about").hide();
		$("#form").hide();

		$("#customerTab").click(function() {
			$("#iframeDisp").show();
			$("#about").hide();
			$("#form").show();
			$("#intro").hide();
		})
		$("#staffTab").click(function() {
			$("#iframeDisp").show();
			$("#about").hide();
			$("#form").show();
			$("#intro").hide();
		})
		$("#registrationTab").click(function() {
			$("#iframeDisp").show();
			$("#about").hide();
			$("#form").show();
			$("#intro").hide();
		})
		$("#aboutTab").click(function() {
			$("#iframeDisp").hide();
			$("#about").show();
			$("#form").hide();
			$("#intro").hide();
		})
		$("#contactTab").click(function() {
			$("#iframeDisp").show();
			$("#about").hide();
			$("#form").show();
			$("#intro").hide();

		})
	})
</script>

</head>
<body id="LandingScreen" style="margin: 0%">
	<jsp:include page="header.jsp" />
	<div id="display">
		<h1>DIVYAM AIRLINES</h1>
		<br> 	
	</div>
	<div id="intro">
		Welcome aboard Divyam Airlines,<br> India's premier international
		airline which provides you with one of the finest experiences across
		the skies. <br> Our high standards of service and reliability,
		efficient operations and focus on innovation has enabled us become <br>one
		of India's favourite domestic and international airline.
	</div>
	<div id="form"></div>
	<div id="iframeDisp">
		<iframe name="main1" id="mainFrame1" src=""
			style="overflow-x: hidden;"> </iframe>
	</div>
	<div id="about">
		<br>
		<h3>Mr. Akash</h3>
		Mr. Akash , the founder Chairman of Divyam Airlines, India's premier
		airline, has over 20 years of experience in Computer Technologies.
		With his vast experience in the field of IT development, Mr. Akash is
		the recipient of several national and international awards.
		
		<br><br> <br>  Few honorable mentions:
		<h4> Abhishek Roy : Techinal Lead </h4>
		<h4>Akanksha Mishra : Designing Lead</h4>
	</div>
	<div id="footerBg"></div>
	<div id="footer">
		<div style="font-size: small; padding: 1%;">© Divyam Airlines
			(India) Ltd. All rights reserved.</div>
	</div>

</body>
</html>