package com.provisioning.DAOforBeans;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import com.proisioning.webservices.JsonCreatorNew;
import com.proisioning.webservices.ProvisionedStatus;
import com.provisioning.connectionpool.DataSource;
import java.sql.*;

public class JsonReturning{
	Connection con;
	public void callOm() {
				System.out.println("in run");
				ProvisionedStatus ls = new ProvisionedStatus();
				JsonArray arr=jsonreturn();
				for(int i=0;i<arr.size();i++)
				ls.CheckProvisioningStatus(arr.getJsonObject(i).toString());

	}
	public JsonArray jsonreturn() {
		System.out.println("json entered");
			try
			{
				con=DataSource.getConnection();
			}
			catch(SQLException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
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
//					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//					java.util.Date utilDate = formatter.parse(dd);
	//
//					Date date = new java.sql.Date(utilDate.getTime());
//					dd=date;
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
//				if (f == 1) {
//					CallableStatement cst = con.prepareCall("{call duedate()}");
//					cst.execute();
	//
//				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
	       return null;    
		}
}
