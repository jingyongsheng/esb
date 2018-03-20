package com.zcbl.esb.bus.persit.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Queue;

public interface JdbcDao {
	public boolean closeAll(String name, ResultSet rst, Statement stmt, Connection conn);

	public boolean closeConnection(String name, Connection conn);

	public boolean closeStatement(Statement stmt);

	public boolean closeResultSet(ResultSet rst);

	public int executeUpdate(String name, String sql, Connection conn, Object... obj);

	public int executeBatchUpdate(String name, Queue<String> values, Connection conn, Object... obj);

	public int executePreparBatchUpdate(String name, List<Queue<String>> values, Connection conn, String sql);

	public ResultSet queryAll(String name, String sql, Connection conn, Object... obj);

}