<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Voucher</title>
 <link rel="stylesheet" type="text/css" href="plugins/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/css/bootstrap-select.css">
 <link rel="stylesheet" type="text/css" href="css/main.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/js/bootstrap-select.js"></script>
</head>
<body>
<%
	if(session.getAttribute("userFname")==null && session.getAttribute("userType") != "0")
		response.sendRedirect("login.jsp");
%>
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

<div class="container-fluid">
<div class="row">
<div class="col-md-4">
<h3>Voucher Distribution</h3>
<form class="form-signin" method="post" action="distributevoucher">
	  <div class="form-group">
    <label for="exampleFormControlSelect2">Select Voucher Id</label>
    <select class="form-control" name = "voucherId" id="voucherId">
      <option value='1'>1</option>
      <option value='2'>2</option>
      <option value='3'>3</option>
      <option value='4'>4</option>
      <option value='5'>5</option>
    </select>
  </div>
 	  <div class="form-group">
    <label for="exampleFormControlSelect2">Select Mobile Number</label>
    <select class="form-control" name="custId" id="custId">
      <option value='1'>8856000732</option>
      <option value='2'>989000732</option>
      <option value='3'>777745673</option>
      <option value='4'>887634565</option>
      <option value='5'>8793659608</option>
    </select>
  </div>
  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Distribute Voucher</button>
</form>
</div>
</div>
</div>


</body>
</html>