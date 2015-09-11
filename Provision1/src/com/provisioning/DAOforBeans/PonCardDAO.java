package com.provisioning.DAOforBeans;
import java.sql.*;
import java.util.ArrayList;

import com.provisioning.connectionpool.DataSource;
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
	public String getDSLAM()
	{
		Connection con=null;
		String dslamid=null;
		String JsonStr="\"dslam\" : [";
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("select distinct dslam_id from pon");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				dslamid=rs.getString("dslam_id");
				JsonStr+="{\"dslam_id\":\""+dslamid+"\"},";				
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

	public String getPonIds()
	{
		Connection con=null;
		String ponid=null,dslamid=null;
		String JsonStr="\"pon_detail\":[";
		try
		{
			con=DataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("select pon_id,dslam_id from pon");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ponid=rs.getString("pon_id");
				dslamid=rs.getString("dslam_id");
				JsonStr+="{\"dslam_id\":\""+dslamid+"\",\"pon_id\":\""+ponid+"\"},";				
			}
			int len=JsonStr.length();
			JsonStr=JsonStr.substring(0, len-1);
			JsonStr+="]}";
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

}


//package com.provisioning.DAOforBeans;
//import java.sql.*;
//import java.util.ArrayList;
//
//import com.provisioning.javabeans.PonCard;
//import com.provisioning.javabeans.PonPort;
//
//public class PonCardDAO {
//	ArrayList<PonCard> poncardlist;
//	public PonCardDAO()
//	{
//		poncardlist=new ArrayList<PonCard>();
//	}
//	public ArrayList<PonCard> createPonCards(Connection con,String dslamid)
//	{
//		
//		try
//		{
//			PreparedStatement pst=con.prepareStatement("SELECT PON_ID FROM PON WHERE DSLAM_ID=?");
//			pst.setString(1, dslamid);
//			ResultSet rs=pst.executeQuery();
//			while(rs.next())
//			{
//				PonCard pc=new PonCard();
//				String poncardid=rs.getString("PON_ID");
//				PreparedStatement pst1=con.prepareStatement("SELECT PON_PORT_ID,STATUS FROM PONPORT WHERE PON_ID=?");
//				pst1.setString(1, poncardid);
//				ResultSet rs1=pst1.executeQuery();
//				PonPort [] ponportarray=new PonPort[2];
//				
//				int i=0;
//				for(i=0;i<2;i++)
//					ponportarray[i]=new PonPort();
//				i=0;
//				while(rs1.next())
//				{
//					ponportarray[i].setPON_PORT_ID(rs1.getString("PON_PORT_ID"));
//					ponportarray[i].setSTATUS(rs1.getString("STATUS"));
//					i++;
//				}
//				pc.setPON_CARD_ID(poncardid);
//				pc.setPonport(ponportarray);
//				poncardlist.add(pc);
//			}
//		}
//		catch(SQLException e)
//		{
//			System.out.println("Problem with poncard dao " + e.getMessage());
//		}
//		return poncardlist;
//	}
//
//}
