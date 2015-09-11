package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.WirelessCard;
import com.provisioning.javabeans.WirelessCustomer;

public class WirelessCustomerDAO {
	WirelessCustomer c;
	WirelessCard vd;
	Connection con;
	
	public WirelessCustomerDAO()
	{
		c=new WirelessCustomer();
		vd=new WirelessCard();
		initializeConnect();
	}
	private void initializeConnect()
	{
		try{
		con=DataSource.getConnection();
		}
		catch(ClassNotFoundException e)
		{
			
		}
		catch (SQLException e) {
			
		}
	}
	public WirelessCustomer getCustomerDetails(int customerid)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("select CUSTOMER_ID,FIRST_NAME,LAST_NAME,TYPE,STREETNAME,ZIPCODE,CITY,STATE,COUNTRY,STATUS from customer where CUSTOMER_ID=?");
			pst.setInt(1, customerid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				c.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
				c.setFIRST_NAME(rs.getString("FIRST_NAME"));
				c.setLAST_NAME(rs.getString("FIRST_NAME"));
				c.setSTREETNAME(rs.getString("STREETNAME"));
				c.setZIPCODE(Integer.parseInt(rs.getString("ZIPCODE")));
				c.setCITY(rs.getString("CITY"));
				c.setSTATE(rs.getString("STATE"));
				c.setCOUNTRY(rs.getString("COUNTRY"));
			}
			vd=getWSSCard(customerid);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	public WirelessCard getWSSCard(int customerid) {
		
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select WIRELESS_ID,STATUS from WS_CARD where CUSTOMER_ID=? ");
			 pst.setInt(1, customerid);
			
				 ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				 vd.setWIRELESS_ID(rs1.getString("WIRELESS_ID"));
				 vd.setSTATUS(rs1.getString("STATUS"));
				 vd.setService_id(rs1.getInt("SERVICE_ID"));
			}
			  }
		 catch(SQLException e)
		 {
			 
		 }
		return vd;
		// TODO Auto-generated method stub
		
	}
	
}
