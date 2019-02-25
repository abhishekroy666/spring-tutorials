<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_staffIndex.css">
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/background.cycle.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#staffHome").backgroundCycle({
			imageUrls : [ 'img/e1.jpg', 'img/e3.jpg', 'img/e2.jpg','img/e4.jpg' ],
			fadeSpeed : 2000,
			duration : 5000,
			backgroundSize : SCALING_MODE_STRETCH
		});
	});
</script>
</head>
<body id="staffHome" style="margin: 0%">
	<jsp:include page="staffMenu.jsp" />
	<div id="form"></div>
	
	 <iframe name="main" id="mainframe" src="staffProfile.jsp"></iframe>
       	
	<div id="footerBg"></div>
	<div id="footer">
		<div style="font-size: small; padding: 1%;">© Divyam Airlines
			(India) Ltd. All rights reserved.</div>
	</div>
</body>
</html>