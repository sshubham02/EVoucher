package com.assignment.evoucher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/distributevoucher")
public class Distributevoucher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Distributevoucher() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession(false);
		Connection con;
		PreparedStatement ps;
		
		if (session == null ||  session.getAttribute("userFname")==null && session.getAttribute("userType") != "0")
		  {
			response.sendRedirect("login.jsp");
			return;
		  }else {
				int custId = Integer.parseInt(request.getParameter("custId"));
				int voucherId = Integer.parseInt(request.getParameter("voucherId"));
			
				try {
					con = createDbConn.getCon();
					String query = "INSERT INTO `custvouchers`(`custid`,`vid`)VALUES (?,?);";
					ps = con.prepareStatement(query);
					ps.setInt(1, custId);
					ps.setInt(2, voucherId);
					ps.executeUpdate();
					con.close();
				}catch (Exception e) {
					System.out.println(e);
				}
				
		  }
	}

}
