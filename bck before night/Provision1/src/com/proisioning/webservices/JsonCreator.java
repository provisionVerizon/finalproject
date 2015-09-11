package com.proisioning.webservices;
import java.io.StringWriter;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import javax.json.JsonObject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class JsonCreator {    
	String json_creator(int custID,int orderID,String provisioningStatus,String provisionDate,
        String serviceName[],
	     int serviceID[],
		int quantity[],
		String productname[],
		int productID[])
	{ 
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for(int i=0;i<serviceName.length;i++){
			if(serviceName[i]=="VES")
			{
				for(int j=1;j<=quantity[i];j++){
					  builder.add(j);
			}	
			}
				else{
					builder.add(productID[i]);
				}
				
			}
			JsonArray jArray4=builder.build();
			
			
			
			
	   JsonArrayBuilder builder1= Json.createArrayBuilder();
    	for(int j=0;j<serviceName.length;j++){
		JsonObjectBuilder Jsonobj= Json.createObjectBuilder();
		JsonObject jo=Jsonobj.add("servicename", serviceName[j])
        .add("serviceid", serviceID[j])
        .add("quantity", quantity[j]).build();
		builder1.add(jo);
	}
		JsonArray jArray=builder1.build();
		
		
		JsonArrayBuilder builder2= Json.createArrayBuilder();
		
		for(int z=0;z<serviceName.length;z++){
				for(int j=0;j<productname.length;j++){
					JsonObjectBuilder Jsonobj1= Json.createObjectBuilder();
					JsonObject jo1=Jsonobj1.add("productname", productname[j])
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
