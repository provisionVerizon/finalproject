package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.Customer;
import com.provisioning.javabeans.VESCard;
import com.provisioning.javabeans.VESCustomer;

public class VESCustomerDAO {
	VESCustomer c;
	VESCard vd;
	Connection con;
	
	public VESCustomerDAO()
	{
		c=new VESCustomer();
		vd=new VESCard();
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
	public VESCustomer getCustomerDetails(int customerid)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("select CUSTOMER_ID,FIRST_NAME,LAST_NAME,TYPE,STREETNAME,ZIPCODE,CITY,STATE,COUNTRY,STATUS from customer where CUSTOMER_ID=?");
			pst.setInt(1, customerid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				c.setCUSTOMER_ID(rs.getString("CUSTOMER_ID"));
				c.setFIRST_NAME(rs.getString("FIRST_NAME"));
				c.setFIRST_NAME(rs.getString("LAST_NAME"));
				c.setSTREETNAME(rs.getString("STREETNAME"));
				c.setZIPCODE(Integer.parseInt(rs.getString("ZIPCODE")));
				c.setCITY(rs.getString("CITY"));
				c.setSTATE(rs.getString("STATE"));
				c.setCOUNTRY(rs.getString("COUNTRY"));
			}
			vd=getVESCard(customerid);		
c.setVcard(vd);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	public VESCard getVESCard(int customerid) {
		
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select VES_CARD_ID,STATUS from VES_CARD where CUSTOMER_ID=? ");
			 pst.setInt(1, customerid);
			
				 ResultSet rs1=pst.executeQuery();
			while(rs1.next())
			{
				 vd.setVES_CARD_ID(rs1.getString("VES_CARD_ID"));
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
