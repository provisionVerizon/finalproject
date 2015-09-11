package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provisioning.connectionpool.DataSource;

public class PonPortDAO {
	
	public void updatePonStatus(String ponportid,String status)
	{
		Connection con=null;
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("update ponport set status=? where pon_port_id=?");
			pst.setString(1, status);
			pst.setString(2, ponportid);
			pst.executeUpdate();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("in update pon status" + e.getMessage());
		}
		DataSource.returnConnection(con);
	}
	public String getPonIds(String ponid)
	{
		String jSonStr="{\"pon_port\" :[";
		
		Connection con=null;
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from ponport where pon_id=?");
			pst.setString(1, ponid);
			ResultSet rs=pst.executeQuery();
			
			   
			while(rs.next())
			{
				jSonStr+="{\"name\":\"pon_port\",\"id\":\"";
			
				jSonStr+=rs.getString("pon_port_id");
				jSonStr+="\",\"status\":\"";
				jSonStr+=rs.getString("status");
				jSonStr+="\"},";
			}
			int len=jSonStr.length();
			jSonStr=jSonStr.substring(0, len-1);
			jSonStr+="]}";
			//pst.setString(2, ponportid);
			pst.executeUpdate();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("in update pon status" + e.getMessage());
		}
		DataSource.returnConnection(con);
	    return jSonStr;
	}
}
