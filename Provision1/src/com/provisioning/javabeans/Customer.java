package com.provisioning.javabeans;

// customer table needs to be updated according  to the json string from om  
public class Customer {

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
		private int STATE_ID;
		private ONT ont;
		private VoicePort vp;
		private VideoCard vc;
		private DataCard dc;
		private PonPort pp;
		private WirelessCard wc;
		private VESCard vesc;
	//	private PonCard ponc;
	//	private DSLAM dslam;
		private String dslamId;
		
		public String getDslamId() {
			return dslamId;
		}
		public void setDslamId(String dslamId) {
			this.dslamId = dslamId;
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
		public VESCard getVesc() {
			return vesc;
		}
		public void setVesc(VESCard vesc) {
			this.vesc = vesc;
		}
		
		public int getCUSTOMER_ID() {
			return CUSTOMER_ID;
		}
		/**
		 * @param cUSTOMER_ID the cUSTOMER_ID to set
		 */
		public void setCUSTOMER_ID(int cUSTOMER_ID) {
			CUSTOMER_ID = cUSTOMER_ID;
		}
		public int getSTATE_ID() {
			return STATE_ID;
		}
		/**
		 * @param cUSTOMER_ID the cUSTOMER_ID to set
		 */
		public void setSTATE_ID(int sTATE_ID) {
			STATE_ID = sTATE_ID;
		}
		/**
		 * @return the fIRST_NAME
		 */
		public String getFIRST_NAME() {
			return FIRST_NAME;
		}
		/**
		 * @param fIRST_NAME the fIRST_NAME to set
		 */
		public void setFIRST_NAME(String fIRST_NAME) {
			FIRST_NAME = fIRST_NAME;
		}
		/**
		 * @return the lAST_NAME
		 */
		public String getLAST_NAME() {
			return LAST_NAME;
		}
		/**
		 * @param lAST_NAME the lAST_NAME to set
		 */
		public void setLAST_NAME(String lAST_NAME) {
			LAST_NAME = lAST_NAME;
		}
		/**
		 * @return the tYPE
		 */
		public String getTYPE() {
			return TYPE;
		}
		/**
		 * @param tYPE the tYPE to set
		 */
		public void setTYPE(String tYPE) {
			TYPE = tYPE;
		}
		public String getSTREETNAME() {
			return STREETNAME;
		}
		/**
		 * @param sTREETNAME the sTREETNAME to set
		 */
		public void setSTREETNAME(String sTREETNAME) {
			STREETNAME = sTREETNAME;
		}
		/**
		 * @return the zIPCODE
		 */
		public int getZIPCODE() {
			return ZIPCODE;
		}
		/**
		 * @param zIPCODE the zIPCODE to set
		 */
		public void setZIPCODE(int zIPCODE) {
			ZIPCODE = zIPCODE;
		}
		/**
		 * @return the cITY
		 */
		public String getCITY() {
			return CITY;
		}
		/**
		 * @param cITY the cITY to set
		 */
		public void setCITY(String cITY) {
			CITY = cITY;
		}
		/**
		 * @return the sTATE
		 */
		public String getSTATE() {
			return STATE;
		}
		/**
		 * @param sTATE the sTATE to set
		 */
		public void setSTATE(String sTATE) {
			STATE = sTATE;
		}
		/**
		 * @return the cOUNTRY
		 */
		public String getCOUNTRY() {
			return COUNTRY;
		}
		/**
		 * @param cOUNTRY the cOUNTRY to set
		 */
		public void setCOUNTRY(String cOUNTRY) {
			COUNTRY = cOUNTRY;
		}
		
		public String toString()
		{
			return "got the customer bean modify toString to get details ";
		}
		/**
		 * @return the ont
		 */
		public ONT getOnt() {
			return ont;
		}
		/**
		 * @param ont the ont to set
		 */
		public void setOnt(ONT ont) {
			this.ont = ont;
		}
		/**
		 * @return the vp
		 */
		public VoicePort getVp() {
			return vp;
		}
		/**
		 * @param vp the vp to set
		 */
		public void setVp(VoicePort vp) {
			this.vp = vp;
		}
		/**
		 * @return the vc
		 */
		public VideoCard getVc() {
			return vc;
		}
		/**
		 * @param vc the vc to set
		 */
		public void setVc(VideoCard vc) {
			this.vc = vc;
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
