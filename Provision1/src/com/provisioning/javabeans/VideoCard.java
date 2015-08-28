package com.provisioning.javabeans;

public class VideoCard {
	
	private String VIDEO_PORT_ID;
	private String STATUS;
	private PonPort pp;
	/**
	 * @return the vIDEO_CARD_ID
	 */
	public String getVIDEO_CARD_ID() {
		return VIDEO_PORT_ID;
	}
	/**
	 * @param vIDEO_CARD_ID the vIDEO_CARD_ID to set
	 */
	public void setVIDEO_CARD_ID(String vIDEO_CARD_ID) {
		VIDEO_PORT_ID = vIDEO_CARD_ID;
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
	 * @return the pp
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
	
	
}
