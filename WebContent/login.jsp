<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Voucher</title>
 <link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/main.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<section class="cb-section bg-login">
		<div class="container">
			<div class="login-card card-container">
				<img id="profile-img" class="profile-img-card" src="img/avatar.png" />
				<form class="form-signin" method="post" action="login">
				<% 
					if (request.getAttribute("message") != null){
						out.print("<div id='frm_err' class='error-message'>"+request.getAttribute("message")+"</div>");
					}
				%>
					<input type="email" id="username" name="username" class="form-control" placeholder="Username" value="" required autofocus><br> 
					<input type="password" id="password" name="password" class="form-control" placeholder="Password" value="" required><br>
					<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
				</form>
			</div>
		</div>
	</section>
</body>
</html>