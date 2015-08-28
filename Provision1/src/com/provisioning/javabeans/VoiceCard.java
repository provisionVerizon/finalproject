package com.provisioning.javabeans;

public class VoiceCard {
	
	private String  VOICE_CARD_ID;
	VoicePort voiceport[]=new VoicePort[6];
	private String STATUS;
	/**
	 * @return the vOICE_CARD_ID
	 */
	public String getVOICE_CARD_ID() {
		return VOICE_CARD_ID;
	}
	/**
	 * @param vOICE_CARD_ID the vOICE_CARD_ID to set
	 */
	public void setVOICE_CARD_ID(String vOICE_CARD_ID) {
		VOICE_CARD_ID = vOICE_CARD_ID;
	}
	/**
	 * @return the voiceport
	 */
	public VoicePort[] getVoiceport() {
		return voiceport;
	}
	/**
	 * @param voiceport the voiceport to set
	 */
	public void setVoiceport(VoicePort[] voiceport) {
		this.voiceport = voiceport;
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
