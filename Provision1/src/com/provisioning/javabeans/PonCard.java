package com.provisioning.javabeans;

public class PonCard {

	private String PON_CARD_ID;
	PonPort ponport[]=new PonPort[2];
	/**
	 * @return the pON_CARD_ID
	 */
	public String getPON_CARD_ID() {
		return PON_CARD_ID;
	}
	/**
	 * @param pON_CARD_ID the pON_CARD_ID to set
	 */
	public void setPON_CARD_ID(String pON_CARD_ID) {
		PON_CARD_ID = pON_CARD_ID;
	}
	/**
	 * @return the ponport
	 */
	public PonPort[] getPonport() {
		return ponport;
	}
	/**
	 * @param ponport the ponport to set
	 */
	public void setPonport(PonPort[] ponport) {
		this.ponport = ponport;
	}
	
}
