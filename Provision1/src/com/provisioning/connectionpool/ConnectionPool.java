package com.provisioning.connectionpool;

import java.util.ArrayList;
import java.sql.*;

public class ConnectionPool {
  ArrayList<Connection> availableConnections=new ArrayList<Connection>();
  public ConnectionPool()
  {
	  initializePool();
  }
  private void initializePool()
  {
	  int counter=0;
	  while(counter < Configuration.getInsatance().DB_MAX_CONNECTIONS)
	  {	  availableConnections.add(createConnection());
	  counter++;
  }
  }
  private Boolean poolHasMoreConnections()
  {
	  if(availableConnections.size()>0)
		  return true;
	  return false;
  }
  public Connection createConnection()
  {
	  Connection con;
	  Configuration config=Configuration.getInsatance();
	  try{
		  
		  Class.forName(config.DB_DRIVER);
		  con=DriverManager.getConnection(config.DB_URL,config.DB_USERNAME,config.DB_PASSWORD);
		 // System.out.println("Connection Successfull");
		  return con;
		  
	  }
	  catch(ClassNotFoundException e)
	  {
		  System.out.println("Problem with Connection Pool class not found exception  "+e.getMessage());
	  }
	  catch(SQLException e)
	  {
		  System.out.println("Problem with Connection Pool "+e.getMessage());
	  }
	  return null;
  }
  public synchronized Connection getConnectionFromPool()
  {
	  Connection con=null;
	  if(poolHasMoreConnections())
		  con=availableConnections.get(0);
	  availableConnections.remove(0);
	  return con;
  }
  public synchronized void returnConnectionToPool(Connection con)
  {
	  if(availableConnections.size() <  Configuration.getInsatance().DB_MAX_CONNECTIONS)
	  availableConnections.add(con);
  }
}
