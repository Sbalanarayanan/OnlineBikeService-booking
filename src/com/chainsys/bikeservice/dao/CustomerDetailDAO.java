package com.chainsys.bikeservice.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bikeservice.connectionutil.ConnectionUtil;
import com.chainsys.bikeservice.model.CustomerDetail;
import com.chainsys.bikeservice.model.ServiceType;

//adding customer details in service sql table;
public class CustomerDetailDAO {
	/**
	 * @param apply
	 * @throws Exception
	 */
	public void addCustomer(CustomerDetail apply) throws Exception {
		ServiceType service = new ServiceType();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Insert into service(id,customer_name,phone,address,company,bike_name,bike_model,bike_number,customer_issue,expected_date) values(service_id_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, apply.getName());
			preparedStatement.setLong(2, apply.getPhone());
			preparedStatement.setString(3, apply.getAddress());
			preparedStatement.setString(4, apply.getCompanyName());
			preparedStatement.setString(5, apply.getBikeName());
			preparedStatement.setString(6, apply.getBikeModel());
			preparedStatement.setString(7, apply.getBikeNumber());
			preparedStatement.setInt(8, apply.getCustomerIssue().getId());
			/*
			 * ServiceTypeDAO typedao = new ServiceTypeDAO(); service =
			 * typedao.findById(apply.getCustomerIssue().getId());
			 */
			LocalDate date = LocalDate.now().plusDays(service.getDays());
			preparedStatement.setDate(9, Date.valueOf(date));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("unable to insert");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	// displaying all the customer details by fetching in the service sql table
	/**
	 * @return
	 */
	public List<CustomerDetail> findAll() {
		ArrayList<CustomerDetail> customerLists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,customer_name,phone,address,company,bike_name,bike_model,bike_number,customer_issue,expected_date FROM service ORDER BY id";
			preparedStatement = connection.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			customerLists = new ArrayList<>();
			while (resultset.next()) {
				CustomerDetail cat = new CustomerDetail();
				cat.setId(resultset.getInt("id"));
				cat.setName(resultset.getString("customer_name"));
				cat.setPhone(resultset.getLong("phone"));
				cat.setAddress(resultset.getString("address"));
				cat.setCompanyName(resultset.getString("company"));
				cat.setBikeName(resultset.getString("bike_name"));
				cat.setBikeModel(resultset.getString("bike_model"));
				cat.setBikeNumber(resultset.getString("bike_number"));
				ServiceType service = new ServiceType();
				ServiceTypeDAO dao = new ServiceTypeDAO();
				service.setId(Integer.parseInt(resultset
						.getString("customer_issue")));
				service = dao.findById(service.getId());
				cat.setCustomerIssue(service);
				cat.setExpectedDate(resultset.getDate("expected_date")
						.toLocalDate());
				customerLists.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return customerLists;
	}

	// selecting the particular customer details by customer Id
	/**
	 * @param serviceid
	 * @return
	 */
	public CustomerDetail findById(int serviceid) {
		CustomerDetail custId = new CustomerDetail();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id FROM service_type where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, serviceid);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				custId = new CustomerDetail();
				custId.setId(resultset.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return custId;
	}

	// selecting the particular customer details by matching customer date
	/**
	 * @param date
	 * @return
	 */
	public ArrayList<CustomerDetail> findByDate(LocalDate date) {
		ArrayList<CustomerDetail> customerLists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT customer_name,phone,address,company,bike_name,bike_model,bike_number,customer_issue FROM service where expected_date=?";
			preparedStatement = connection.prepareStatement(sql);
			CustomerDetail cat = null;
			preparedStatement.setDate(1, Date.valueOf(date));
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				cat = new CustomerDetail();
				cat.setName(resultset.getString("customer_name"));
				cat.setPhone(resultset.getInt("phone"));
				cat.setAddress(resultset.getString("address"));
				cat.setCompanyName(resultset.getString("company"));
				cat.setBikeName(resultset.getString("bike_name"));
				cat.setBikeModel(resultset.getString("bike_model"));
				cat.setBikeNumber(resultset.getString("bike_number"));
				ServiceType service = new ServiceType();
				ServiceTypeDAO dao = new ServiceTypeDAO();
				service.setId(Integer.parseInt(resultset
						.getString("customer_issue")));
				service = dao.findById(service.getId());
				cat.setCustomerIssue(service);
				customerLists.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return customerLists;
	}

	// deleting the customer details by given date
	/**
	 * @param deleteCustomer
	 * @throws Exception
	 */
	public void deleteCustomer(LocalDate deleteCustomer) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// CustomerDetail detail;
			connection = ConnectionUtil.getConnection();
			String sql = "delete from service where expected_date=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, Date.valueOf(deleteCustomer));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}
}
