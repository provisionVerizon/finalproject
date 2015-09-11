package com.provisioning.DAOforBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.provisioning.javabeans.VideoCard;


public class VideoCardDAO {

	ArrayList<VideoCard> videocardlist;
	
	public VideoCardDAO() {
		
		videocardlist=new ArrayList<VideoCard>();
	}
	
	public ArrayList<VideoCard> createVideoeCards(Connection con,String dslamid)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("SELECT VIDEO_PORT_ID,STATUS FROM VIDEOCARD WHERE DSLAM_ID=?");
			pst.setString(1, dslamid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				VideoCard vc=new VideoCard();
			    vc.setVIDEO_CARD_ID(rs.getString("VIDEO_PORT_ID"));
			    vc.setSTATUS(rs.getString("STATUS"));
				videocardlist.add(vc);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem with video card dao " + e.getMessage());
		}
		return videocardlist;
	}
}
