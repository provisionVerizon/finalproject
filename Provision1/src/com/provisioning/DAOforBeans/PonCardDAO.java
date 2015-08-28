package com.provisioning.DAOforBeans;
import java.sql.*;
import java.util.ArrayList;

import com.provisioning.javabeans.PonCard;
import com.provisioning.javabeans.PonPort;

public class PonCardDAO {
	ArrayList<PonCard> poncardlist;
	public PonCardDAO()
	{
		poncardlist=new ArrayList<PonCard>();
	}
	public ArrayList<PonCard> createPonCards(Connection con,String dslamid)
	{
		
		try
		{
			PreparedStatement pst=con.prepareStatement("SELECT PON_ID FROM PON WHERE DSLAM_ID=?");
			pst.setString(1, dslamid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				PonCard pc=new PonCard();
				String poncardid=rs.getString("PON_ID");
				PreparedStatement pst1=con.prepareStatement("SELECT PON_PORT_ID,STATUS FROM PONPORT WHERE PON_ID=?");
				pst1.setString(1, poncardid);
				ResultSet rs1=pst1.executeQuery();
				PonPort [] ponportarray=new PonPort[2];
				
				int i=0;
				for(i=0;i<2;i++)
					ponportarray[i]=new PonPort();
				i=0;
				while(rs1.next())
				{
					ponportarray[i].setPON_PORT_ID(rs1.getString("PON_PORT_ID"));
					ponportarray[i].setSTATUS(rs1.getString("STATUS"));
					i++;
				}
				pc.setPON_CARD_ID(poncardid);
				pc.setPonport(ponportarray);
				poncardlist.add(pc);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem with poncard dao " + e.getMessage());
		}
		return poncardlist;
	}

}
