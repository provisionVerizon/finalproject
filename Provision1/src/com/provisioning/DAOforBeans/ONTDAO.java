



package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provisioning.connectionpool.DataSource;
public class ONTDAO {

	public String getDetailsCustomer(String portid)
	{
		Connection con=null;
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
			DataSource.returnConnection(con);
		return result;
		
	}
	public String getVesDetailsCustomer(String portid)
	{
		Connection con=null;
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
			DataSource.returnConnection(con);
		return result;
		
	}
	public String getWirelessDetailsCustomer(String portid)
	{
		Connection con=null;
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
			DataSource.returnConnection(con);
		return result;
		
	}
	
	public String getONT()
	{
		Connection con;
		String ontid=null;
		String JsonStr="{\"ont\": [";
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("select ont_id from ont");
			ResultSet rs=pst.executeQuery();
			int flag=1;
			while(rs.next())
			{
				flag=0;
				ontid=rs.getString("ont_id");
				JsonStr+="{\"ont_id\":\""+ontid+"\"},";				
			}
			if(flag==1)
			{
				JsonStr+=",";				
				
			}
			int len=JsonStr.length();
			JsonStr=JsonStr.substring(0, len-1);
			JsonStr+="],";
		}
		catch(SQLException  | ClassNotFoundException e)
		{
			System.out.println("error connection to the database getponids" + e.getMessage());
		    return "";
		}
		System.out.println(JsonStr);
		DataSource.returnConnection(con);
		return JsonStr;
	}
	public void updateOntStatus(String ontid,String status)
	{
		Connection con=null;
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("update ont set status=? where ont_id=?");
			pst.setString(1, status);
			pst.setString(2, ontid);
			pst.executeUpdate();
			pst.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("in update ONT status" + e.getMessage());
		}
		DataSource.returnConnection(con);
	}

}

//public class ONTDAO {
//
//	public String getDetailsCustomer(String portid)
//	{
//		Connection con;
//		String result=null;
//			try {
//				con=DataSource.getConnection();
//				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID,ONT_ID FROM ONT WHERE PON_PORT_ID=?");
//				ps.setString(1, portid);
//				ResultSet rs=ps.executeQuery();
//				while(rs.next())
//					result="CUSTOMER ID "+ rs.getString("CUSTOMER_ID")+"\n ONT ID: " + rs.getString("ONT_ID");
//				DataSource.returnConnection(con);
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return result;
//		
//	}
//	public String getVesDetailsCustomer(String portid)
//	{
//		Connection con;
//		String result=null;
//			try {
//				con=DataSource.getConnection();
//				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID,ONT_ID FROM ONT WHERE PON_PORT_ID=?");
//				ps.setString(1, portid);
//				ResultSet rs=ps.executeQuery();
//				while(rs.next())
//					result=rs.getString("CUSTOMER_ID")+"            "+rs.getString("ONT_ID");
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return result;
//		
//	}
//	public String getWirelessDetailsCustomer(String portid)
//	{
//		Connection con;
//		String result=null;
//			try {
//				con=DataSource.getConnection();
//				PreparedStatement ps=con.prepareStatement("SELECT CUSTOMER_ID FROM WIRELESS WHERE WIRELESS_ID=?");
//				ps.setString(1, portid);
//				ResultSet rs=ps.executeQuery();
//				while(rs.next())
//					result=rs.getString("CUSTOMER_ID");
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return result;
//		
//	}
//}
