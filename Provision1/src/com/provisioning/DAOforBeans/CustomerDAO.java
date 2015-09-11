//package com.provisioning.DAOforBeans;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.provisioning.connectionpool.DataSource;
//import com.provisioning.javabeans.Customer;
//import com.provisioning.javabeans.DataCard;
//import com.provisioning.javabeans.ONT;
//import com.provisioning.javabeans.PonPort;
//import com.provisioning.javabeans.VideoCard;
//import com.provisioning.javabeans.VoicePort;
package com.provisioning.DAOforBeans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.Customer;
import com.provisioning.javabeans.DataCard;
import com.provisioning.javabeans.ONT;
import com.provisioning.javabeans.PonPort;
import com.provisioning.javabeans.VideoCard;
import com.provisioning.javabeans.VoicePort;
// CUSTOMER TABLE NEEDS UPDATION 
public class CustomerDAO {
	Customer c;
	ONT ont;
	VoicePort vp;
	VideoCard vc;
	DataCard dc;
	PonPort pp;
	Connection con;
	public CustomerDAO ()
	{
		c=new Customer();
		ont=new ONT();
		vp=new VoicePort();
		vc=new VideoCard();
		dc=new DataCard();
		pp=new PonPort();
		initializeConnection();
	}
	
	private void initializeConnection()
	{
		try{
		con=DataSource.getConnection();
		}
		catch(ClassNotFoundException e)
		{
			
		}
		catch (SQLException e) {
			
		}
	}
	//implement the wireless and ves module according to the customer type
	public Customer getCustomerDetails(int customerid)
	{
		System.out.println("i am here 1");
		try
		{
			PreparedStatement pst=con.prepareStatement("select CUSTOMER_ID,FIRST_NAME,LAST_NAME,TYPE,STREETNAME,ZIPCODE,CITY,STATE,COUNTRY,STATUS,STATE_ID from customer where CUSTOMER_ID=?");
			pst.setInt(1, customerid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				c.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
				c.setFIRST_NAME(rs.getString("FIRST_NAME"));
				c.setLAST_NAME(rs.getString("LAST_NAME"));
				c.setTYPE(rs.getString("TYPE"));
				c.setSTREETNAME(rs.getString("STREETNAME"));
				c.setZIPCODE(Integer.parseInt(rs.getString("ZIPCODE")));
				c.setCITY(rs.getString("CITY"));
				c.setSTATE(rs.getString("STATE"));
				c.setCOUNTRY(rs.getString("COUNTRY"));
				c.setSTATE_ID(rs.getInt("STATE_ID"));
				System.out.println("i am here 2");
			}
			
			pp=getRequiredPonPort(customerid);
			vp=getRequiredVoicePort(pp);
			vc=getRequiredVideoCard(pp);
			dc=getRequiredDataCard(pp);
			ont=getRequiredOnt(pp);
			c.setPp(pp);
			c.setVc(vc);
			c.setOnt(ont);
			c.setDc(dc);
			c.setVp(vp);
			c.setDslamId(getDslamId(pp));
			
		}
		catch(SQLException e)
		{
			
		}
		return c;
	}
	
	private String getDslamId(PonPort pp2) {
		String dslamid=null;
		String ponportid=pp2.getPON_PORT_ID();
		try
		{
			PreparedStatement pst=con.prepareStatement("SELECT DSLAM_ID FROM PON WHERE PON_ID=(SELECT PON_ID FROM PONPORT WHERE PON_PORT_ID=?)");
			pst.setString(1, ponportid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				dslamid=rs.getString(1);
		}
		catch(SQLException e)
		{
			System.out.println("i am here 5" + e.getMessage());
		}
		return dslamid;
	}

	private PonPort getRequiredPonPort(int customerid)
	{
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select PON_PORT_ID from ONT where CUSTOMER_ID=?");
			 pst.setInt(1, customerid);
			 ResultSet rs=pst.executeQuery();
			 while(rs.next())
			 {
				 PreparedStatement pst1=con.prepareStatement("select PON_PORT_ID,STATUS from PONPORT where PON_PORT_ID=?");
				 pst1.setString(1, rs.getString("PON_PORT_ID"));
				 ResultSet rs1=pst1.executeQuery();
				 if(rs1.next())
				 {
					 pp.setPON_PORT_ID(rs1.getString("PON_PORT_ID"));
					 pp.setSTATUS(rs1.getString("STATUS"));
				 }
				
			 }
		 }
		 catch(SQLException e)
		 {
			 System.out.println("i am here 4" + e.getMessage());
		 }
		return pp;
	}
	
	// if more than one voice port then we have to use a voice port array to implement the functionality
	private VoicePort getRequiredVoicePort(PonPort p)
	{
		String ponportid=p.getPON_PORT_ID();
		try
		{
			PreparedStatement pst=con.prepareStatement("select VOICE_PORT_ID,STATUS from voicecardport where PON_PORT_ID=?");
			pst.setString(1, ponportid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				vp.setVOICE_PORT_ID(rs.getString("VOICE_PORT_ID"));
				vp.setSTATUS(rs.getString("STATUS"));
			}
		}
		catch(SQLException e)
		{
			
		}
		vp.setPp(p);
		return vp;
	}
	 private ONT getRequiredOnt(PonPort p)
	 {
		 String ponportid=p.getPON_PORT_ID();
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select ONT_ID,STATUS from ONT where PON_PORT_ID=?");
			 pst.setString(1, ponportid);
			 ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					ont.setONT_ID(rs.getString("ONT_ID"));
					ont.setSTATUS(rs.getString("STATUS"));
				}
		 }
		 catch(SQLException e)
		 {
			 
		 }
		 ont.setPp(p);
		 return ont;
	 }
	 
	 private VideoCard getRequiredVideoCard(PonPort p)
	 {
		 String ponportid=p.getPON_PORT_ID();
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select VIDEO_PORT_ID,STATUS from VIDEOCARD where PON_PORT_ID=?");
			 pst.setString(1, ponportid);
			 ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					vc.setVIDEO_CARD_ID(rs.getString("VIDEO_PORT_ID"));
					vc.setSTATUS(rs.getString("STATUS"));
				}
		 }
		 catch(SQLException e)
		 {
			 
		 }
		 vc.setPp(p);
		 return vc;
	 }
	 
	 private DataCard getRequiredDataCard(PonPort p)
	 {
		 String ponportid=p.getPON_PORT_ID();
		 try
		 {
			 PreparedStatement pst=con.prepareStatement("select DATACARD_ID,CAPACITY,STATUS from DATACARD where PON_PORT_ID=?");
			 pst.setString(1, ponportid);
			 ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					dc.setDATACARD_ID(rs.getString("VIDEO_PORT_ID"));
					dc.setCAPACITY_ALLOCATED(rs.getInt("CAPACITY"));
					dc.setSTATUS(rs.getString("STATUS"));
				}
		 }
		 catch(SQLException e)
		 {
			 
		 }
		 dc.setPp(p);
		 return dc;
	 }
	 
	 public void fetchOrderDetails() {
			//System.out.println("json entered");
				String dd="", stat="";
				int f = 0;
				int cid=0, oid=0;
				ArrayList<String> stype = new ArrayList<String>();
				ArrayList<Integer> sid = new ArrayList<Integer>();
				ArrayList<Integer> pid = new ArrayList<Integer>();
				ArrayList<String> pname = new ArrayList<String>();
				ArrayList<Integer> quantity = new ArrayList<Integer>();
				try {
					// CallableStatement cst=con.prepareCall("{call duedate()}");
					// System.out.println(cst.execute();
					System.out.println("begin");
					PreparedStatement pst = con
							.prepareStatement("select order_id from orderprovision ");
					ResultSet rs = pst.executeQuery();
					System.out.println("getting order");
					while (rs.next()) {
						f = 1;
						pst = con
								.prepareStatement("select customer_id,due_date,stage from orderprovision where order_id in ?");
						pst.setInt(1, rs.getInt("order_id"));
						ResultSet rs2 = pst.executeQuery();
						if(rs2.next())
						{
						cid = rs2.getInt("customer_id");
						dd = rs2.getString("due_date");
						stat = rs2.getString("stage");
						oid = rs.getInt("order_id");
						pst = con
								.prepareStatement("select service_id,service_type From services where order_id in ?");
						pst.setInt(1, rs.getInt("order_id"));

						rs2 = pst.executeQuery();
					//	pst=con.prepareStatement("select )
						// it=0;
						while (rs2.next()) {
							stype.add(rs2.getString("service_type"));
							int tmp=rs2.getInt("service_id");
							sid.add(tmp);
							pst = con.prepareStatement("select product_id,product_name,QUANTITY from product where service_id in ?");
							pst.setInt(1, tmp);
							ResultSet rs3 = pst.executeQuery();
							while(rs3.next())
							{
							pname.add(rs3.getString("product_name"));
							pid.add(rs3.getInt("product_id"));
							quantity.add(rs3.getInt("QUANTITY"));
							}
						}
						System.out.println(cid+oid+stat+dd+stype+sid+quantity+pname+pid);
						}
						
						// String
						//jsonObj=JsonCreator(cid,oid,dd,stype,sid,quantity,pname,pid);
						
					}
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
}
//// CUSTOMER TABLE NEEDS UPDATION 
//public class CustomerDAO {
//	Customer c;
//	ONT ont;
//	VoicePort vp;
//	VideoCard vc;
//	DataCard dc;
//	PonPort pp;
//	Connection con;
//	public CustomerDAO ()
//	{
//		c=new Customer();
//		ont=new ONT();
//		vp=new VoicePort();
//		vc=new VideoCard();
//		dc=new DataCard();
//		pp=new PonPort();
//		initializeConnection();
//	}
//	
//	private void initializeConnection()
//	{
//		try{
//		con=DataSource.getConnection();
//		}
//		catch(ClassNotFoundException e)
//		{
//			
//		}
//		catch (SQLException e) {
//			
//		}
//	}
//	//implement the wireless and ves module according to the customer type
//	public Customer getCustomerDetails(int customerid)
//	{
//		System.out.println("i am here 1");
//		try
//		{
//			PreparedStatement pst=con.prepareStatement("select CUSTOMER_ID,FIRST_NAME,LAST_NAME,TYPE,STREETNAME,ZIPCODE,CITY,STATE,COUNTRY,STATUS,STATE_ID from customer where CUSTOMER_ID=?");
//			pst.setInt(1, customerid);
//			ResultSet rs=pst.executeQuery();
//			while(rs.next())
//			{
//				c.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
//				c.setFIRST_NAME(rs.getString("FIRST_NAME"));
//				c.setLAST_NAME(rs.getString("LAST_NAME"));
//				c.setTYPE(rs.getString("TYPE"));
//				c.setSTREETNAME(rs.getString("STREETNAME"));
//				c.setZIPCODE(Integer.parseInt(rs.getString("ZIPCODE")));
//				c.setCITY(rs.getString("CITY"));
//				c.setSTATE(rs.getString("STATE"));
//				c.setCOUNTRY(rs.getString("COUNTRY"));
//				c.setSTATE_ID(rs.getInt("STATE_ID"));
//				System.out.println("i am here 2");
//			}
//			
//			pp=getRequiredPonPort(customerid);
//			vp=getRequiredVoicePort(pp);
//			vc=getRequiredVideoCard(pp);
//			dc=getRequiredDataCard(pp);
//			ont=getRequiredOnt(pp);
//			c.setPp(pp);
//			c.setVc(vc);
//			c.setOnt(ont);
//			c.setDc(dc);
//			c.setVp(vp);
//			c.setDslamId(getDslamId(pp));
//			
//		}
//		catch(SQLException e)
//		{
//			
//		}
//		return c;
//	}
//	
//	private String getDslamId(PonPort pp2) {
//		String dslamid=null;
//		String ponportid=pp2.getPON_PORT_ID();
//		try
//		{
//			PreparedStatement pst=con.prepareStatement("SELECT DSLAM_ID FROM PON WHERE PON_ID=(SELECT PON_ID FROM PONPORT WHERE PON_PORT_ID=?)");
//			pst.setString(1, ponportid);
//			ResultSet rs=pst.executeQuery();
//			while(rs.next())
//				dslamid=rs.getString(1);
//		}
//		catch(SQLException e)
//		{
//			System.out.println("i am here 5" + e.getMessage());
//		}
//		return dslamid;
//	}
//
//	private PonPort getRequiredPonPort(int customerid)
//	{
//		 try
//		 {
//			 PreparedStatement pst=con.prepareStatement("select PON_PORT_ID from ONT where CUSTOMER_ID=?");
//			 pst.setInt(1, customerid);
//			 ResultSet rs=pst.executeQuery();
//			 while(rs.next())
//			 {
//				 PreparedStatement pst1=con.prepareStatement("select PON_PORT_ID,STATUS from PONPORT where PON_PORT_ID=?");
//				 pst1.setString(1, rs.getString("PON_PORT_ID"));
//				 ResultSet rs1=pst1.executeQuery();
//				 if(rs1.next())
//				 {
//					 pp.setPON_PORT_ID(rs1.getString("PON_PORT_ID"));
//					 pp.setSTATUS(rs1.getString("STATUS"));
//				 }
//				
//			 }
//		 }
//		 catch(SQLException e)
//		 {
//			 System.out.println("i am here 4" + e.getMessage());
//		 }
//		return pp;
//	}
//	
//	// if more than one voice port then we have to use a voice port array to implement the functionality
//	private VoicePort getRequiredVoicePort(PonPort p)
//	{
//		String ponportid=p.getPON_PORT_ID();
//		try
//		{
//			PreparedStatement pst=con.prepareStatement("select VOICE_PORT_ID,STATUS from voicecardport where PON_PORT_ID=?");
//			pst.setString(1, ponportid);
//			ResultSet rs=pst.executeQuery();
//			while(rs.next())
//			{
//				vp.setVOICE_PORT_ID(rs.getString("VOICE_PORT_ID"));
//				vp.setSTATUS(rs.getString("STATUS"));
//			}
//		}
//		catch(SQLException e)
//		{
//			
//		}
//		vp.setPp(p);
//		return vp;
//	}
//	 private ONT getRequiredOnt(PonPort p)
//	 {
//		 String ponportid=p.getPON_PORT_ID();
//		 try
//		 {
//			 PreparedStatement pst=con.prepareStatement("select ONT_ID,STATUS from ONT where PON_PORT_ID=?");
//			 pst.setString(1, ponportid);
//			 ResultSet rs=pst.executeQuery();
//				while(rs.next())
//				{
//					ont.setONT_ID(rs.getString("ONT_ID"));
//					ont.setSTATUS(rs.getString("STATUS"));
//				}
//		 }
//		 catch(SQLException e)
//		 {
//			 
//		 }
//		 ont.setPp(p);
//		 return ont;
//	 }
//	 
//	 private VideoCard getRequiredVideoCard(PonPort p)
//	 {
//		 String ponportid=p.getPON_PORT_ID();
//		 try
//		 {
//			 PreparedStatement pst=con.prepareStatement("select VIDEO_PORT_ID,STATUS from VIDEOCARD where PON_PORT_ID=?");
//			 pst.setString(1, ponportid);
//			 ResultSet rs=pst.executeQuery();
//				while(rs.next())
//				{
//					vc.setVIDEO_CARD_ID(rs.getString("VIDEO_PORT_ID"));
//					vc.setSTATUS(rs.getString("STATUS"));
//				}
//		 }
//		 catch(SQLException e)
//		 {
//			 
//		 }
//		 vc.setPp(p);
//		 return vc;
//	 }
//	 
//	 private DataCard getRequiredDataCard(PonPort p)
//	 {
//		 String ponportid=p.getPON_PORT_ID();
//		 try
//		 {
//			 PreparedStatement pst=con.prepareStatement("select DATACARD_ID,CAPACITY,STATUS from DATACARD where PON_PORT_ID=?");
//			 pst.setString(1, ponportid);
//			 ResultSet rs=pst.executeQuery();
//				while(rs.next())
//				{
//					dc.setDATACARD_ID(rs.getString("VIDEO_PORT_ID"));
//					dc.setCAPACITY_ALLOCATED(rs.getInt("CAPACITY"));
//					dc.setSTATUS(rs.getString("STATUS"));
//				}
//		 }
//		 catch(SQLException e)
//		 {
//			 
//		 }
//		 dc.setPp(p);
//		 return dc;
//	 }
//	 
//	 public void fetchOrderDetails() {
//			//System.out.println("json entered");
//				String dd="", stat="";
//				int f = 0;
//				int cid=0, oid=0;
//				ArrayList<String> stype = new ArrayList<String>();
//				ArrayList<Integer> sid = new ArrayList<Integer>();
//				ArrayList<Integer> pid = new ArrayList<Integer>();
//				ArrayList<String> pname = new ArrayList<String>();
//				ArrayList<Integer> quantity = new ArrayList<Integer>();
//				try {
//					// CallableStatement cst=con.prepareCall("{call duedate()}");
//					// System.out.println(cst.execute();
//					System.out.println("begin");
//					PreparedStatement pst = con
//							.prepareStatement("select order_id from orderprovision ");
//					ResultSet rs = pst.executeQuery();
//					System.out.println("getting order");
//					while (rs.next()) {
//						f = 1;
//						pst = con
//								.prepareStatement("select customer_id,due_date,stage from orderprovision where order_id in ?");
//						pst.setInt(1, rs.getInt("order_id"));
//						ResultSet rs2 = pst.executeQuery();
//						if(rs2.next())
//						{
//						cid = rs2.getInt("customer_id");
//						dd = rs2.getString("due_date");
//						stat = rs2.getString("stage");
//						oid = rs.getInt("order_id");
//						pst = con
//								.prepareStatement("select service_id,service_type From services where order_id in ?");
//						pst.setInt(1, rs.getInt("order_id"));
//
//						rs2 = pst.executeQuery();
//					//	pst=con.prepareStatement("select )
//						// it=0;
//						while (rs2.next()) {
//							stype.add(rs2.getString("service_type"));
//							int tmp=rs2.getInt("service_id");
//							sid.add(tmp);
//							pst = con.prepareStatement("select product_id,product_name,QUANTITY from product where service_id in ?");
//							pst.setInt(1, tmp);
//							ResultSet rs3 = pst.executeQuery();
//							while(rs3.next())
//							{
//							pname.add(rs3.getString("product_name"));
//							pid.add(rs3.getInt("product_id"));
//							quantity.add(rs3.getInt("QUANTITY"));
//							}
//						}
//						System.out.println(cid+oid+stat+dd+stype+sid+quantity+pname+pid);
//						}
//						
//						// String
//						//jsonObj=JsonCreator(cid,oid,dd,stype,sid,quantity,pname,pid);
//						
//					}
//					
//
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//}
