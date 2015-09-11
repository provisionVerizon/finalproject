package com.provisioning.javabeans;


public class WirelessCustomer {
	private int CUSTOMER_ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String TYPE;
	private String STREETNAME;
	private int ZIPCODE;
	private String CITY;
	private String STATE;
	private String COUNTRY;
	private String STATUS;
	private WirelessCard wc;
	private int Service_id;
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(int i) {
		CUSTOMER_ID = i;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getSTREETNAME() {
		return STREETNAME;
	}
	public void setSTREETNAME(String sTREETNAME) {
		STREETNAME = sTREETNAME;
	}
	public int getZIPCODE() {
		return ZIPCODE;
	}
	public void setZIPCODE(int zIPCODE) {
		ZIPCODE = zIPCODE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public WirelessCard getWc() {
		return wc;
	}
	public void setWc(WirelessCard wc) {
		this.wc = wc;
	}
	public int getService_id() {
		return Service_id;
	}
	public void setService_id(int service_id) {
		Service_id = service_id;
	}
	
}
