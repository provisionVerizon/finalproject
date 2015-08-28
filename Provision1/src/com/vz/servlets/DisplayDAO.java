package com.vz.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.provisioning.DAOforBeans.DSLAMDAO;
import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.DSLAM;

public class DisplayDAO {
	
	
	public static String getDslamId(String id)
	{
		HashMap hm=new HashMap();
		
		String id1=id;
		hm.put("stateid", id);
		
		System.out.println("hm val is "+hm);
	
		
		DSLAMDAO dd=new DSLAMDAO();
		String x=dd.getRequiredDslam(hm);
		
		DSLAM d=new DSLAM();
		d=dd.createRequiredDslam(x);
		
		
		return x;
		
		
	}
	
	
	public static DSLAM getDslamObj(String dname)
	{
		DSLAMDAO dd=new DSLAMDAO();
		DSLAM d=new DSLAM();
		d=dd.createRequiredDslam(dname);
		
		
		System.out.println(d.getMAX_VOICE_CARD_CAPACITY());
		System.out.println(d.getMAX_PON_CARD_CAPACITY());
		System.out.println(d.getMAX_VIDEO_CARD_CAPACITY());
	    System.out.println(d.getMAX_WIRELESS_CARD_CAPACITY());
		System.out.println(d.getMAX_DATA_BUFFER());
		
		
		
		return d;
	}

	
	
	/*public static void main(String[] args) {
		String id="8";
		
		System.out.println(DisplayDAO.getDslamId(id));
		DSLAM dd=new DSLAM();
		
		dd=getDslamObj(DisplayDAO.getDslamId(id));
		DisplayDAO.getAllActivated(DisplayDAO.getDslamId(id));
		
		
	}*/
	
	
}
