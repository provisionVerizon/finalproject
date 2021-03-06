package com.verizon.provisioning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.provisioning.DAOforBeans.CustomerDAO;
import com.provisioning.DAOforBeans.VESCustomerDAO;
import com.provisioning.DAOforBeans.WirelessCustomerDAO;
import com.provisioning.javabeans.Customer;
import com.provisioning.javabeans.VESCard;
import com.provisioning.javabeans.WirelessCard;

/**
 * Servlet implementation class GetPonDetails
 */
@WebServlet("/GetPonDetails")
public class GetPonDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPonDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		System.out.println( "name " + name);
		CustomerDAO cDAo=new CustomerDAO();
		Customer customer=cDAo.getCustomerDetails(Integer.parseInt(name));
		WirelessCustomerDAO WdAO= new WirelessCustomerDAO();
		WirelessCard wirelessCard=WdAO.getWSSCard(Integer.parseInt(name));
		VESCustomerDAO vDao=new VESCustomerDAO();
		VESCard vesCard=vDao.getVESCard(Integer.parseInt(name));
		String voice="yes";
		if(customer.getVp().getVOICE_PORT_ID()==null)
			voice="no";
		String video="yes";
		if(customer.getVc().getVIDEO_CARD_ID()==null)
			video="no";
		String wireless_id,wireless_status;
		if(customer.getWc()==null)
		{
			wireless_id="-1";
			wireless_status="down";
		}
		else
		{
			wireless_id=wirelessCard.getWIRELESS_ID();
			wireless_status=wirelessCard.getSTATUS();
		}
		String ves_id,ves_status;
		if(customer.getVesc() ==null)
		{
			ves_id="-1";
			ves_status="down";
		}
		else
		{
			ves_id=vesCard.getVES_CARD_ID();
			ves_status=vesCard.getSTATUS();
		}
		
		PrintWriter out = response.getWriter();
		String ss = "{\"cust_id\":\""+customer.getCUSTOMER_ID()+"\", \"type\":\""+customer.getTYPE()+"\",\"first_name\":\""+customer.getFIRST_NAME()+"\",\"last_name\":\""+customer.getLAST_NAME()+"\",\"address_line1\":\""+customer.getSTREETNAME()+"\",\"city\":\""+customer.getCITY()+"\",\"stateid\":\""+customer.getSTATE_ID()+"\",\"country\":\""+customer.getCOUNTRY()+"\",\"voice\":\""+voice+"\",\"data\":\"yes\",\"video\":\""+video+"\",\"ves_card_id\":\""+ves_id+"\",\"dslam_id\":\""+' '+"\",\"pon_id\":\""+' '+"\",\"pon_port_id\":\""+customer.getPp().getPON_PORT_ID()+"\",\"data_card_id\":\""+customer.getDc().getDATACARD_ID()+"\",\"voice_card_id\":\""+customer.getVp().getVOICE_PORT_ID()+"\",\"video_card_id\":\""+customer.getVc().getVIDEO_CARD_ID()+"\",\"wireless_card_id\":\""+wireless_id+"\",\"ont_id\":\""+customer.getOnt().getONT_ID()+"\",\"pon_port_status\":\""+customer.getPp().getSTATUS()+"\",\"data_port_status\":\""+customer.getDc().getSTATUS()+"\",\"voice_card_status\":\""+customer.getVp().getSTATUS()+"\",\"video_card_status\":\""+customer.getVc().getSTATUS()+"\",\"ont_status\":\""+customer.getOnt().getSTATUS()+"\",\"ves_card_status\":\""+ves_status+"\",\"wireless_card_status\":\""+wireless_status+"\"}";
		System.out.println(ss);
	    out.println(ss);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
