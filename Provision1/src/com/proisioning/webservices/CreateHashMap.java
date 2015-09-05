package com.proisioning.webservices;
import java.util.*;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CreateHashMap{

		static JsonParser parser = new JsonParser();

		public static void createHashMapFromJsonString(String json, HashMap<String, Object> map){

		    JsonObject object = (JsonObject) parser.parse(json);
		    Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		    Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		  

		    while (iterator.hasNext()) {

		        Map.Entry<String, JsonElement> entry = iterator.next();
		        String key = entry.getKey();
		        JsonElement value = entry.getValue();

		        if (null != value) {
		            if (!value.isJsonPrimitive()) {
		                if (value.isJsonObject()) {

		                    createHashMapFromJsonString(value.toString(), map);
		                } else if (value.isJsonArray() && value.toString().contains(":")) {

		                    List<HashMap<String, Object>> list = new ArrayList<>();
		                    JsonArray array = value.getAsJsonArray();
		                    if (null != array) {
		                        for(JsonElement element : array) {
		                            createHashMapFromJsonString(element.toString(), map);
		                        }
		                       // map.put(key, list);
		                    }
		                } else if (value.isJsonArray() && !value.toString().contains(":")) {
		                	if ( map.containsKey(key) ){
			            		String oldValue = (String)map.get(key);
			            		oldValue.concat(",");
			            		oldValue.concat(value.getAsString());
			            		map.put( key, oldValue);
			            	}
			            	else {
		                    map.put(key, value.getAsJsonArray());
			            	}
		                }
		            } else {
		            	if ( map.containsKey(key) ){
		            		String oldValue = (String)map.get(key);
		            		oldValue = oldValue.concat(",");
		            		oldValue = oldValue.concat(value.getAsString());
		            		map.put(key, oldValue);
		            	}
		            	else {
		                map.put(key, value.getAsString());
		            	}
		            }
		        }
		    }
		   
		}
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String str = "{\"lineofbusiness\":\"ves|vzw|cmb\",\"customerdetails\":{\"customerid\":\"1234567\",\"customername\":\"Suresh Siddharth\", \"customertype\":\"new\",\"connectionaddress\":{\"streetname\":\"10, mg road\",\"zipcode\":\"560102\", \"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\"},\"contactnumber\":\"9500689870\"}, \"orderdetails\":{\"orderid\":\"1234567\",\"dateofbooking\":\"18-aug-2015\",\"duedate\":\"25-aug-2015\"},\"services\":[{\"servicecode\":\"ves15ab\",\"servicename\":\"pipav\",\"mdn\":[\"78902222000\",\"7823456789\"],\"quantity\":\"20\"}],\"products\":[{\"productcode\":\"fgh123\",\"productname\":\"pip\"}]}";

		
		
		HashMap<String, Object> mapObject = new HashMap<String, Object>();
		createHashMapFromJsonString( str , mapObject);
		 // String xxx = (String) mapObject.get("lineofbusiness");
		  //System.out.println(xxx);
		  
		//loop a Map
			for (Map.Entry<String, Object> entry : mapObject.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			}
			
			if( mapObject.containsKey("customertype") && mapObject.containsValue("new")){
			
			}
	}

}

