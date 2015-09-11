package com.provisioning.javabeans;

public class ONT {

		private String ONT_ID;
		private String STATUS;
		private PonPort pp;	// check if needed
		//private Customer customer;   // check if needed
		/**
		 * @return the oNT_ID
		 */
		public String getONT_ID() {
			return ONT_ID;
		}
		/**
		 * @param oNT_ID the oNT_ID to set
		 */
		public void setONT_ID(String oNT_ID) {
			ONT_ID = oNT_ID;
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
