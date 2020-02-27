package com.assignment.evoucher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {
	static Connection con;
	static PreparedStatement ps;
	user usr;

	@Override
	public user getUser(String username, String password) {
		try {
			usr = new user();
			con = createDbConn.getCon();
			String query = "SELECT * FROM `users` WHERE `usrname`=?";
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usr.setuId(rs.getString(1));
				usr.setFname(rs.getString(2));
				usr.setLname(rs.getString(3));
				usr.setUsername(rs.getString(4));
				usr.setPassword(rs.getString(5));
				usr.setUtype(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return usr;
	}
	
	public List<Vouchers> list() throws SQLException {
			List<Vouchers> vouchers = new ArrayList<Vouchers>();
			try {
				con = createDbConn.getCon();
				String query = "SELECT * FROM `vouchers`";
				ps = con.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					Vouchers voucher = new Vouchers();
					voucher.setVid(resultSet.getLong("vid"));
					voucher.setAmt(resultSet.getDouble("amt"));
					voucher.setStartdate(resultSet.getString("startdate"));
					voucher.setExpdate(resultSet.getString("expdate"));
					vouchers.add(voucher);
				}
				resultSet.close();
				ps.close();
				con.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			return vouchers;
	}
	
	public void distVoucher(int custId,int voucherId) {
		try {
			usr = new user();
			int row = 0;
			con = createDbConn.getCon();
			String query = "INSERT INTO `custvouchers`(`custid`,`vid`)VALUES (?,?);";
			ps = con.prepareStatement(query);
			ps.setInt(1, custId);
			ps.setInt(2, voucherId);
			row = ps.executeUpdate();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
