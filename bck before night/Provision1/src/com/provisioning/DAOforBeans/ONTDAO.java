package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provisioning.connectionpool.DataSource;

public class ONTDAO {

	public String getDetailsCustomer(String portid)
	{
		Connection con;
		String result=null;
			try {
				con=DataSource.getConnection();
				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID,ONT_ID FROM ONT WHERE PON_PORT_ID=?");
				ps.setString(1, portid);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					result="CUSTOMER ID "+ rs.getString("CUSTOMER_ID")+"\n ONT ID: " + rs.getString("ONT_ID");
				DataSource.returnConnection(con);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
		
	}
	public String getVesDetailsCustomer(String portid)
	{
		Connection con;
		String result=null;
			try {
				con=DataSource.getConnection();
				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID,ONT_ID FROM ONT WHERE PON_PORT_ID=?");
				ps.setString(1, portid);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					result=rs.getString("CUSTOMER_ID")+"            "+rs.getString("ONT_ID");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
		
	}
	public String getWirelessDetailsCustomer(String portid)
	{
		Connection con;
		String result=null;
			try {
				con=DataSource.getConnection();
				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID FROM WIRELESS WHERE WIRELESS_ID=?");
				ps.setString(1, portid);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					result=rs.getString("CUSTOMER_ID");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
		
	}
}
