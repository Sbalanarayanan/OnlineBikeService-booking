package com.chainsys.bikeservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bikeservice.connectionutil.ConnectionUtil;
import com.chainsys.bikeservice.model.EmployeeDetail;

public class EmployeeDetailDAO {

	// inserting the employee details
	/**
	 * @param entry
	 * @throws Exception
	 */
	public void addEmployee(EmployeeDetail entry) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Insert into worker(id,name,phone,address) values(worker_id_seq.NEXTVAL,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entry.getName());
			preparedStatement.setLong(2, entry.getPhone());
			preparedStatement.setString(3, entry.getAddress());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	// display all employee details
	/**
	 * @return
	 */
	public List<EmployeeDetail> findAll() {
		ArrayList<EmployeeDetail> employeeLists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,phone,address FROM worker ORDER BY id";
			preparedStatement = connection.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			employeeLists = new ArrayList<>();
			while (resultset.next()) {
				EmployeeDetail employee = new EmployeeDetail();
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setPhone(resultset.getLong("phone"));
				employee.setAddress(resultset.getString("address"));
				employeeLists.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return employeeLists;
	}

	// deleting the employee details
	/**
	 * @param delete
	 */
	public void deleteService(EmployeeDetail delete) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from worker where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, delete.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

}
