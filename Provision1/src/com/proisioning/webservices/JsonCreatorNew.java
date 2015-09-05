package com.proisioning.webservices;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import javax.json.JsonObject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class JsonCreatorNew {    
	public String json_creator(int custID,int orderID,String provisioningStatus,String provisionDate,
        ArrayList<String> serviceName,
	     ArrayList<Integer> serviceID,
	     ArrayList<Integer> quantity,
	     ArrayList<String> productname,
	     ArrayList<Integer> productID)
	{ 
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for(int i=0;i<serviceName.size();i++){
			if(serviceName.get(i)=="VES")
			{
				for(int j=1;j<=quantity.get(i);j++){
					  builder.add(j);
			}	
			}
				else{
					builder.add(productID.get(i));
				}
				
			}
			JsonArray jArray4=builder.build();
			
			
			
			
	   JsonArrayBuilder builder1= Json.createArrayBuilder();
    	for(int j=0;j<serviceName.size();j++){
		JsonObjectBuilder Jsonobj= Json.createObjectBuilder();
		JsonObject jo=Jsonobj.add("servicename", serviceName.get(j))
        .add("serviceid", serviceID.get(j))
        .add("quantity", quantity.get(j)).build();
		builder1.add(jo);
	}
		JsonArray jArray=builder1.build();
		
		
		JsonArrayBuilder builder2= Json.createArrayBuilder();
		
		for(int z=0;z<serviceName.size();z++){
				for(int j=0;j<productname.size();j++){
					JsonObjectBuilder Jsonobj1= Json.createObjectBuilder();
					JsonObject jo1=Jsonobj1.add("productname", productname.get(j))
			        .add("productid", jArray4)
			       .build();
					builder2.add(jo1);
				}

			}
			 JsonArray jArray1=builder2.build();
	         
		JsonObject value = Json.createObjectBuilder()
			     .add("customerid", custID)
			     .add("orderid", orderID)
			     .add("provisioningstatus", provisioningStatus)
			     .add("provisioningdate", provisionDate)
			     .add("service", jArray)
			     .add("product", jArray1)
			     .build();
			 
			// StringWriter writer = new StringWriter();
			//   Json.createWriter(writer).writeArray();
			    
		String input= value.toString();
        return input;
	}
}
