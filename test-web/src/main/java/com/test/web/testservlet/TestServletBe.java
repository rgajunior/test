package com.test.web.testservlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.model.test.TestBe;
import com.test.model.test.TestVo;

public class TestServletBe {
	private Connection conn;

	public TestServletBe() throws SQLException {
		getConnection();
	}

	private void getConnection() throws SQLException {
		try {
			DataSource dataSource = (DataSource) new InitialContext().lookup("java:/mysqlDS");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public TestVo select(int i) throws SQLException {
		TestBe testBe = new TestBe(conn);
		
		return testBe.select(i);
	}
}
