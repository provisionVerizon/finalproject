package com.provisioning.DAOforBeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;

import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.DSLAM;

public class DSLAMDAOnew {
int datacap=5;
		Boolean shelfStatus[]=new Boolean[6];
		Connection con;
		HashMap<String, String> servicesMap;
		public DSLAMDAOnew()
		{
			for(int i=0;i<6;i++)
				shelfStatus[i]=false;
			servicesMap=new HashMap<String, String>();
			initializeConnection();
			initializeServiceMap();
		}
		private void initializeConnection()
		{
			try{
			con=DataSource.getConnection();
			}
			catch(ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		private void initializeServiceMap()
		{
			//cmb services
			servicesMap.put("Fios Internet 25mbps", "data");
			servicesMap.put("Fios Internet 50mbps", "data");
			servicesMap.put("Fios Internet 25+Fios Basic TV", "video and data");
			servicesMap.put("Fios Internet 50+Fios Basic TV ","video and data");
			servicesMap.put("Fios Internet 25+Fios TV Preffered HD", "video and data");
			servicesMap.put("Fios Internet 50+Fios TV Preffered HD", "video and data");
			servicesMap.put("Fios Internet25+FiosTV customTV", "video and data");
			servicesMap.put("Fios Internet50+ FiosTV customTV", "video and data");
			servicesMap.put("Fios Internet 25+Fios Basic TV+Fios DigitalVoice", "voice and video and data");
			servicesMap.put("Fios Internet 50+Fios Basic TV+Fios DigitalVoice", "voice and video and data");
			//ves srvices
			servicesMap.put("AP_3G_150_Vo_150", "ves");
			servicesMap.put("AP_4G_200_Vi_200", "ves");
			servicesMap.put("PI_VoVi_200_200_125", "ves");
			servicesMap.put("PI_Vi_150_250_175", "ves");
			servicesMap.put("AI_3G_200_150_75", "ves");
			servicesMap.put("AI_4G_250_200_125", "ves");
			servicesMap.put("API_4G_200_Vi_150_200_125", "ves");
			servicesMap.put("API_4GLte_250_VoVi_250_200_125", "ves");
			servicesMap.put("Access_3G_200", "ves");
			servicesMap.put("Access_4G_300", "ves");
			servicesMap.put("Access_4GLTE_300", "ves");
			servicesMap.put("Access_4G_250", "ves");
			servicesMap.put("Access_4GLTE_250", "ves");
			servicesMap.put("Voice_200", "ves");
			servicesMap.put("Videeo_200", "ves");
			servicesMap.put("Video_250", "ves");
			servicesMap.put("Voice_Video_250", "ves");
			servicesMap.put("Voice_Video_300", "ves");
			servicesMap.put("ID_200_125", "ves");
			servicesMap.put("ID_200_175", "ves");
			servicesMap.put("ID__250_225", "ves");
			servicesMap.put("ID__300_225", "ves");
			servicesMap.put("ID__300_275", "ves");
			//wireless services
			servicesMap.put("1GB per 2C", "wireless");
			servicesMap.put("2GB per 2C", "wireless");
			servicesMap.put("3GB per 2C", "wireless");
			servicesMap.put("4GB per 2C", "wireless");
			servicesMap.put("3GB per 3C", "wireless");
			servicesMap.put("4GB per 3C", "wireless");
			servicesMap.put("6GB per 3C", "wireless");
			servicesMap.put("6GB per 4C", "wireless");
			servicesMap.put("Iphone 5_1GB_30$", "wireless");
			servicesMap.put("Iphone6_3GB_45$", "wireless");
			servicesMap.put("Iphone6_6GB_60$", "wireless");
			servicesMap.put("SamsungGalaxy_S6_3GB/45$", "wireless");
			servicesMap.put("SamsungGalaxy_S6_6GB/60$", "wireless");
			servicesMap.put("Iphone6_12GB_80$", "wireless");
			servicesMap.put("Iphone5_6GB-60$", "wireless");
			servicesMap.put("SamsungGalaxy6", "wireless");
			servicesMap.put("1GB per 30$", "wireless");
			servicesMap.put("3GB per45$", "wireless");
			servicesMap.put("6GBper60$", "wireless");
		}
		public DSLAM createRequiredDslam(String dslamid)
		{
			DSLAM dslambean=new DSLAM();
			PonCardDAO poncard=new PonCardDAO();
			DataCardDAO datacard=new DataCardDAO();
			VoiceCardDAO voicecard=new VoiceCardDAO();
			VideoCardDAO videocard=new VideoCardDAO();
			VESCardDAO cardDAO=new VESCardDAO();
			dslambean.setVes(cardDAO.createVesCards(con, dslamid));
			WirelessDAO dao=new WirelessDAO();
			dslambean.setWc(dao.createWirelessCards(con, dslamid));
			dslambean.setDSLAM_ID(dslamid);
			dslambean.setVoice(voicecard.createVoiceCards(con, dslamid));
			dslambean.setVideo(videocard.createVideoeCards(con, dslamid));
			dslambean.setDc(datacard.createDataCard(con, dslamid));
			dslambean.setPoncard(poncard.createPonCards(con, dslamid));
			return dslambean;
		}
		
		public DSLAM createRequiredDslam(HashMap<String,String> mydslam)
		{
			DSLAM dslambean=new DSLAM();
			PonCardDAO poncard=new PonCardDAO();
			DataCardDAO datacard=new DataCardDAO();
			VoiceCardDAO voicecard=new VoiceCardDAO();
			VideoCardDAO videocard=new VideoCardDAO();
			String dslamid=getRequiredDslam(mydslam);
			dslambean.setDSLAM_ID(dslamid);
			dslambean.setVoice(voicecard.createVoiceCards(con, dslamid));
			dslambean.setVideo(videocard.createVideoeCards(con, dslamid));
			dslambean.setDc(datacard.createDataCard(con, dslamid));
			dslambean.setPoncard(poncard.createPonCards(con, dslamid));
			dslambean.setShelfStatus(getDslamShelfStatus(mydslam));
			return dslambean;
		}
		public String getRequiredDslam(HashMap<String,String> mpdslam)
		{
			//System.out.println(con);
			int stateid=Integer.parseInt(mpdslam.get("stateid"));
			String dslamid=null;
			try
			{
				PreparedStatement pst=con.prepareStatement("SELECT DSLAM_ID FROM DSLAM WHERE START_STATE_ID<=? AND END_STATE_ID >=?");
				pst.setInt(1, stateid);
				pst.setInt(2,stateid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
				dslamid=rs.getString("DSLAM_ID");
				}
				rs.close();
				pst.close();
			}
			catch(SQLException e)
			{
				
			}
			return dslamid;
		}
		public Boolean[] getDslamShelfStatus(HashMap<String,String> mapdslam)
		{
			for(int i=0;i<6;i++)
				shelfStatus[i]=false;
			System.out.println(mapdslam.get("lob"));
			if(mapdslam.get("lob").equals("wireless"))
				{
				shelfStatus[0]=true;
			
				}
			else if(mapdslam.get("lob").equals("ves"))
				shelfStatus[1]=true;
			else
			{
			
				String servicename=servicesMap.get(mapdslam.get("servicename"));
				shelfStatus[5]=true;
				switch(servicename)
				{
					case "data":  shelfStatus[4]=true;break;
					case "voice and video": shelfStatus[2]=true;shelfStatus[3]=true;break;
					case "voice and data": shelfStatus[2]=true;shelfStatus[4]=true;break;
					case "video and data": shelfStatus[3]=true;shelfStatus[4]=true;break;
					case "voice and video and data": shelfStatus[2]=true;shelfStatus[3]=true;shelfStatus[4]=true;break;
				}
			}
			return shelfStatus;
		}
		
		public void assignVesCard(int customerid,String dslamid)
		{
		//	String dslamid=getRequiredDslam(h);
			try {
				PreparedStatement pst=con.prepareStatement("SELECT ves_card_id from vescard where dslam_id='"+dslamid+"'and status='AVAILABLE'");
			ResultSet rs=pst.executeQuery();
			System.out.println("rsexec");
			while(rs.next())
		{
				System.out.println("in rs"+rs.getString("ves_card_id"));
				pst=con.prepareStatement("update vescard set CUSTOMER_ID="+customerid+" where ves_card_id='"+rs.getString("ves_card_id")+"'");			
		System.out.println("aftr");

		int y=pst.executeUpdate();
		System.out.println("aftr2");
		pst=con.prepareStatement("update vescard set status='ASSIGNED' where ves_card_id='"+rs.getString("ves_card_id")+"'");
		y=pst.executeUpdate();
		System.out.println("aftr3");
		break;
		}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				}
		}
		
		public void assignWirelessCard(int customerid,String dslamid)
		{
			try {
				System.out.println("in try");
				PreparedStatement pst=con.prepareStatement("SELECT wireless_id from wireless where dslam_id='"+dslamid+"'and status='AVAILABLE'");
			System.out.println("pst");
				ResultSet rs=pst.executeQuery();
				System.out.println("afr");
			if(rs.next())
	{
				
				System.out.println("rs"+rs.getString("wireless_id"));
				pst=con.prepareStatement("update wireless set customer_id="+customerid+" where wireless_id='"+rs.getString("wireless_id")+"'");
	int y=pst.executeUpdate();
	//System.out.println("rf");
	pst=con.prepareStatement("update wireless set status='ASSIGNED' where wireless_id='"+rs.getString("wireless_id")+"'"); 
	y=pst.executeUpdate();
	//System.out.println("updated");
	}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public ArrayList<String> getPonPortAvailable(String dslamid)
		{
			ArrayList<String> availponports=new ArrayList<String>();
			try
			{
				String sql="SELECT PON_PORT_ID from PONPORT where STATUS='AVAILABLE' and PON_PORT_ID LIKE ?";
				PreparedStatement pst=con.prepareStatement(sql);
				String condition=dslamid+"%";
				System.out.println(condition);
				pst.setString(1, condition);
							
				ResultSet rs=pst.executeQuery();
				while(rs.next())
					availponports.add(rs.getString("PON_PORT_ID"));
			}
			catch(SQLException e)
			{
				System.out.println("problem with getPonPort" + e.getMessage());
			}
			return availponports;
		}
		public ArrayList<String> getVoicePortAvailable(String dslamid)
		{
			ArrayList<String> availvoiceports=new ArrayList<String>();
			try
			{
				String SQL="SELECT VOICE_PORT_ID from VOICECARDPORT where STATUS='AVAILABLE' and VOICE_PORT_ID LIKE ? ";
				PreparedStatement st=con.prepareStatement(SQL);
				st.setString(1, dslamid+"%");
				ResultSet rs=st.executeQuery();
				while(rs.next())
					availvoiceports.add(rs.getString("VOICE_PORT_ID"));
			}
			catch(SQLException e)
			{
				System.out.println("problem with getVoicePort" + e.getMessage());
			}
			return availvoiceports;
		}
		
		public ArrayList<String> getVideoCardAvailable(String dslamid)
		{
			ArrayList<String> availvideocard=new ArrayList<String>();
			try
			{
				String SQL="SELECT VIDEO_PORT_ID from VIDEOCARD where STATUS='AVAILABLE' and dslam_id=?";
				PreparedStatement st=con.prepareStatement(SQL);
				st.setString(1, dslamid);
				ResultSet rs=st.executeQuery();
				while(rs.next())
					availvideocard.add(rs.getString("VIDEO_PORT_ID"));
			}
			catch(SQLException e)
			{
				System.out.println("problem with getVideoCard" + e.getMessage()); 
			}
			return availvideocard;
		}
		
		public void assignCmbCard(int customerid,Boolean [] shelfStatus,String dslamid)
		{
			ArrayList<String> availponports=getPonPortAvailable(dslamid);
			ArrayList<String> availvoiceports=getVoicePortAvailable(dslamid);
			ArrayList<String> availvideocard=getVideoCardAvailable(dslamid);
			String ponportid=availponports.get(0);
			String voiceportid=availvoiceports.get(0);
			String videocardid=availvideocard.get(0);
			
			int currentDataAvailable=0;
			//
		//	System.out.println("in asscard");
			try
			{
				PreparedStatement pst=con.prepareStatement("select capacity from datacard where DSLAM_ID=?");
				pst.setString(1, dslamid);
				System.out.println("hi");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
					currentDataAvailable=rs.getInt("capacity");
				rs.close();
				pst.close();
				int finalvalue=currentDataAvailable-datacap;
				PreparedStatement pst1=con.prepareStatement("update datacard set capacity=? where dslam_id=?");
				pst1.setInt(1, finalvalue);
				pst1.setString(2, dslamid);
				pst1.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("execute update in data card" + e.getMessage());
			}
				
			try
			{
				System.out.println("in ponport");
				PreparedStatement pst=con.prepareStatement("update ponport set status='ASSIGNED' where pon_port_id=?");
				pst.setString(1, ponportid);
				pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("execute update in pon port card" + e.getMessage());
			}
			
				if(shelfStatus[2]==true)
					{
					System.out.println("shelf2");
							try
							{
								PreparedStatement pst=con.prepareStatement("update voicecardport set pon_port_id=?,status='ASSIGNED' where voice_port_id=? ");
								pst.setString(1,ponportid);
								pst.setString(2,voiceportid);
								pst.executeUpdate();
							} 
							catch(SQLException e)
							{
								System.out.println("problem with update voice card port" + e.getMessage());
							}
					}
				if(shelfStatus[3]==true)
					{
					     try
							{
								PreparedStatement pst=con.prepareStatement("update videocard set pon_port_id=?, status='ASSIGNED' where video_port_id=? ");
								pst.setString(1, ponportid);
								pst.setString(2, videocardid);
								pst.executeUpdate();
							}
							catch(SQLException e)
							{
								System.out.println("problem with update video card port" + e.getMessage());
							}
					     
					}
				/*else if(shelfStatus[2]==true && shelfStatus[3]==true)
				{
					try
					{
						PreparedStatement pst=con.prepareStatement("update voicecardport set pon_port_id='"+ponportid+"' and status='ASSIGNED' where voice_port_id='"+voiceportid+"' ");
						pst.executeUpdate();
					}
					catch(SQLException e)
					{
						System.out.println("problem with update voice card port in third else if " + e.getMessage());
					}
					try
					{
						PreparedStatement pst=con.prepareStatement("update videocard set pon_port_id='"+ponportid+"' and status='ASSIGNED' where video_port_id='"+videocardid+"' ");
						pst.executeUpdate();
					}
					catch(SQLException e)
					{
						System.out.println("problem with update voice card port in third else if" + e.getMessage());
					}
				}*/
				
			}
		
		public void disconnect(int customerid,int stateid) {
			Boolean [] shelfStatus=new Boolean[6];
			Statement st=null;ResultSet rs=null;PreparedStatement pst1=null;ResultSet rs1=null;
			HashMap<String , String> getdsalmstatus=new HashMap<String, String>();
			getdsalmstatus.put("stateid",Integer.toString(stateid) );
			String dslamid=getRequiredDslam(getdsalmstatus);
			try
		    {
				//System.out.println(con);
			//PreparedStatement pst=con.prepareStatement("select type from CUSTOMER where customer_id="+customerid);
				
			st=con.createStatement();
			rs=st.executeQuery("select type from CUSTOMER where customer_id="+customerid);
			
			//System.out.println("1"+rs.getString("TYPE"));
			while(rs.next())
			{
				System.out.println(rs.getString("type"));
				getdsalmstatus.put("lob", rs.getString("TYPE"));
			}
		    pst1=con.prepareStatement("select SERVICE_TYPE from SERVICES where customer_id=?");
			pst1.setInt(1,customerid);
			rs1=pst1.executeQuery();
			while(rs1.next())
			{
				getdsalmstatus.put("servicename",rs1.getString("SERVICE_TYPE"));
			}
			
		  }
		catch(SQLException e)
		 {
			System.out.println("in the assign ports " + e.getMessage());
		 }
			shelfStatus=getDslamShelfStatus(getdsalmstatus);
			
			for(int i=0;i<shelfStatus.length;i++)
			{
System.out.println(shelfStatus[i]+"i"+i);
			}
			if(shelfStatus[0]==true)
					{ 
						System.out.println("wireless disconnect");
						disconnectWireless(customerid);
					}
				else if(shelfStatus[1]==true)
					{
						System.out.println("ves disconnect");
						disconnectVES(customerid);
					}
				else
				{
					System.out.println("cmb dis");
					disconnectCMB(customerid);
					System.out.println("afr");
				}
			
			
			
		}
		public void assignPorts(int customerid,int stateid)
		{ 
			Boolean [] shelfStatus=new Boolean[6];
			Statement st=null;ResultSet rs=null;PreparedStatement pst1=null;ResultSet rs1=null;
			HashMap<String , String> getdsalmstatus=new HashMap<String, String>();
			getdsalmstatus.put("stateid",Integer.toString(stateid) );
			String dslamid=getRequiredDslam(getdsalmstatus);
			try
		    {
				//System.out.println(con);
			//PreparedStatement pst=con.prepareStatement("select type from CUSTOMER where customer_id="+customerid);
				
			st=con.createStatement();
			rs=st.executeQuery("select type from CUSTOMER where customer_id="+customerid);
			
			//System.out.println("1"+rs.getString("TYPE"));
			while(rs.next())
			{
				System.out.println(rs.getString("type"));
				getdsalmstatus.put("lob", rs.getString("TYPE"));
			}
		    pst1=con.prepareStatement("select SERVICE_TYPE from SERVICES where customer_id=?");
			pst1.setInt(1,customerid);
			rs1=pst1.executeQuery();
			while(rs1.next())
			{
				getdsalmstatus.put("servicename",rs1.getString("SERVICE_TYPE"));
			}
			
		  }
		catch(SQLException e)
		 {
			System.out.println("in the assign ports " + e.getMessage());
		 }
			shelfStatus=getDslamShelfStatus(getdsalmstatus);
			//for(int i=0;i<shelfStatus.length;i++)
			//{
				if(shelfStatus[0]==true)
					{ 
						System.out.println("wireless ok");
						assignWirelessCard(customerid,dslamid);
					}
				else if(shelfStatus[1]==true)
					{
						System.out.println("ves ok");
						assignVesCard(customerid,dslamid);
					}
				else
				{
					System.out.println("cmb ok");
					assignCmbCard(customerid,shelfStatus,dslamid);
					System.out.println("afr");
				}
			//}
		}
		
	
		public void disconnectCMB(int customerid)
		{
			
			try {
				PreparedStatement pst=con.prepareStatement("SELECT PON_PORT_ID FROM ONT WHERE CUSTOMER_ID="+customerid);
			ResultSet rs=pst.executeQuery();
			System.out.println("ponport retieved");
			if(rs.next())
			{
				String pp=rs.getString("PON_PORT_ID");
				pst=con.prepareStatement("UPDATE  PONPORT SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"+pp+"'");
				int u=pst.executeUpdate();
				
				pst=con.prepareStatement("SELECT CAPACITY FROM DATACARD WHERE PON_PORT_ID='"+pp+"'");
				ResultSet rs2=pst.executeQuery();
				System.out.println("datacard retieved");
				int finalval=rs2.getInt("capacity")+datacap;
				if(rs2.next())
					{
					pst=con.prepareStatement("UPDATE DATACARD SET CAPACITY="+finalval+"WHERE PON_PORT_ID='"+pp+"'" );
							int y=pst.executeUpdate();
					}
				/*pst=con.prepareStatement("SELECT VIDEO_PORT_ID FROM VIDEOCARD WHERE PON_PORT_ID='"+pp+"'");
			 //rs2=pst.executeQuery();
				if(rs2.next())
				{*/
				pst=con.prepareStatement("UPDATE VIDEOCARD  SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"+pp+"'");
						int y=pst.executeUpdate();
						pst=con.prepareStatement("UPDATE VIDEOCARD  SET PON_PORT_ID='' WHERE STATUS='AVAILABLE'");
						y=pst.executeUpdate();
						System.out.println("videocard updated");	
				/*}
			
			 pst=con.prepareStatement("SELECT VOICE_PORT_ID FROM VOICECARDPORT WHERE PON_PORT_ID='"+pp+"'");
			 rs2=pst.executeQuery();
				if(rs2.next())
				{*/
				pst=con.prepareStatement("UPDATE VOICECARDPORT  SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"+pp+"'");
						 y=pst.executeUpdate();
						 pst=con.prepareStatement("UPDATE VOICECARDPORT  SET PON_PORT_ID='' WHERE STATUS='AVAILABLE'");
						 y=pst.executeUpdate();
						 System.out.println("voicecard updated");
				}
			
				
	
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void disconnectWireless(int customerid)
		{
			PreparedStatement pst;
			try {
				pst = con.prepareStatement("UPDATE WIRELESS SET STATUS='AVAILABLE' WHERE CUSTOMER_ID="+customerid);
				int y=pst.executeUpdate();
				pst = con.prepareStatement("UPDATE WIRELESS SET CUSTOMER_ID='' WHERE STATUS='AVAILABLE'");
				y=pst.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void disconnectVES(int customerid)
		{
			PreparedStatement pst;
			try {
				pst = con.prepareStatement("UPDATE VESCARD SET STATUS='AVAILABLE' WHERE CUSTOMER_ID="+customerid);
				int y=pst.executeUpdate();
				pst = con.prepareStatement("UPDATE VESCARD SET CUSTOMER_ID='' WHERE STATUS='AVAILABLE'");
				 y=pst.executeUpdate();
			System.out.println("disconnected ves");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void main(String [] args)
		{
			DSLAMDAO dd=new DSLAMDAO();
		//dd.assignPorts(23,6);
			dd.disconnect(12,6);
				}

}
