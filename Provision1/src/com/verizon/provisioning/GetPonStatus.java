package com.verizon.provisioning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.provisioning.DAOforBeans.PonPortDAO;

/**
 * Servlet implementation class GetPonStatus
 */
@WebServlet("/GetPonStatus")
public class GetPonStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPonStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pon= request.getParameter("pon");
		System.out.println( "pon " + pon);
		PonPortDAO ppd=new PonPortDAO();
	     String pp=ppd.getPonIds(pon);
	     System.out.println(pp);
		//String jSonStr="{\"pon_port\" :[{\"name\":\"pon_port\",\"id\":\"123\",\"status\":\"running\"},{\"name\":\"pon_port\",\"id\":\"103\",\"status\":\"down\"},{\"name\":\"pon_port\",\"id\":\"120\",\"status\":\"running\"},{\"name\":\"pon_port\",\"id\":\"128\",\"status\":\"running\"}]}";
	    PrintWriter out=response.getWriter();
	    out.println(pp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
