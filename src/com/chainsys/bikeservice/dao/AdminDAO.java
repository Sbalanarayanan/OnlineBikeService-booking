package com.chainsys.bikeservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.bikeservice.connectionutil.ConnectionUtil;
import com.chainsys.bikeservice.model.AdminLogin;

public class AdminDAO {

	// admin login validation phone and password in the sql table
	/**
	 * @param login
	 * @return
	 */
	public Boolean checkLogin(AdminLogin login) {
		Boolean isFind = false;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select phone,password from admin where phone=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, login.getPhone());
			preparedStatement.setString(2, login.getPassword());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isFind = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return isFind;

	}

}
