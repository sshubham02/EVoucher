package com.assignment.evoucher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ViewVouchers")
public class ViewVouchers extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ViewVouchers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Connection con;
		PreparedStatement ps;
		
		if (session == null ||  session.getAttribute("userFname")==null && session.getAttribute("userType") != "0")
		  {
			response.sendRedirect("login.jsp");
			return;
		  }else {
				try {
					con = createDbConn.getCon();
					String query = "SELECT * FROM `vouchers` WHERE (CURDATE() >=`startdate` AND CURDATE() <= `expdate`) AND `vid` NOT IN (SELECT `vid` FROM `redimvoucher`)";
					ps = con.prepareStatement(query);
					ResultSet resultSet = ps.executeQuery();
					PrintWriter out = response.getWriter();
					out.print("<!DOCTYPE html>\r\n" + 
							"<html>\r\n" + 
							"<head>\r\n" + 
							"<meta charset=\"ISO-8859-1\">\r\n" + 
							"<title>E-Voucher</title>\r\n" + 
							" <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/bootstrap/css/bootstrap.min.css\">\r\n" + 
							" <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n" + 
							" <script type=\"text/javascript\" src=\"plugins/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
							" <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n" + 
							"</head>\r\n" + 
							"<body>");
					out.print("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\r\n" + 
							"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo01\" aria-controls=\"navbarTogglerDemo01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
							"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
							"  </button>\r\n" + 
							"  <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo01\">\r\n" + 
							"    <a class=\"navbar-brand\" href=\"#\">E Voucher System</a>\r\n" + 
							"    <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\r\n" + 
							"      <li class=\"nav-item active\">\r\n" + 
							"        <a class=\"nav-link\" href=\"ViewVouchers\">View Vouchers <span class=\"sr-only\">(current)</span></a>\r\n" + 
							"      </li>\r\n" + 
							"      <li class=\"nav-item\">\r\n" + 
							"        <a class=\"nav-link\" href=\"voucherdistribution.jsp\">Voucher Distribution</a>\r\n" + 
							"      </li>\r\n" + 
							"    </ul>\r\n" + 
							"    <form class=\"form-inline my-2 my-lg-0\">\r\n" + 
							"      <button class=\"btn btn-outline-success my-2 my-sm-0  \" type=\"submit\">Search</button>\r\n" + 
							"    </form>\r\n" + 
							"  </div>\r\n" + 
							"</nav>");
						
					out.print("<table class='table'>");
					out.print("<thead>");
					out.print("<tr>");
					out.print("<th>");
					out.print("VoucherId");
					out.print("</th>");
					out.print("<th>");
					out.print("Face Value");
					out.print("</th>");
					out.print("<th>");
					out.print("Start Date");
					out.print("</th>");
					out.print("<th>");
					out.print("End Date");
					out.print("</th>");
					out.print("</tr>");
					out.print("</thead>");
					
					while (resultSet.next()) {
						out.print("<tr>");
						
						out.println("<td>");
						out.print(resultSet.getInt("vid"));
						out.println("</td>");
						
						out.println("<td>");
						out.print(resultSet.getDouble("amt"));
						out.println("</td>");
						
						out.println("<td>");
						out.print(resultSet.getDate("startdate"));
						out.println("</td>");
						
						out.println("<td>");
						out.print(resultSet.getDate("expdate"));
						out.println("</td>");
						
						out.print("</tr>");
					}
					out.print("</table>");
					resultSet.close();
					ps.close();
					con.close();
				}catch (Exception e) {
					System.out.println(e);
				}
		  }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
