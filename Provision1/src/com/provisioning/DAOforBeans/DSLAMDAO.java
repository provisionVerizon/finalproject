package com.provisioning.DAOforBeans;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import com.proisioning.webservices.JsonCreatorNew;
import com.proisioning.webservices.ProvisionedStatus;
import com.provisioning.connectionpool.DataSource;
import com.provisioning.javabeans.DSLAM;
//import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class DSLAMDAO{
	int datacap = 5;
	static int poncnt = 20;
	//static int ontseqno = 100;
	//static int cnt = 1000;
	Boolean shelfStatus[] = new Boolean[6];
	Connection con;
	HashMap<String, String> servicesMap;
	
	public DSLAMDAO() {
		
		for (int i = 0; i < 6; i++)
			shelfStatus[i] = false;
		servicesMap = new HashMap<String, String>();
		initializeConnection();
		initializeServiceMap();
	}


	private void initializeConnection() {
		try {
			con = DataSource.getConnection();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}

	private void initializeServiceMap() {
		// cmb services
		servicesMap.put("fios internet 25mbps", "data");
		servicesMap.put("fios internet 50mbps", "data");
		servicesMap.put("fios internet 25+fios basic tv", "video and data");
		servicesMap.put("fios internet 50+fios basic tv ", "video and data");
		servicesMap.put("fios internet 25+fios tv preffered hd",
				"video and data");
		servicesMap.put("fios internet 50+fios tv preffered hd",
				"video and data");
		servicesMap.put("fios internet25+fiostv customtv", "video and data");
		servicesMap.put("fios internet50+ fiostv customtv", "video and data");
		servicesMap.put("fios internet 25+fios basic tv+fios digitalvoice",
				"voice and video and data");
		servicesMap.put("fios internet 50+fios basic tv+fios digitalvoice",
				"voice and video and data");
		// ves srvices
		servicesMap.put("ap_3g_150_vo_150", "ves");
		servicesMap.put("ap_4g_200_vi_200", "ves");
		servicesMap.put("pi_vovi_200_200_125", "ves");
		servicesMap.put("pi_vi_150_250_175", "ves");
		servicesMap.put("ai_3g_200_150_75", "ves");
		servicesMap.put("ai_4g_250_200_125", "ves");
		servicesMap.put("api_4g_200_vi_150_200_125", "ves");
		servicesMap.put("api_4glte_250_vovi_250_200_125", "ves");
		servicesMap.put("access_3g_200", "ves");
		servicesMap.put("access_4g_300", "ves");
		servicesMap.put("access_4glte_300", "ves");
		servicesMap.put("access_4g_250", "ves");
		servicesMap.put("access_4glte_250", "ves");
		servicesMap.put("voice_200", "ves");
		servicesMap.put("videeo_200", "ves");
		servicesMap.put("video_250", "ves");
		servicesMap.put("voice_video_250", "ves");
		servicesMap.put("voice_video_300", "ves");
		servicesMap.put("id_200_125", "ves");
		servicesMap.put("id_200_175", "ves");
		servicesMap.put("id__250_225", "ves");
		servicesMap.put("id__300_225", "ves");
		servicesMap.put("id__300_275", "ves");
		// wireless services
		servicesMap.put("1gb per 2c", "wireless");
		servicesMap.put("2gb per 2c", "wireless");
		servicesMap.put("3gb per 2c", "wireless");
		servicesMap.put("4gb per 2c", "wireless");
		servicesMap.put("3gb per 3c", "wireless");
		servicesMap.put("4gb per 3c", "wireless");
		servicesMap.put("6gb per 3c", "wireless");
		servicesMap.put("6gb per 4c", "wireless");
		servicesMap.put("iphone 5_1gb_30$", "wireless");
		servicesMap.put("iphone6_3gb_45$", "wireless");
		servicesMap.put("iphone6_6gb_60$", "wireless");
		servicesMap.put("samsunggalaxy_s6_3gb/45$", "wireless");
		servicesMap.put("samsunggalaxy_s6_6gb/60$", "wireless");
		servicesMap.put("iphone6_12gb_80$", "wireless");
		servicesMap.put("iphone5_6gb-60$", "wireless");
		servicesMap.put("samsunggalaxy6", "wireless");
		servicesMap.put("1gb per 30$", "wireless");
		servicesMap.put("3gb per45$", "wireless");
		servicesMap.put("6gbper60$", "wireless");
	}

	public DSLAM createRequiredDslam(String dslamid) {
		DSLAM dslambean = new DSLAM();
		PonCardDAO poncard = new PonCardDAO();
		DataCardDAO datacard = new DataCardDAO();
		VoiceCardDAO voicecard = new VoiceCardDAO();
		VideoCardDAO videocard = new VideoCardDAO();
		VESCardDAO ves = new VESCardDAO();
		WirelessDAO wDao = new WirelessDAO();
		dslambean.setDSLAM_ID(dslamid);
		dslambean.setVes(ves.createVesCards(con, dslamid));
		dslambean.setWc(wDao.createWirelessCards(con, dslamid));
		dslambean.setDSLAM_ID(dslamid);
		dslambean.setVoice(voicecard.createVoiceCards(con, dslamid));
		dslambean.setVideo(videocard.createVideoeCards(con, dslamid));
		dslambean.setDc(datacard.createDataCard(con, dslamid));
		dslambean.setPoncard(poncard.createPonCards(con, dslamid));
		return dslambean;
	}

	public DSLAM createRequiredDslam(HashMap<String, Object> mydslam) {
		DSLAM dslambean = new DSLAM();
		PonCardDAO poncard = new PonCardDAO();
		DataCardDAO datacard = new DataCardDAO();
		VoiceCardDAO voicecard = new VoiceCardDAO();
		VideoCardDAO videocard = new VideoCardDAO();
		VESCardDAO ves = new VESCardDAO();
		WirelessDAO wDao = new WirelessDAO();

		String dslamid = (String) getRequiredDslam(mydslam);
		dslambean.setDSLAM_ID(dslamid);
		dslambean.setDSLAM_ID(dslamid);
		dslambean.setVes(ves.createVesCards(con, dslamid));
		dslambean.setWc(wDao.createWirelessCards(con, dslamid));
		dslambean.setVoice(voicecard.createVoiceCards(con, dslamid));
		dslambean.setVideo(videocard.createVideoeCards(con, dslamid));
		dslambean.setDc(datacard.createDataCard(con, dslamid));
		dslambean.setPoncard(poncard.createPonCards(con, dslamid));
		dslambean.setShelfStatus(getDslamShelfStatus(mydslam));
		return dslambean;
	}

	/*
	 * private Boolean[] getDslamShelfStatus(HashMap<String, Object> mydslam) {
	 * // TODO Auto-generated method stub return null; }
	 */
	public String getRequiredDslam(HashMap<String, Object> mpdslam) {
		// System.out.println(con);
		int stateid = Integer.parseInt((String) mpdslam.get("stateid"));
		String dslamid = null;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT DSLAM_ID FROM DSLAM WHERE START_STATE_ID<=? AND END_STATE_ID >=?");
			pst.setInt(1, stateid);
			pst.setInt(2, stateid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				dslamid = rs.getString("DSLAM_ID");
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {

		}
		return dslamid;
	}

	public Boolean[] getDslamShelfStatus(HashMap<String, Object> mydslam) {
		for (int i = 0; i < 6; i++)
			shelfStatus[i] = false;
		System.out.println((String)mydslam.get("lineofbusiness"));
		String lob=(String)mydslam.get("lineofbusiness");
		if (lob.equals("vzw")) {
			shelfStatus[0] = true;

		} else if (lob.equals("ves"))
			shelfStatus[1] = true;
		else {
			System.out.println((String)mydslam.get("servicename"));
			String servicename = servicesMap.get((String)mydslam.get("servicename"));
			System.out.println(servicename);
			shelfStatus[5] = true;
			switch(servicename) {
			case "data":
				shelfStatus[4] = true;
				break;
			case "voice and video":
				shelfStatus[2] = true;
				shelfStatus[3] = true;
				break;
			case "voice and data":
				shelfStatus[2] = true;
				shelfStatus[4] = true;
				break;
			case "video and data":
				shelfStatus[3] = true;
				shelfStatus[4] = true;
				break;
			case "voice and video and data":
				shelfStatus[2] = true;
				shelfStatus[3] = true;
				shelfStatus[4] = true;
				break;
			}
		}
		return shelfStatus;
	}

	public void assignVesCard(int customerid, String dslamid) {
		// String dslamid=getRequiredDslam(h);
		try {
			PreparedStatement pst = con.prepareStatement("SELECT ves_card_id from vescard where dslam_id='"
							+ dslamid + "'and status='AVAILABLE'");
			ResultSet rs = pst.executeQuery();
			//System.out.println("rsexec");
			while (rs.next()) {
				System.out.println("in rs" + rs.getString("ves_card_id"));
				pst = con.prepareStatement("update vescard set CUSTOMER_ID="
						+ customerid + " where ves_card_id='"
						+ rs.getString("ves_card_id") + "'");
				System.out.println("aftr");

				int y = pst.executeUpdate();
				//System.out.println("aftr2");
				pst = con.prepareStatement("update vescard set status='ASSIGNED' where ves_card_id='"
								+ rs.getString("ves_card_id") + "'");
				y = pst.executeUpdate();
				System.out.println("aftr3");
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void assignWirelessCard(int customerid, String dslamid) {
		try {
			System.out.println("in try");
			PreparedStatement pst = con.prepareStatement("SELECT wireless_id from wireless where dslam_id='"
							+ dslamid + "'and status='AVAILABLE'");
			System.out.println("pst");
			ResultSet rs = pst.executeQuery();
			System.out.println("afr");
			if (rs.next()) {

				System.out.println("rs" + rs.getString("wireless_id"));
				pst = con.prepareStatement("update wireless set customer_id="
						+ customerid + " where wireless_id='"
						+ rs.getString("wireless_id") + "'");
				int y = pst.executeUpdate();
				// System.out.println("rf");
				pst = con
						.prepareStatement("update wireless set status='ASSIGNED' where wireless_id='"
								+ rs.getString("wireless_id") + "'");
				y = pst.executeUpdate();
				// System.out.println("updated");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getPonPortAvailable(String dslamid) {
		ArrayList<String> availponports = new ArrayList<String>();
		try {
			String sql = "SELECT PON_PORT_ID from PONPORT where STATUS='AVAILABLE' and PON_PORT_ID LIKE ?";
			PreparedStatement pst = con.prepareStatement(sql);
			String condition = dslamid + "%";
			System.out.println(condition);
			pst.setString(1, condition);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
				availponports.add(rs.getString("PON_PORT_ID"));
		} catch (SQLException e) {
			System.out.println("problem with getPonPort" + e.getMessage());
		}
		return availponports;
	}

	public ArrayList<String> getVoicePortAvailable(String dslamid) {
		ArrayList<String> availvoiceports = new ArrayList<String>();
		try {
			String SQL = "SELECT VOICE_PORT_ID from VOICECARDPORT where STATUS='AVAILABLE' and VOICE_PORT_ID LIKE ? ";
			PreparedStatement st = con.prepareStatement(SQL);
			st.setString(1, dslamid + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next())
				availvoiceports.add(rs.getString("VOICE_PORT_ID"));
		} catch (SQLException e) {
			System.out.println("problem with getVoicePort" + e.getMessage());
		}
		return availvoiceports;
	}

	public ArrayList<String> getVideoCardAvailable(String dslamid) {
		ArrayList<String> availvideocard = new ArrayList<String>();
		try {
			String SQL = "SELECT VIDEO_PORT_ID from VIDEOCARD where STATUS='AVAILABLE' and dslam_id=?";
			PreparedStatement st = con.prepareStatement(SQL);
			st.setString(1, dslamid);
			ResultSet rs = st.executeQuery();
			while (rs.next())
				availvideocard.add(rs.getString("VIDEO_PORT_ID"));
		} catch (SQLException e) {
			System.out.println("problem with getVideoCard" + e.getMessage());
		}
		return availvideocard;
	}

	public void assignCmbCard(int customerid, Boolean[] shelfStatus,
			String dslamid) {
		ArrayList<String> availponports = getPonPortAvailable(dslamid);
		ArrayList<String> availvoiceports = getVoicePortAvailable(dslamid);
		ArrayList<String> availvideocard = getVideoCardAvailable(dslamid);
		String ponportid = availponports.get(0);
		String voiceportid = availvoiceports.get(0);
		String videocardid = availvideocard.get(0);
		assignONT(customerid, ponportid);
		if (ponportid.equals(null)) {
			addPon(dslamid);
		}
		if (voiceportid.equals(null)) {
			addvoice(dslamid);
		}
		if (videocardid.equals(null)) {
			addVideo(dslamid);
		}
		int currentDataAvailable = 0;
		//
		// System.out.println("in asscard");
		try {
			PreparedStatement pst = con
					.prepareStatement("select capacity from datacard where DSLAM_ID=?");
			pst.setString(1, dslamid);
			System.out.println("hi");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				currentDataAvailable = rs.getInt("capacity");
			rs.close();
			pst.close();
			int finalvalue = currentDataAvailable - datacap;
			PreparedStatement pst1 = con
					.prepareStatement("update datacard set capacity=? where dslam_id=?");
			pst1.setInt(1, finalvalue);
			pst1.setString(2, dslamid);
			pst1.executeUpdate();
		} catch (SQLException e) {
			System.out.println("execute update in data card" + e.getMessage());
		}

		try {
			System.out.println("in ponport");
			PreparedStatement pst = con
					.prepareStatement("update ponport set status='ASSIGNED' where pon_port_id=?");
			pst.setString(1, ponportid);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("execute update in pon port card"
					+ e.getMessage());
		}

		if (shelfStatus[2] == true) {
			System.out.println("shelf2");
			try {
				PreparedStatement pst = con.prepareStatement("update voicecardport set pon_port_id=?,status='ASSIGNED' where voice_port_id=? ");
				pst.setString(1, ponportid);
				pst.setString(2, voiceportid);
				pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("problem with update voice card port"
						+ e.getMessage());
			}
		}
		if (shelfStatus[3] == true) {
			try {
				PreparedStatement pst = con.prepareStatement("update videocard set pon_port_id=?, status='ASSIGNED' where video_port_id=? ");
				pst.setString(1, ponportid);
				pst.setString(2, videocardid);
				pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("problem with update video card port"
						+ e.getMessage());
			}

		}
		/*
		 * else if(shelfStatus[2]==true && shelfStatus[3]==true) { try {
		 * PreparedStatement
		 * pst=con.prepareStatement("update voicecardport set pon_port_id='"
		 * +ponportid
		 * +"' and status='ASSIGNED' where voice_port_id='"+voiceportid+"' ");
		 * pst.executeUpdate(); } catch(SQLException e) { System.out.println(
		 * "problem with update voice card port in third else if " +
		 * e.getMessage()); } try { PreparedStatement
		 * pst=con.prepareStatement("update videocard set pon_port_id='"
		 * +ponportid
		 * +"' and status='ASSIGNED' where video_port_id='"+videocardid+"' ");
		 * pst.executeUpdate(); } catch(SQLException e) {
		 * System.out.println("problem with update voice card port in third else if"
		 * + e.getMessage()); } }
		 */

	}

	private void addVideo(String dslamid) {
		// TODO Auto-generated method stub

	}

	private void addvoice(String dslamid) {
		// TODO Auto-generated method stub

	}

	private void addPon(String dslamid) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pst = con
					.prepareStatement("select pon_max,pon_avail from dslam where dslam_id='"
							+ dslamid + "'");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getInt("pon_max") > rs.getInt("pon_avail")) {
					for (int i = 0; i < 5; i++) {
						System.out.println("in i");
						pst = con.prepareStatement("insert into pon values('"
								+ dslamid + "PO" + poncnt + "','" + dslamid
								+ "')");
						ResultSet rs2 = pst.executeQuery();
						int portcnt = 0;
						for (int j = 0; j < 2; j++) {
							System.out.println("in j");
							pst = con
									.prepareStatement("insert into pon values('"
											+ dslamid
											+ "PO"
											+ poncnt
											+ "P"
											+ portcnt
											+ ",'"
											+ dslamid
											+ "PO"
											+ poncnt + "')");
							portcnt++;
						}
						poncnt++;
					}
					int finalpon = rs.getInt("pon_avail") + 5;
					pst = con.prepareStatement("update dslam set pon_avail="
							+ finalpon + "where dslam_id='" + dslamid + "'");

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertIntoServices(HashMap<String, Object> servicesMap) {

		int counter = 001;
		String input = (String) servicesMap.get("servicecode");
		String[] servicecode = input.split(",");
		// String servicecode[]=(String[])servicesMap.get("servicecode");
		input = (String) servicesMap.get("servicename");
		String[] servicename = input.split(",");
		// String servicename[]=(String[])servicesMap.get("servicename");
		int customerid = Integer.parseInt((String) servicesMap.get("customerid"));
		String lob = (String) servicesMap.get("lineofbusiness");
		int orderid =Integer.parseInt((String)servicesMap.get("orderid"));
		System.out.println("in services");
		for (int i = 0; i < servicecode.length; i++) {
			String serviceType = servicename[i];
			String serviceCode = servicecode[i];
			try {
				String sql="select max(service_id) as id from services";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				counter=rs.getInt("id")+1;
				PreparedStatement pst = con
						.prepareStatement("INSERT INTO services(service_id,customer_id,service_type,order_id) values(?,?,?,?)");
				pst.setInt(1, counter);
				pst.setInt(2, customerid);
				pst.setString(3, serviceType);
				pst.setInt(4, orderid);
				pst.executeQuery();
				insertIntoProduct(servicesMap, counter);
			} catch (SQLException e) {
				System.out.println("problem in aaa service tbl" + e.getMessage());
			}
			System.out.println("inserted into service");
		}
	}

	private void insertIntoProduct(HashMap<String, Object> productMap,
			int serviceid) {
		System.out.println("got in");
		int counter=100;
		String input = (String) productMap.get("productcode");
		String[] productcode = input.split(",");
		// String productcode[]=(String[])productMap.get("productcode");
		input = (String) productMap.get("productname");
		String[] productname = input.split(",");
		System.out.println("in product");
		// String productname[]=(String[])productMap.get("productname");
		// int qty=(int)productMap.get("Quantity");
		int qty = Integer.parseInt((String)productMap.get("quantity"));
		for (int i = 0; i < productcode.length; i++) {
			String procode = productcode[i];
			String proname = productname[i];
			try {
				String sql="select max(product_id) as id from product";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				counter=rs.getInt("id")+1;
				PreparedStatement pst = con.prepareStatement("insert into product(PRODUCT_ID,PRODUCT_NAME,SERVICE_ID,QUANTITY,STATUS) values(?,?,?,?,?) ");
				pst.setInt(1, counter);
				pst.setString(2, proname);
				pst.setInt(3, serviceid);
				pst.setInt(4, qty);
				pst.setString(5, "pending");
				pst.executeQuery();
			} catch (SQLException e) {
				System.out.println("problem with insert into product "+e.getMessage());
			}
		}
		System.out.println("inserted into product");
	}

	public void insertIntoOrder(HashMap<String, Object> orderMap) {
		System.out.println(orderMap.get("orderid"));
		Date date=null;
		int orderid = Integer.parseInt((String)orderMap.get("orderid"));// Integer.parseInt((String)servicesMap.get("orderid"));
		int customerid = Integer.parseInt((String) orderMap.get("customerid"));
		String due_date = (String) orderMap.get("duedate");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date utilDate;
		try {
			utilDate = formatter.parse(due_date);
			date = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement pst;
		System.out.println("in order");
		try {
			pst = con.prepareStatement("insert into orderprovision values(?,?,?,?)");
			pst.setInt(1, orderid);
			pst.setInt(2, customerid);
			pst.setString(3, "processing");
			pst.setDate(4, date);
			ResultSet rs = pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("problem with insert into order " + e.getMessage());
		}
	}

	public void insertIntoCustomer(HashMap<String, Object> jsonDetails) {
		int id = Integer.parseInt((String) jsonDetails.get("customerid"));
		String name = (String) jsonDetails.get("customername");
		String names[]=name.split(" ");
		String firstName=names[0];
		String lastName=names[1];
		String type = (String) jsonDetails.get("customertype");
		int stateid = Integer.parseInt((String) jsonDetails.get("stateid"));
		String street = (String) jsonDetails.get("streetname");
		String zip = (String) jsonDetails.get("zipcode");
		String city = (String) jsonDetails.get("city");
		String state = (String) jsonDetails.get("state");
		String country = (String) jsonDetails.get("country");
		int orderid = 1234;// Integer.parseInt((String)jsonDetails.get("orderid"));
		String status = "pending";
		System.out.println("in insert cust");
		System.out.println(con);
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO CUSTOMER(CUSTOMER_ID,FIRST_NAME,LAST_NAME,TYPE,STREETNAME,ZIPCODE,CITY,STATE,COUNTRY,STATUS,STATE_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, type);
			pst.setString(5, street);
			pst.setString(6, zip);
			pst.setString(7, city);
			pst.setString(8, state);
			pst.setString(9, country);
			pst.setString(10, status);
			pst.setInt(11, stateid);
			pst.executeQuery();
			pst.close();
		} catch (SQLException e) {
			System.out.println("problem with insert into customer"
					+ e.getMessage());
		}

		insertIntoOrder(jsonDetails);
		insertIntoServices(jsonDetails);
		///DSLAMDAO assignCustomer = new DSLAMDAO();
	    assignPorts(id, stateid, jsonDetails);
		//updateOrderStatus(orderid, "PROVISIONED");
	    JsonReturning js=new JsonReturning();
	    js.callOm();
	   
	}

	private void updateOrderStatus(int orderid, String string) {
		// TODO Auto-generated method stub
		String provision;
		try {
			PreparedStatement pst = con
					.prepareStatement("update  orderprovision set stage='"
							+ string + "' where order_id=?");
			pst.setInt(1, orderid);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("problem with get provion status"
					+ e.getMessage());
		}
	}

	public String getProvisionStatus(int orderid) {
		String provision = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select stage from orderprovision where order_id=?");
			pst.setInt(1, orderid);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				provision = rs.getString("STAGE");
		} catch (SQLException e) {
			System.out.println("problem with get provion status"
					+ e.getMessage());
		}
		return provision;
	}

	public void cancelOrder(int orderid) {
		DSLAMDAO cancelObject = new DSLAMDAO();
		int customerid = 0;
		try {
			System.out.println("in cancel");
			PreparedStatement pst = con
					.prepareStatement("update orderprovision set STAGE='CANCEL' where order_id=?");
			pst.setInt(1, orderid);
			pst.executeUpdate();
			System.out.println("canceld");
			pst = con
					.prepareStatement("select customer_id from orderprovision where order_id=?");
			pst.setInt(1, orderid);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				customerid = rs.getInt("CUSTOMER_ID");
			System.out.println("in cancl");
		} catch (SQLException e) {
			System.out.println("problem with the master update "
					+ e.getMessage());
		}
		// cancelObject.disconnect(customerid);
	}

	public void changeDueDate(int orderid, String date) {
		try {
			PreparedStatement pst = con
					.prepareStatement("update orderprovision set due_date=? where order_id=?");
			pst.setString(1, date);
			pst.setInt(2, orderid);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("problem with the update in order provision"
					+ e.getMessage());
		}
	}

	public void dispatchProducts(int customerid) {
		try {
			PreparedStatement pst = con
					.prepareStatement("update product set status='DISPATCH' where product_id in(select product_id from product where service_id in (SELECT SERVICE_ID from SERVICES where customer_id=?))");
			pst.setInt(1, customerid);
			pst.executeQuery();
		} catch (Exception e) {
			System.out.println("in dispatch" + e.getMessage());
		}
	}

	public void disconnect(int customerid, int stateid) {
		Boolean[] shelfStatus = new Boolean[6];
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;
		HashMap<String, Object> getdsalmstatus = new HashMap<String, Object>();
		getdsalmstatus.put("stateid", Integer.toString(stateid));
		String dslamid = getRequiredDslam(getdsalmstatus);
		try {
			// System.out.println(con);
			// PreparedStatement
			// pst=con.prepareStatement("select type from CUSTOMER where customer_id="+customerid);

			st = con.createStatement();
			rs = st.executeQuery("select type from CUSTOMER where customer_id="
					+ customerid);

			// System.out.println("1"+rs.getString("TYPE"));
			while (rs.next()) {
				System.out.println(rs.getString("type"));
				getdsalmstatus.put("lineofbusiness", rs.getString("TYPE"));
			}
			pst1 = con
					.prepareStatement("select SERVICE_TYPE from SERVICES where customer_id=?");
			pst1.setInt(1, customerid);
			rs1 = pst1.executeQuery();
			while (rs1.next()) {
				getdsalmstatus
						.put("servicename", rs1.getString("SERVICE_TYPE"));
			}

		} catch (SQLException e) {
			System.out.println("in the assign ports " + e.getMessage());
		}
		shelfStatus = getDslamShelfStatus(getdsalmstatus);

		for (int i = 0; i < shelfStatus.length; i++) {
			System.out.println(shelfStatus[i] + "i" + i);
		}
		if (shelfStatus[0] == true) {
			System.out.println("wireless disconnect");
			disconnectWireless(customerid);
		} else if (shelfStatus[1] == true) {
			System.out.println("ves disconnect");
			disconnectVES(customerid);
		} else {
			System.out.println("cmb dis");
			disconnectCMB(customerid);
			System.out.println("afr");
		}

	}

	public void assignPorts(int customerid, int stateid,HashMap<String, Object> getdslamstatus) {
		Boolean[] shelfStatus = new Boolean[6];
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;
		// HashMap<String , String> getdsalmstatus=new HashMap<String,
		// String>();
		// getdsalmstatus.put("stateid",Integer.toString(stateid) );
		String dslamid = getRequiredDslam(getdslamstatus);
        shelfStatus=getDslamShelfStatus(getdslamstatus);
		if (shelfStatus[0] == true) {
			System.out.println("wireless ok");
			assignWirelessCard(customerid, dslamid);
		} else if (shelfStatus[1] == true) {
			System.out.println("ves ok");
			assignVesCard(customerid, dslamid);
		} else {
			System.out.println("cmb ok");

			assignCmbCard(customerid, shelfStatus, dslamid);
			System.out.println("afr");
		}
		// }
	}

	public void assignONT(int customerid, String ponportid) {
		// create seq
		int ontseq= (int)(Math.random()*100);
		String ont = 'O' + Integer.toString(ontseq);
		try {
			PreparedStatement pp = con
					.prepareStatement("insert into ont values('" + ont + "',"
							+ customerid + ",'" + ponportid + "','ASSIGNED')");
			ResultSet rs = pp.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnectCMB(int customerid) {

		try {
			PreparedStatement pst = con
					.prepareStatement("SELECT PON_PORT_ID FROM ONT WHERE CUSTOMER_ID="
							+ customerid);
			ResultSet rs = pst.executeQuery();
			System.out.println("ponport retieved");
			if (rs.next()) {
				String pp = rs.getString("PON_PORT_ID");
				pst = con
						.prepareStatement("UPDATE  PONPORT SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"
								+ pp + "'");
				int u = pst.executeUpdate();

				pst = con
						.prepareStatement("SELECT CAPACITY FROM DATACARD WHERE PON_PORT_ID='"
								+ pp + "'");
				ResultSet rs2 = pst.executeQuery();
				System.out.println("datacard retieved");
				int finalval = rs2.getInt("capacity") + datacap;
				if (rs2.next()) {
					pst = con.prepareStatement("UPDATE DATACARD SET CAPACITY="
							+ finalval + "WHERE PON_PORT_ID='" + pp + "'");
					int y = pst.executeUpdate();
				}
				/*
				 * pst=con.prepareStatement(
				 * "SELECT VIDEO_PORT_ID FROM VIDEOCARD WHERE PON_PORT_ID='"
				 * +pp+"'"); //rs2=pst.executeQuery(); if(rs2.next()) {
				 */
				pst = con
						.prepareStatement("UPDATE VIDEOCARD  SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"
								+ pp + "'");
				int y = pst.executeUpdate();
				pst = con
						.prepareStatement("UPDATE VIDEOCARD  SET PON_PORT_ID='' WHERE STATUS='AVAILABLE'");
				y = pst.executeUpdate();
				System.out.println("videocard updated");
				/*
				 * }
				 * 
				 * pst=con.prepareStatement(
				 * "SELECT VOICE_PORT_ID FROM VOICECARDPORT WHERE PON_PORT_ID='"
				 * +pp+"'"); rs2=pst.executeQuery(); if(rs2.next()) {
				 */
				pst = con
						.prepareStatement("UPDATE VOICECARDPORT  SET STATUS='AVAILABLE' WHERE PON_PORT_ID='"
								+ pp + "'");
				y = pst.executeUpdate();
				pst = con
						.prepareStatement("UPDATE VOICECARDPORT  SET PON_PORT_ID='' WHERE STATUS='AVAILABLE'");
				y = pst.executeUpdate();
				System.out.println("voicecard updated");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnectWireless(int customerid) {
		PreparedStatement pst;
		try {
			pst = con
					.prepareStatement("UPDATE WIRELESS SET STATUS='AVAILABLE' WHERE CUSTOMER_ID="
							+ customerid);
			int y = pst.executeUpdate();
			pst = con
					.prepareStatement("UPDATE WIRELESS SET CUSTOMER_ID='' WHERE STATUS='AVAILABLE'");
			y = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnectVES(int customerid) {
		PreparedStatement pst;
		try {
			pst = con
					.prepareStatement("UPDATE VESCARD SET STATUS='AVAILABLE' WHERE CUSTOMER_ID="
							+ customerid);
			int y = pst.executeUpdate();
			pst = con
					.prepareStatement("UPDATE VESCARD SET CUSTOMER_ID='' WHERE STATUS='AVAILABLE'");
			y = pst.executeUpdate();
			System.out.println("disconnected ves");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JsonArray jsonreturn() {
	System.out.println("json entered");
		String stat="";
		int f = 0;
		int cid=0, oid=0;
		JsonArrayBuilder builder = Json.createArrayBuilder();
		ArrayList<String> stype = new ArrayList<String>();
		ArrayList<Integer> sid = new ArrayList<Integer>();
		ArrayList<Integer> pid = new ArrayList<Integer>();
		ArrayList<String> pname = new ArrayList<String>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		try {
			 CallableStatement cst=con.prepareCall("{call duedate()}");
			 cst.execute();
			System.out.println("begin");
			PreparedStatement pst = con.prepareStatement("select order_id from orderprovision where stage='PROVISIONED' and due_date<=sysdate");
			ResultSet rs = pst.executeQuery();
			System.out.println("getting order");
			while (rs.next()) {
				f = 1;
				pst = con.prepareStatement("select customer_id,due_date,stage from orderprovision where order_id in ?");
				pst.setInt(1, rs.getInt("order_id"));
				ResultSet rs2 = pst.executeQuery();
				if(rs2.next())
				{
				cid = rs2.getInt("customer_id");
				java.sql.Date dd = rs2.getDate("due_date");
//				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//				java.util.Date utilDate = formatter.parse(dd);
//
//				Date date = new java.sql.Date(utilDate.getTime());
//				dd=date;
				stat = rs2.getString("stage");
				oid = rs.getInt("order_id");
				pst = con.prepareStatement("select service_id,service_type From services where order_id in ?");
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
				//System.out.println(cid+oid+stat+dd+stype+sid+quantity+pname+pid);
				 JsonCreatorNew json=new JsonCreatorNew();
					javax.json.JsonObject jsonObj=json.json_creator(cid,oid,stat,dd.toString(),stype,sid,quantity,pname,pid);
					builder.add(jsonObj);
				}
				
				// String
				
			}
			JsonArray arr1=builder.build();
			return arr1;
//			if (f == 1) {
//				CallableStatement cst = con.prepareCall("{call duedate()}");
//				cst.execute();
//
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return null;    
	}

	public static void main(String[] args) {
//		DSLAMDAO dd = new DSLAMDAO();
//		Thread t = new Thread(dd);
////       CreateHashMap createHash=new CreateHashMap();
////       HashMap< String, Object> jsonDetails=createHash.callhash();
////       dd.insertIntoCustomer(jsonDetails);
//		//t.start();
//		 dd.jsonreturn();
//		System.out.println(dd.jsonreturn());
	}

}
