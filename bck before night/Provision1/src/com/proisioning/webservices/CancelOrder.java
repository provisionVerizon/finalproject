package com.proisioning.webservices;





//import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
// rest/profile/test/1234567&disconnect
@Path("/prov")
public class CancelOrder {
	@GET
	@Path("/cancel/{orderid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendProfile(@PathParam("orderid") String orderid) {
		 int o=Integer.parseInt(orderid);
	
		//cancelOrder(o);
		//jsonString = "{\"lineofbusiness\":\"C\",\"customerdetails\":{\"customerid\":\"106\",\"fname\":\"suresh\",\"lname\": \"siddharth\",\"customerstatus\":\"active|suspended|disconnected|delinquent\",\"billstartdate\":\"12-APR-2015\",\"connectionaddress\":{\"streetname\":\"10, mg road\",\"zipcode\":560102,\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\"},\"email\":\"suresh.siddharth@gmail.com\",\"contactnumber\":\"9500689870\",\"dateofbirth\":\"24-mar-1993\"},\"existingsnp\":{\"services\":[{\"servicecode\":\"ves1523\",\"servicename\":\"pip\",\"serviceid\":3456789,\"servicedate\":\"14-APR-2000\"}],\"products\":[{\"productcode\":\"ves123\",\"productname\":\"instrument\",\"productid\":123465789,\"quantity\":{\"max\":100,\"current\":50}}]},\"orderhistory\":[{\"orderid\":\"O/6728\",\"dateoforder\":\"30-JUN-2014\",\"duedate\":\"10-JUL-2014\",\"orderstatus\":\"new|outProvisioning|inProvisioning|complete|cancelled\"}]}],\"contractdetails\":[{\"contractid\":\"C/2345\",\"modeltype\":\"transactional|rtb\",\"classofservice\":\"platinum|gold|silver|bronze|normal\",\"fromdate\":\"18-aug-2015\",\"todate\":\"18-aug-2016\",\"discountpercentage\":10}]}";
		return "cancelled";

	}
/*
	public static void main(String args[]) {
		JsonStringSender fr = new JsonStringSender();
		System.out.println(fr.sendProfile());

	}
*/}

