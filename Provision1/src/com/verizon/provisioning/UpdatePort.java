package com.verizon.provisioning;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.provisioning.DAOforBeans.ONTDAO;
import com.provisioning.DAOforBeans.PonPortDAO;

/**
 * Servlet implementation class UpdatePort
 */
@WebServlet("/UpdatePort")
public class UpdatePort extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		//System.out.println( "name " + name);
		int x=name.indexOf('_');
		int y=name.indexOf('*');
		
		String port= name.substring(0, x);
		String id=name.substring(x+1,y);
		String status=name.substring(y+1);
		//String id= request.getParameter("id");
		System.out.println( "a" +port+"b"+id+"c"+status);
		PonPortDAO pp=new PonPortDAO();
		ONTDAO ont=new ONTDAO();
		if(status.equals("enable"))
		{
			if(port.equals("ponport"))
			{
				pp.updatePonStatus(id, "running");
			}
			else
			{
				ont.updateOntStatus(id, "running");
			}
		}
		else
		{
			if(port.equals("ponport"))
			{
				pp.updatePonStatus(id, "not running");
			}
			else
			{
				ont.updateOntStatus(id, "not running");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
