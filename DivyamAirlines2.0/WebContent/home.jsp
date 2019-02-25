<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_home.css">
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/background.cycle.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#Home").backgroundCycle({
			imageUrls : [ 'img/c3.jpg', 'img/c2.jpg', 'img/c.jpg' ],
			fadeSpeed : 2000,
			duration : 5000,
			backgroundSize : SCALING_MODE_STRETCH
		});
	});
</script>

</head>
<body id="Home" style="margin: 0%">
	<jsp:include page="customerMenu.jsp" />
	<div id="form"></div>
	
	<iframe name="main" id="mainframe" src="profile.jsp"></iframe>

	<div id="footerBg"></div>
	<div id="footer">
		<div style="font-size: small; padding: 1%;">© Divyam Airlines
			(India) Ltd. All rights reserved.</div>
	</div>
</body>
</html>