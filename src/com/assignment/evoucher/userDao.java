package com.assignment.evoucher;

import java.sql.SQLException;
import java.util.List;

public interface userDao {
	public user getUser(String username,String password);
	
	public List<Vouchers> list() throws SQLException;
	
	public void distVoucher(int custId,int voucherId);
}
