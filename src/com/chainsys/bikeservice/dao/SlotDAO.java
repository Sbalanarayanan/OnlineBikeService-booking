package com.chainsys.bikeservice.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bikeservice.connectionutil.ConnectionUtil;
import com.chainsys.bikeservice.model.Slot;

public class SlotDAO {

	public int addSlot(Slot slot) throws Exception {
		int update = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Insert into slot(id,count,up_date) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, slot.getId());
			preparedStatement.setInt(2, slot.getCount());
			update = slot.getCount();
			preparedStatement.setDate(3, Date.valueOf(slot.getDate()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return update;
	}

	public Slot findByDate(Date date) {
		Slot slot = new Slot();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select id,up_date,count from slot where up_date=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, date);
			// preparedStatement.setDate(1, Date.valueOf(slot.getDate()));
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				slot = new Slot();
				slot.setId(resultset.getInt("id"));
				slot.setCount(resultset.getInt("count"));

			}
			ConnectionUtil.close(connection, preparedStatement, resultset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return slot;
	}

	public List<Slot> findAll() {
		ArrayList<Slot> slotList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,count,up_date FROM slot ORDER BY id";
			preparedStatement = connection.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			slotList = new ArrayList<>();
			while (resultset.next()) {
				Slot slot = new Slot();
				slot.setId(resultset.getInt("id"));
				slot.setCount(resultset.getInt("count"));
				slot.setDate(resultset.getDate("up_date").toLocalDate());
				slotList.add(slot);
			}
			ConnectionUtil.close(connection, preparedStatement, resultset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultset);
		}
		return slotList;
	}

	public void upDate(Slot count) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE slot set count=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, count.getCount());
		preparedStatement.setInt(2, count.getId());
		preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, null);

	}

}
