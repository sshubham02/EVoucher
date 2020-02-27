package com.assignment.evoucher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoucherDao {
	static Connection con;
	static PreparedStatement ps;
	
	
	public List<Vouchers> list() throws SQLException{
		List<Vouchers> vouchers = new ArrayList<Vouchers>();
		try {
			con = createDbConn.getCon();
			String query = "SELECT * FROM `vouchers`";
			ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Vouchers voucher = new Vouchers();
				System.out.println(resultSet.getLong("vid"));
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
}
