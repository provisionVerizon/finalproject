package com.provisioning.javabeans;


import java.util.ArrayList;

public class DSLAM {

		private String DSLAM_ID;
		private ArrayList<VoiceCard> voice;
		private ArrayList<VideoCard> video;
		private DataCard dc;
		private ArrayList<VESCard> ves;
		private ArrayList<WirelessCard> wc;
		private ArrayList<PonCard> poncard;
		private static int MAX_VIDEO_CARD_CAPACITY;
		private static int MAX_VOICE_CARD_CAPACITY;
		private static int MAX_PON_CARD_CAPACITY;
		private static int MAX_DATA_BUFFER;
		private static int MAX_WIRELESS_CARD_CAPACITY;
		private static int MAX_VES_CAPACITY;
		Boolean shelfStatus[];
		
		public DSLAM() {
			
			voice=new ArrayList<VoiceCard>();
			video=new ArrayList<VideoCard>();
			dc=new DataCard();
			poncard=new ArrayList<PonCard>();
			MAX_PON_CARD_CAPACITY=20;
			MAX_VIDEO_CARD_CAPACITY=40;
			MAX_VOICE_CARD_CAPACITY=20;
			MAX_DATA_BUFFER=500;
			MAX_WIRELESS_CARD_CAPACITY=20;
			MAX_VES_CAPACITY=10;
			shelfStatus=new Boolean[6];
		}

		public Boolean[] getShelfStatus() {
			return shelfStatus;
		}

		public void setShelfStatus(Boolean[] shelfStatus) {
			this.shelfStatus = shelfStatus;
		}

		/**
		 * @return the dSLAM_ID
		 */
		public String getDSLAM_ID() {
			return DSLAM_ID;
		}

		/**
		 * @param dSLAM_ID the dSLAM_ID to set
		 */
		public void setDSLAM_ID(String dSLAM_ID) {
			DSLAM_ID = dSLAM_ID;
		}

		/**
		 * @return the voice
		 */
		public ArrayList<VoiceCard> getVoice() {
			return voice;
		}

		/**
		 * @param voice the voice to set
		 */
		public void setVoice(ArrayList<VoiceCard> voice) {
			this.voice = voice;
		}

		/**
		 * @return the video
		 */
		public ArrayList<VideoCard> getVideo() {
			return video;
		}

		/**
		 * @param video the video to set
		 */
		public void setVideo(ArrayList<VideoCard> video) {
			this.video = video;
		}

		/**
		 * @return the dc
		 */
		public DataCard getDc() {
			return dc;
		}

		/**
		 * @param dc the dc to set
		 */
		public void setDc(DataCard dc) {
			this.dc = dc;
		}

		/**
		 * @return the poncard
		 */
		public ArrayList<PonCard> getPoncard() {
			return poncard;
		}

		/**
		 * @param poncard the poncard to set
		 */
		public void setPoncard(ArrayList<PonCard> poncard) {
			this.poncard = poncard;
		}

		/**
		 * @return the mAX_VIDEO_CARD_CAPACITY
		 */
		public static int getMAX_VIDEO_CARD_CAPACITY() {
			return MAX_VIDEO_CARD_CAPACITY;
		}

		/**
		 * @param mAX_VIDEO_CARD_CAPACITY the mAX_VIDEO_CARD_CAPACITY to set
		 */
		public static void setMAX_VIDEO_CARD_CAPACITY(int mAX_VIDEO_CARD_CAPACITY) {
			MAX_VIDEO_CARD_CAPACITY = mAX_VIDEO_CARD_CAPACITY;
		}

		/**
		 * @return the mAX_VOICE_CARD_CAPACITY
		 */
		public static int getMAX_VOICE_CARD_CAPACITY() {
			return MAX_VOICE_CARD_CAPACITY;
		}

		/**
		 * @param mAX_VOICE_CARD_CAPACITY the mAX_VOICE_CARD_CAPACITY to set
		 */
		public static void setMAX_VOICE_CARD_CAPACITY(int mAX_VOICE_CARD_CAPACITY) {
			MAX_VOICE_CARD_CAPACITY = mAX_VOICE_CARD_CAPACITY;
		}

		/**
		 * @return the mAX_PON_CARD_CAPACITY
		 */
		public static int getMAX_PON_CARD_CAPACITY() {
			return MAX_PON_CARD_CAPACITY;
		}

		/**
		 * @param mAX_PON_CARD_CAPACITY the mAX_PON_CARD_CAPACITY to set
		 */
		public static void setMAX_PON_CARD_CAPACITY(int mAX_PON_CARD_CAPACITY) {
			MAX_PON_CARD_CAPACITY = mAX_PON_CARD_CAPACITY;
		}

		/**
		 * @return the mAX_DATA_BUFFER
		 */
		public static int getMAX_DATA_BUFFER() {
			return MAX_DATA_BUFFER;
		}

		/**
		 * @param mAX_DATA_BUFFER the mAX_DATA_BUFFER to set
		 */
		public static void setMAX_DATA_BUFFER(int mAX_DATA_BUFFER) {
			MAX_DATA_BUFFER = mAX_DATA_BUFFER;
		}

		public ArrayList<VESCard> getVes() {
			return ves;
		}

		public void setVes(ArrayList<VESCard> ves) {
			this.ves = ves;
		}

		public ArrayList<WirelessCard> getWc() {
			return wc;
		}
		public void setWc(ArrayList<WirelessCard> wc) {
			this.wc = wc;
		}

		public static int getMAX_WIRELESS_CARD_CAPACITY() {
			return MAX_WIRELESS_CARD_CAPACITY;
		}

		public static void setMAX_WIRELESS_CARD_CAPACITY(
				int mAX_WIRELESS_CARD_CAPACITY) {
			MAX_WIRELESS_CARD_CAPACITY = mAX_WIRELESS_CARD_CAPACITY;
		}

		public static int getMAX_VES_CAPACITY() {
			return MAX_VES_CAPACITY;
		}

		public static void setMAX_VES_CAPACITY(int mAX_VES_CAPACITY) {
			MAX_VES_CAPACITY = mAX_VES_CAPACITY;
		}

		
		
		
		
}
