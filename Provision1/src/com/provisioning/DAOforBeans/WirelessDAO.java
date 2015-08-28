package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.provisioning.javabeans.WirelessCard;

public class WirelessDAO {
ArrayList<WirelessCard> wscardlist;
	
	public WirelessDAO() {
		
		wscardlist=new ArrayList<WirelessCard>();
	}
	
	public ArrayList<WirelessCard> createWirelessCards(Connection con,String dslamid)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("SELECT WIRELESS_ID,STATUS FROM WIRELESS WHERE DSLAM_ID=?");
			pst.setString(1, dslamid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				WirelessCard wc=new WirelessCard();
			    wc.setWIRELESS_ID(rs.getString("WIRELESS_ID"));
			    wc.setSTATUS(rs.getString("STATUS"));
				wscardlist.add(wc);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem with ves card dao " + e.getMessage());
		}
		return wscardlist;
	}
}
