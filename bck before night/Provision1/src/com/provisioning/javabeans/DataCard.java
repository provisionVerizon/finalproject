package com.provisioning.javabeans;

public class DataCard {
	
	private String DATACARD_ID;
	private int CAPACITY_ALLOCATED;
	private PonPort pp;
	private String STATUS;
	/**
	 * @return the dATACARD_ID
	 */
	public String getDATACARD_ID() {
		return DATACARD_ID;
	}
	/**
	 * @param dATACARD_ID the dATACARD_ID to set
	 */
	public void setDATACARD_ID(String dATACARD_ID) {
		DATACARD_ID = dATACARD_ID;
	}
	/**
	 * @return the cAPACITY_ALLOCATED
	 */
	public int getCAPACITY_ALLOCATED() {
		return CAPACITY_ALLOCATED;
	}
	/**
	 * @param cAPACITY_ALLOCATED the cAPACITY_ALLOCATED to set
	 */
	public void setCAPACITY_ALLOCATED(int cAPACITY_ALLOCATED) {
		CAPACITY_ALLOCATED = cAPACITY_ALLOCATED;
	}
	/**
	 * @return the pon port mapped with the data card
	 */
	public PonPort getPp() {
		return pp;
	}
	/**
	 * @param pp the pp to set
	 */
	public void setPp(PonPort pp) {
		this.pp = pp;
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
	
	

}
