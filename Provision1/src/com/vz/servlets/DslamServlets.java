package com.vz.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.provisioning.DAOforBeans.WirelessDAO;
import com.provisioning.javabeans.DSLAM;
import com.provisioning.javabeans.PonCard;
import com.provisioning.javabeans.PonPort;
import com.provisioning.javabeans.VESCard;
import com.provisioning.javabeans.VideoCard;
import com.provisioning.javabeans.VoiceCard;
import com.provisioning.javabeans.VoicePort;
import com.provisioning.javabeans.WirelessCard;





@WebServlet("/DslamServlets")
public class DslamServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DslamServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String dId=request.getParameter("s");

		System.out.println("value is"+dId);

		String dslamId=DisplayDAO.getDslamId(dId);	
		
		
		HttpSession session=request.getSession();
		session.setAttribute("dname", dslamId);
		
	
	
		DSLAM dslam1=new DSLAM();
		
		dslam1=DisplayDAO.getDslamObj(dslamId);
		System.out.println("dslam1 val:"+dslam1);
		
		//DslamConnection dslamConnection=new DslamConnection();
		
	
		//do the connection and get the use that dslam object with the id (d+val)
		
		session.setAttribute("dslamNew",dslam1);
		System.out.println("From dslam"+session.getAttribute("dslamNew"));
		
		
		WirelessDAO wd=new WirelessDAO();
		
		//get the map of Activated ports
		
		
		
		int iActivated=0;
		HashMap hmActivated=new HashMap();

		ArrayList<PonCard> pc=dslam1.getPoncard();
		for(PonCard p:pc)
		{
			PonPort [] pp=p.getPonport();
			String statusPort=pp[0].getSTATUS();
			String statusPort1=pp[1].getSTATUS();
			if(statusPort.equals("ACTIVATED"))
				hmActivated.put(iActivated,pp[0].getPON_PORT_ID());
			iActivated++;
			if(statusPort1.equals("ACTIVATED"))
				hmActivated.put(iActivated,pp[1].getPON_PORT_ID());
			iActivated++;
		}
		ArrayList<VoiceCard> vc=dslam1.getVoice();
		for (VoiceCard voiceCard : vc) {
			
			VoicePort[] voicePort=voiceCard.getVoiceport();

			String statusPort1=voicePort[0].getSTATUS();
			String statusPort2=voicePort[1].getSTATUS();
			String statusPort3=voicePort[2].getSTATUS();
			String statusPort4=voicePort[3].getSTATUS();
			if(statusPort1.equals("ACTIVATED"))
				hmActivated.put(iActivated,voicePort[0].getVOICE_PORT_ID());
				iActivated++;
			if(statusPort2.equals("ACTIVATED"))
				hmActivated.put(iActivated,voicePort[1].getVOICE_PORT_ID());
				iActivated++;
			if(statusPort3.equals("ACTIVATED"))
				hmActivated.put(iActivated,voicePort[2].getVOICE_PORT_ID());
				iActivated++;
			if(statusPort4.equals("ACTIVATED"))
				hmActivated.put(iActivated,voicePort[3].getVOICE_PORT_ID());
				iActivated++;
		}
		ArrayList<VideoCard> vvc=dslam1.getVideo();
		for (VideoCard videoCard : vvc) {
			
			if(videoCard.getSTATUS().equals("ACTIVATED"))
			{
				hmActivated.put(iActivated, videoCard.getVIDEO_CARD_ID());
				iActivated++;
			}
			
		}
		ArrayList<VESCard> vesCard=dslam1.getVes();
		for (VESCard vesCard2 : vesCard) {
			
			if(vesCard2.getSTATUS().equals("ACTIVATED"))
			{
				hmActivated.put(iActivated, vesCard2.getVES_CARD_ID());
				iActivated++;
			}
			
			
		}
		
		ArrayList<WirelessCard> wirelessCards=dslam1.getWc();
		for (WirelessCard wirelessCard : wirelessCards) {
			if(wirelessCard.getSTATUS().equals("ACTIVATED"))
			{
				hmActivated.put(iActivated, wirelessCard.getWIRELESS_ID());
				iActivated++;
			}
			
		}
		
		
		
		//hmActivated=DisplayDAO.getAllActivated(dslamId);
		
		
		session.setAttribute("hmActivated", hmActivated);
		
		
		//get the map of defected ports
		
		
		
		//get the map of assigned ports
		
		HashMap hmAssigned=new HashMap();
		
		
		int iAssigned=0;

		
		ArrayList<PonCard> pc1=dslam1.getPoncard();
		for(PonCard p:pc1)
		{
			PonPort [] pp=p.getPonport();
			String statusPort=pp[0].getSTATUS();
			String statusPort1=pp[1].getSTATUS();
			if(statusPort.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,pp[0].getPON_PORT_ID());
				iAssigned++;
			if(statusPort1.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,pp[1].getPON_PORT_ID());
				iAssigned++;
		}
		ArrayList<VoiceCard> vc1=dslam1.getVoice();
		for (VoiceCard voiceCard : vc1) {
			
			VoicePort[] voicePort=voiceCard.getVoiceport();

			String statusPort1=voicePort[0].getSTATUS();
			String statusPort2=voicePort[1].getSTATUS();
			String statusPort3=voicePort[2].getSTATUS();
			String statusPort4=voicePort[3].getSTATUS();
			if(statusPort1.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,voicePort[0].getVOICE_PORT_ID());
				iAssigned++;
			if(statusPort2.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,voicePort[1].getVOICE_PORT_ID());
				iAssigned++;
			if(statusPort3.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,voicePort[2].getVOICE_PORT_ID());
				iAssigned++;
			if(statusPort4.equals("ASSIGNED"))
				hmAssigned.put(iAssigned,voicePort[3].getVOICE_PORT_ID());
				iAssigned++;
		}
		ArrayList<VideoCard> vvc1=dslam1.getVideo();
		for (VideoCard videoCard : vvc1) {
			
			if(videoCard.getSTATUS().equals("ASSIGNED"))
			{
				hmAssigned.put(iAssigned, videoCard.getVIDEO_CARD_ID());
				iAssigned++;
			}
			
		}
		ArrayList<VESCard> vesCard1=dslam1.getVes();
		for (VESCard vesCard2 : vesCard1) {
			
			if(vesCard2.getSTATUS().equals("ASSIGNED"))
			{
				hmAssigned.put(iAssigned, vesCard2.getVES_CARD_ID());
				iAssigned++;
			}
			
			
		}
		
		ArrayList<WirelessCard> wirelessCards1=dslam1.getWc();
		for (WirelessCard wirelessCard : wirelessCards1) {
			if(wirelessCard.getSTATUS().equals("ASSIGNED"))
			{
				hmAssigned.put(iAssigned, wirelessCard.getWIRELESS_ID());
				iAssigned++;
			}
			
		}
		
		
		session.setAttribute("hmAssigned", hmAssigned);
		
		
		HashMap hmNotWorking=new HashMap();
		
		int iDefected=0;

		
		ArrayList<PonCard> pc2=dslam1.getPoncard();
		for(PonCard p:pc2)
		{
			PonPort [] pp=p.getPonport();
			String statusPort=pp[0].getSTATUS();
			String statusPort1=pp[1].getSTATUS();
			if(statusPort.equals("DEFECTED"))
				hmNotWorking.put(iDefected,pp[0].getPON_PORT_ID());
			iDefected++;
			if(statusPort1.equals("DEFECTED"))
				hmNotWorking.put(iDefected,pp[1].getPON_PORT_ID());
			iDefected++;
		}
		ArrayList<VoiceCard> vc2=dslam1.getVoice();
		for (VoiceCard voiceCard : vc2) {
			
			VoicePort[] voicePort=voiceCard.getVoiceport();

			String statusPort1=voicePort[0].getSTATUS();
			String statusPort2=voicePort[1].getSTATUS();
			String statusPort3=voicePort[2].getSTATUS();
			String statusPort4=voicePort[3].getSTATUS();
			if(statusPort1.equals("DEFECTED"))
				hmNotWorking.put(iDefected,voicePort[0].getVOICE_PORT_ID());
			iDefected++;
			if(statusPort2.equals("DEFECTED"))
				hmNotWorking.put(iDefected,voicePort[1].getVOICE_PORT_ID());
			iDefected++;
			if(statusPort3.equals("DEFECTED"))
				hmNotWorking.put(iDefected,voicePort[2].getVOICE_PORT_ID());
			iDefected++;
			if(statusPort4.equals("DEFECTED"))
				hmNotWorking.put(iDefected,voicePort[3].getVOICE_PORT_ID());
			iDefected++;
		}
		ArrayList<VideoCard> vvc2=dslam1.getVideo();
		for (VideoCard videoCard : vvc2) {
			
			if(videoCard.getSTATUS().equals("DEFECTED"))
			{
				hmNotWorking.put(iDefected, videoCard.getVIDEO_CARD_ID());
				iDefected++;
			}
			
		}
		
		ArrayList<VESCard> vesCard3=dslam1.getVes();
		for (VESCard vesCard2 : vesCard3) {
			
			if(vesCard2.getSTATUS().equals("DEFECTED"))
			{
				hmNotWorking.put(iDefected, vesCard2.getVES_CARD_ID());
				iDefected++;
			}
			
			
		}
		
		ArrayList<WirelessCard> wirelessCards2=dslam1.getWc();
		for (WirelessCard wirelessCard : wirelessCards2) {
			if(wirelessCard.getSTATUS().equals("DEFECTED"))
			{
				hmNotWorking.put(iDefected, wirelessCard.getWIRELESS_ID());
				iDefected++;
			}
			
		}
		
		
		
		
		session.setAttribute("hmNotWorking", hmNotWorking);
	    
	 
	 
		response.sendRedirect("viewjsp.jsp");
		
		
		
		
	}

}
