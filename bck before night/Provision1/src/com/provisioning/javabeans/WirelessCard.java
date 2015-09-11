package com.provisioning.javabeans;

public class WirelessCard {
	private String WIRELESS_ID;
	private String STATUS;
	private int service_id;
	public String getWIRELESS_ID() {
		return WIRELESS_ID;
	}
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public void setWIRELESS_ID(String strin) {
		// TODO Auto-generated method stub
	WIRELESS_ID=strin;	
	}

	public int getService_id() {
		return service_id;
	}

	

	public void setService_id(int int1) {
		// TODO Auto-generated method stub
	service_id=int1;	
	}
	
}
