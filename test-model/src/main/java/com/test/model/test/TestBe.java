package com.test.model.test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestBe {
	private TestDao dao;
	private Connection conn;
	
	public TestBe(Connection conn){
		this.conn = conn;
		dao = new TestDao(conn);
	}
	
	public int insert(TestVo testVo) throws SQLException{
		return dao.insert(testVo);
	}
	
	public TestVo select(int id) throws SQLException{
		return dao.select(id);
	}
}
