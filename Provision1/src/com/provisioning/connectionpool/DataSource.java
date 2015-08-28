package com.provisioning.connectionpool;

import java.sql.*;

public class DataSource {
  
 static ConnectionPool pool = new ConnectionPool();
  
 public static Connection getConnection() throws ClassNotFoundException, SQLException{
  Connection connection = pool.getConnectionFromPool();
  return connection;
 }
  
 public static void returnConnection(Connection connection) {
  pool.returnConnectionToPool(connection);
 }
}
