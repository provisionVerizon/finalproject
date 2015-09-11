package com.verizon.provisioning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.provisioning.DAOforBeans.ONTDAO;
import com.provisioning.DAOforBeans.PonCardDAO;

/**
 * Servlet implementation class GetDslamDetails
 */
@WebServlet("/GetDslamDetails")
public class GetDslamDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDslamDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ONTDAO ont=new ONTDAO();
		String ss2=ont.getONT();
		PonCardDAO poncard=new PonCardDAO();
		ss2+=poncard.getDSLAM();
		ss2+=poncard.getPonIds();
		//String ss="{\"ont\": [{\"ont_id\":\"123\"},{\"ont_id\":\"1245\"},{\"ont_id\":\"122\"}],\"dslam\" : [{\"dslam_id\":\"12344\"},{\"dslam_id\":\"12323\"}],\"pon_detail\":[{\"dslam_id\":\"12344\",\"pon_id\":\"134\"},{\"dslam_id\":\"12344\",\"pon_id\":\"343\"},{\"dslam_id\":\"12344\",\"pon_id\":\"323\"},{\"dslam_id\":\"12323\",\"pon_id\":\"77\"}] }";
		System.out.println(ss2);
		out.println(ss2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
