package com.test.model.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDao {
	private Connection conn;

	public TestDao(Connection conn) {
		this.conn = conn;
	}

	public int insert(TestVo testVo) throws SQLException {
		String sql = "INSERT INTO test VALUES(null, ?)";

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, testVo.getInfo());

			return ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	public TestVo select(int id) throws SQLException {
		String sql = "SELECT * FROM test WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			TestVo testVo = null;
			if (rs.next()) {
				testVo = new TestVo();
				testVo.setId(rs.getInt(1));
				testVo.setInfo(rs.getString(2));
			}

			return testVo;
		} finally {
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}
	}

}
