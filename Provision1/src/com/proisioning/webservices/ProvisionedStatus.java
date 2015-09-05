package com.proisioning.webservices;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.provisioning.DAOforBeans.DSLAMDAO;

public class ProvisionedStatus {
	public static void main(String[] args) throws IOException{
		String str="";
		DSLAMDAO dslamdao=new DSLAMDAO();
		str=dslamdao.jsonreturn();
		ProvisionedStatus ls = new ProvisionedStatus();
		str = ls.CheckProvisioningStatus(str);
	}
	public String CheckProvisioningStatus(String json){
		String str ="";

		try {
			String urlStr = "http://localhost:8080/TestRestServ/rest/om/provisioningComplete";
			URL urlToRequest = new URL(urlStr);
			HttpURLConnection httpConnection = (HttpURLConnection) urlToRequest
					.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type",MediaType.TEXT_PLAIN);
			
		   // JSONObject returnObject = Returnfxn();
			//String input = "{\"id\":1,\"firstName\":\"Liam\",\"age\":22,\"lastName\":\"Marco\"}";
			JSONObject returnObject=new JSONObject(json);
			String input = returnObject.toString();
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (httpConnection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			String output;
			System.out.println("Output from Server:\n");
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
			}
			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}
	
}


