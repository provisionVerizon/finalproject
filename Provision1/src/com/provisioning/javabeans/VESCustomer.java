package com.provisioning.javabeans;


public class VESCustomer {
	private String CUSTOMER_ID;
	private String FIRST_NAME;
	private int Service_id;
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
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
	public VESCard getVcard() {
		return vcard;
	}
	public void setVcard(VESCard vcard) {
		this.vcard = vcard;
	}
	public int getService_id() {
		return Service_id;
	}
	public void setService_id(int service_id) {
		Service_id = service_id;
	}
	private String LAST_NAME;
	private String TYPE;
	private String STREETNAME;
	private int ZIPCODE;
	private String CITY;
	private String STATE;
	private String COUNTRY;
	private String STATUS;
	private VESCard vcard;
	
}
