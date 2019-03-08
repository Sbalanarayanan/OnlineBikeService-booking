package com.chainsys.bikeservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bikeservice.connectionutil.ConnectionUtil;
import com.chainsys.bikeservice.model.ServiceType;

public class ServiceTypeDAO {
	// display all service name in order
	/**
	 * @return
	 */
	public List<ServiceType> findAll() {
		ArrayList<ServiceType> serviceLists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,days FROM service_type ORDER BY id";
			preparedStatement = connection.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				ServiceType service = new ServiceType();
				service.setId(resultset.getInt("id"));
				service.setName(resultset.getString("name"));
				service.setDays(resultset.getInt("days"));
				// System.out.println(resultset.getInt("days"));
				serviceLists.add(service);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return serviceLists;
	}

	// select particular service id,name,days by the id
	/**
	 * @param serviceid
	 * @return
	 */
	public ServiceType findById(int serviceid) {
		ServiceType type = new ServiceType();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,days FROM service_type where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, serviceid);
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				type = new ServiceType();
				type.setId(resultset.getInt("id"));
				type.setName(resultset.getString("name"));
				type.setDays(resultset.getInt("days"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}

		return type;
	}

	// add service name in the service type table by admin
	/**
	 * @param setType
	 * @throws Exception
	 */
	public void addType(ServiceType setType) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Insert into service_type(id,name,days) values(type_id_seq.NEXTVAL,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, setType.getName());
			preparedStatement.setInt(2, setType.getDays());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	// deleting service name by the admin
	/**
	 * @param deleteType
	 * @throws Exception
	 */
	public void deleteService(ServiceType deleteType) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "delete from service_type where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deleteType.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}
}