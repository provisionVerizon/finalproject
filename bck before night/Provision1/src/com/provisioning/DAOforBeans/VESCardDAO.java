package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.provisioning.javabeans.VESCard;

public class VESCardDAO {
ArrayList<VESCard> vescardlist;
	
	public VESCardDAO() {
		
		vescardlist=new ArrayList<VESCard>();
	}
	
	public ArrayList<VESCard> createVesCards(Connection con,String dslamid)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("SELECT VES_CARD_ID,STATUS FROM VESCARD WHERE DSLAM_ID=?");
			pst.setString(1, dslamid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				VESCard vc=new VESCard();
			    vc.setVES_CARD_ID(rs.getString("VES_CARD_ID"));
			    vc.setSTATUS(rs.getString("STATUS"));
				vescardlist.add(vc);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem with ves card dao " + e.getMessage());
		}
		return vescardlist;
	}
}
