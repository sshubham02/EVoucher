<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Voucher</title>
 <link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/main.css">
 <script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="#">E Voucher System</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="ViewVouchers">View Vouchers <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="voucherdistribution.jsp">Voucher Distribution</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <button class="btn btn-outline-success my-2 my-sm-0  " type="submit">Search</button>
    </form>
  </div>
</nav>

<!-- <h1>Hi ${message} !!! We welcome you !!!</h1> -->

<%
	String userFname = null;
	String userLname = null;
	String userId = null;
	String usrName = null;
	String userType = null;

	/*Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userFname"))
				userFname = cookie.getValue();
			
			if (cookie.getName().equals("userLname"))
				userLname = cookie.getValue();
			
			if (cookie.getName().equals("userId"))
				userId = cookie.getValue();
			
			if (cookie.getName().equals("usrName"))
				usrName = cookie.getValue();
			
			if (cookie.getName().equals("userType"))
				userType = cookie.getValue();
		}
	}
	if (cookies == null && userId == null && Integer.parseInt(userType) == 1)*/
	if(session.getAttribute("userFname")==null && session.getAttribute("userType") != "0")
		response.sendRedirect("login.jsp");
%>

<h3>Hi <%=session.getAttribute("userFname")%> <%=session.getAttribute("userLname")%>, Login successful.</h3>
<br>

</body>
</html>