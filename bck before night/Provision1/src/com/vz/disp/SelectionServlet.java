package com.vz.disp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.provisioning.DAOforBeans.ONTDAO;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/SelectionServlet")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("asdfgh");
    	String val=request.getParameter("i");
    	
    	HttpSession session=request.getSession();
    	
    	
    	System.out.println(val);
    	ONTDAO od=new ONTDAO();
    	String result=od.getDetailsCustomer(val);
    	
    	if(result==null)
    	{
    		session.setAttribute("Customer", val);
    	}
    	else
    	{
    		
    
    	//get the customerid from from pon port id
    	
    	session.setAttribute("Customer", result);
    	}
    	
    
    	response.sendRedirect("dslam_display.jsp");
    			
    			
    		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
