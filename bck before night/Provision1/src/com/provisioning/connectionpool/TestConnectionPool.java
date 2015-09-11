package com.provisioning.connectionpool;

import java.sql.*;
public class TestConnectionPool {

	public static void main(String[] args) {
		try{
		Connection con=DataSource.getConnection();
		System.out.println("Obtained connection from pool");
		DataSource.returnConnection(con);
		System.out.println("connection returned to pool");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Test Connection class not found "+e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("Test connection sql exception "+e.getMessage());
		}
	}

}
