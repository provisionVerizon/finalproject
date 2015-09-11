package com.provisioning.javabeans;

public class Order {
		
	private int ORDER_ID;
	private String DATE_OF_BOOKING;
	private String DUE_DATE;
	private String SERVICE_NAME;
	private String STATUS;
	private Customer customer;
	/**
	 * @return the oRDER_ID
	 */
	public int getORDER_ID() {
		return ORDER_ID;
	}
	/**
	 * @param oRDER_ID the oRDER_ID to set
	 */
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	/**
	 * @return the dATE_OF_BOOKING
	 */
	public String getDATE_OF_BOOKING() {
		return DATE_OF_BOOKING;
	}
	/**
	 * @param dATE_OF_BOOKING the dATE_OF_BOOKING to set
	 */
	public void setDATE_OF_BOOKING(String dATE_OF_BOOKING) {
		DATE_OF_BOOKING = dATE_OF_BOOKING;
	}
	/**
	 * @return the dUE_DATE
	 */
	public String getDUE_DATE() {
		return DUE_DATE;
	}
	/**
	 * @param dUE_DATE the dUE_DATE to set
	 */
	public void setDUE_DATE(String dUE_DATE) {
		DUE_DATE = dUE_DATE;
	}
	/**
	 * @return the sERVICE_NAME
	 */
	public String getSERVICE_NAME() {
		return SERVICE_NAME;
	}
	/**
	 * @param sERVICE_NAME the sERVICE_NAME to set
	 */
	public void setSERVICE_NAME(String sERVICE_NAME) {
		SERVICE_NAME = sERVICE_NAME;
	}
	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
