package CreateHashMap;
import java.util.*;
import java.util.Map.Entry;

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
		 
	public static HashMap callhash() {
		// TODO Auto-generated method stub
			
	 String str = "	{"+
				"  \"lob\": \"ves\", "+
				"  \"customerdetails\": {  "+
				"   \"customerid\": 1234567, "+
				"\"duedate\":\"24-AUG-2015\","+
				"   \"customername\": \"Suresh Siddharth\", "+
				"   \"customertype\": \"new \", "+
				"   \"connectionaddress\": { "+
				"      \"streetname\": \"10, mg road\", "+
				"     \"zipcode\": 560102, "+
				"     \"city\": \"bangalore\", "+
				"     \"state\": \"karnataka\", "+
				"     \"country\": \"india\" " +
				"   },\"contactnumber\":9500689870}, "+
				" \"services\": [ { " + 
				" \"servicecode\": \"ves1523\", "+
				" \"servicename\": \"AP_3G_150_Vo_150\"" +
				"   }," +
				"{ " + 
				
				" \"servicecode\": \"ves15ab\", "+
				" \"stateid\":\"6\","+
				" \"servicename\": \"PI_Vi_150_250_175\" " +
				"   }], " +
				" \"product\":[{"+
				" \"productcode\": \"vz1234\","+
				"  \"productname\": \"set_top_box\"" + 
				"}]"+
 
				"}"; 
		//String str=" {\"order\":[{\"lineofbusiness\": \"ves|vzw|cmb\",\"customerdetails\": {\"customerid\": 1234567,\"customername\": \"Suresh Siddharth\",\"customertype\": \"new|registered\",\"connectionaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",\"stateid\": 20,\"country\": \"india\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 1234567,\"dateofbooking\": \"18-aug-2015\",\"duedate\": \"25-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"pip\",\"mdn\": [7890222200,7830444444],\"quantity\": 20}],\"products\":[{\"productcode\": \"VZ1234\",\"productname\": \"Set Top Box\"}]}},{\"lineofbusiness\": \"ves|vzw|cmb\",\"customerdetails\": {\"customerid\": 1234567,\"customername\": \"Suresh Siddharth\",\"customertype\": \"new|registered\",\"connectionaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",\"stateid\": 20,\"country\": \"india\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 52222,\"dateofbooking\": \"18-aug-2015\",\"duedate\": \"25-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"pip\",\"mdn\": [7890222200,7830444444],\"quantity\": 20}],\"products\":[{\"productcode\": \"VZ1234\",\"productname\": \"Set Top Box\"}]}}]}";*/
		   
	// String str=" {\"lob\": \"cmb\",\"customerdetails\": {\"customerid\": 1234567,\"customername\": \"Suresh Siddharth\",\"customertype\": \"new|registered\",\"connectionaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",\"stateid\": 20,\"country\": \"india\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 1234567,\"dateofbooking\": \"18-aug-2015\",\"duedate\": \"25-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"pip\",\"mdn\": [7890222200,7830444444],\"quantity\": 20}],\"products\":[{\"productcode\": \"VZ1234\",\"productname\": \"Set Top Box\"}]}},{\"lineofbusiness\": \"ves|vzw|cmb\",\"customerdetails\": {\"customerid\": 1234567,\"customername\": \"Suresh Siddharth\",\"customertype\": \"new|registered\",\"connectionaddress\": {\"streetname\": \"10, mg road\",\"zipcode\": 560102,\"city\": \"bangalore\",\"state\": \"karnataka\",\"stateid\": 20,\"country\": \"india\"},\"contactnumber\":9500689870},\"orderdetails\": { \"orderid\": 52222,\"dateofbooking\": \"18-aug-2015\",\"duedate\": \"25-aug-2015\",\"services\": [ {\"servicecode\": \"ves1523\",\"servicename\": \"pip\",\"mdn\": [7890222200,7830444444],\"quantity\": 20}],\"products\":[{\"productcode\": \"VZ1234\",\"productname\": \"Set Top Box\"}]}}]}";
		
		
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
			return mapObject;
	}

}

