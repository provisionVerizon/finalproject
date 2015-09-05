package com.proisioning.webservices;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.provisioning.DAOforBeans.DSLAMDAO;

@Path("/prov")
public class ProvRequestReciever {
	@POST
	@Path("/acceptRequest")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createResponse(String product) {
		
		DSLAMDAO dslamdao=new DSLAMDAO();
		HashMap<String, Object> mapObject = new HashMap<String, Object>();
		
				CreateHashMap.createHashMapFromJsonString(product, mapObject);
//				System.out.println("at receiver");
//				for (Map.Entry<String, Object> entry : mapObject.entrySet()) {
//					System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//				}
				if( mapObject.containsKey("customertype") && mapObject.containsValue("new")){
					dslamdao.insertIntoCustomer(mapObject);
				}
				else
				{	
					dslamdao.insertIntoOrder(mapObject);
				}
		return "acknowledge";
	}
	@GET
	@Path("/trial")
	@Produces(MediaType.APPLICATION_JSON)
	public String trial() {
		return "hey";
	}
}
