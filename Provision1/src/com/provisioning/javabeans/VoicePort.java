package com.provisioning.javabeans;

public class VoicePort {
	
	private String VOICE_PORT_ID;
	private PonPort pp;
	private String STATUS;
	/**
	 * @return the vOICE_PORT_ID
	 */
	public String getVOICE_PORT_ID() {
		return VOICE_PORT_ID;
	}
	/**
	 * @param vOICE_PORT_ID the vOICE_PORT_ID to set
	 */
	public void setVOICE_PORT_ID(String vOICE_PORT_ID) {
		VOICE_PORT_ID = vOICE_PORT_ID;
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
