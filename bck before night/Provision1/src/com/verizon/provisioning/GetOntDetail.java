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
 * Servlet implementation class GetOntDetail
 */
@WebServlet("/GetOntDetail")
public class GetOntDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOntDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	    String ss="{ \"ont_id\": \""+customer.getOnt().getONT_ID()+"\",  \"ont_port_status\": \""+customer.getOnt().getSTATUS()+"\"}";
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
