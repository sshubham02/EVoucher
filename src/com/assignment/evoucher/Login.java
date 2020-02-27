package com.assignment.evoucher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao userdao = new userDaoImpl();
		//VoucherDao voucherDao = null;
		
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		user u =  userdao.getUser(userName, passWord);
		
		if(u != null && u.getFname() != null && passWord.equals(u.getPassword())) {
			
			
			HttpSession session = request.getSession();
			
			session.setAttribute("validSession",true);
			session.setAttribute("userFname",u.getFname());
			session.setAttribute("userLname",u.getLname());
			session.setAttribute("userId",u.getuId());
			session.setAttribute("usrName",u.getUsername());
			session.setAttribute("userType",u.getUtype());
			
			/*Cookie loginCookieFname = new Cookie("userFname",u.getFname());
			Cookie loginCookieLname = new Cookie("userLname",u.getLname());
			Cookie loginCookieUId = new Cookie("userId",u.getuId());
			Cookie loginCookieUsrName = new Cookie("usrName",u.getUsername());
			Cookie loginCookieUsrType = new Cookie("userType",u.getUtype());
			
			loginCookieFname.setMaxAge(30*02);
			loginCookieLname.setMaxAge(30*02);
			loginCookieUId.setMaxAge(30*02);
			loginCookieUsrName.setMaxAge(30*02);
			loginCookieUsrType.setMaxAge(30*02);
			
			response.addCookie(loginCookieFname);
			response.addCookie(loginCookieLname);
			response.addCookie(loginCookieUId);
			response.addCookie(loginCookieUsrName);
			response.addCookie(loginCookieUsrType);
			
			//request.setAttribute("message", u.getFname()+' '+u.getLname());
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);*/
			try {
				List<Vouchers> voucher = userdao.list();
				request.setAttribute("voucher", voucher);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			
			session.setAttribute("validSession",false);
			request.setAttribute("message","Invalid login credentials.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
