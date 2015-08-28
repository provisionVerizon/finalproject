package com.verizon.provisioning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetOrderDetailsServlet
 */
@WebServlet("/GetOrderDetailsServlet")
public class GetOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String cust_id= request.getParameter("date_val");
		PrintWriter out=response.getWriter();
		System.out.println(cust_id);
		//System.out.println(circuit_id);
		if(cust_id.equals("2015-08-28"))
		{String ss=" {\"order\":[{\"lineofbusiness\": \"cmb\",\"customerdetails\": {\"customerid\": 1234567,\"customername\": \"Suresh Siddharth\",\"customertype\": \"new\",\"connectionaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",\"stateid\": 20,\"country\": \"india\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 1234567,\"dateofbooking\": \"28-aug-2015\",\"duedate\": \"28-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"pip\",\"mdn\": [7890222200],\"quantity\": 20}],\"products\":[{\"productcode\": \"VZ1234\",\"productname\": \"Set Top Box\"}]}},{\"lineofbusiness\": \"wireless\",\"customerdetails\": {\"customerid\": 34,\"customername\": \"g\",\"customertype\": \"wireless\",\"connectionaddress\": {\"streetname\": \"jh\",\"zipcode\": 34,\"city\": \"jjk\",\"state\": \";l\",\"stateid\": 23,\"country\": \"gh\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 9999,\"dateofbooking\": \"18-aug-2015\",\"duedate\": \"28-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"demo\",\"mdn\":9850000120,\"quantity\": 4}],\"products\":[{\"productcode\": \"VZ2234\",\"productname\": \"Product 2\"}]}}]}";
		//String ss = "{\"cust_id\":\""+customer.getCUSTOMER_ID()+"\", \"type\":\""+customer.getTYPE()+"\",\"first_name\":\""+customer.getFIRST_NAME()+"\",\"last_name\":\""+customer.getLAST_NAME()+"\",\"address_line1\":\""+customer.getSTREETNAME()+"\",\"city\":\""+customer.getCITY()+"\",\"stateid\":\""+customer.getSTATE_ID()+"\",\"country\":\""+customer.getCOUNTRY()+"\",\"voice\":\""+voice+"\",\"data\":\"yes\",\"video\":\""+video+"\",\"ves_card_id\":\""+ves_id+"\",\"dslam_id\":\""+dslam_id+"\",\"pon_id\":\""+pon_id+"\",\"pon_port_id\":\""+customer.getPp().getPON_PORT_ID()+"\",\"data_card_id\":\""+customer.getDc().getDATACARD_ID()+"\",\"voice_card_id\":\""+customer.getVp().getVOICE_PORT_ID()+"\",\"video_card_id\":\""+customer.getVc().getVIDEO_CARD_ID()+"\",\"wireless_card_id\":\""+wireless_id+"\",\"ont_id\":\""+customer.getOnt().getONT_ID()+"\",\"pon_port_status\":\""+customer.getPp().getSTATUS()+"\",\"data_port_status\":\""+customer.getDc().getSTATUS()+"\",\"voice_card_status\":\""+customer.getVp().getSTATUS()+"\",\"video_card_status\":\""+customer.getVc().getSTATUS()+"\",\"ont_status\":\""+customer.getOnt().getSTATUS()+"\",\"ves_card_status\":\""+ves_status+"\",\"wireless_card_status\":\""+wireless_status+"\"}";
	    out.println(ss);
	    System.out.println(ss);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
