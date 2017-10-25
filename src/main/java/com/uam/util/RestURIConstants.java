/**
 * 
 */
package com.uam.util;

/**
 * @author Beeru Singh
 *
 */
public interface RestURIConstants {

	 String GET_ALLLOB_URL   = "/rest/lob";
	 String GET_ALLPRODUCT_URL   = "/rest/allProduct";
	 String GET_PRODUCTBYLOB_ID_URL = "/rest/product/{lobId}";
	 String GET_CIRCLE_LOBBY_URL = "/rest/circle/{lob}";
	 String GET_ZONE_BYCIRCLE_URL ="/rest/zone/{circle}";
	 String GET_CITY_BYZONE_URL ="/rest/city/{zone}";
	 String GET_CITY_ZONE_BYCITY_URL ="/rest/cityzone/{city}";
	 
	 
	 //leads relative URl 
	 
	 String CREATE_LEAD_URL ="/rest/lead/createlead";
	 String UPDATE_LEAD_DATA_URL = "/rest/lead/updatelead";
	 String RETRIEVED_LEADDATA_URL = "/rest/leadData/{lead}/{mobile}";
	 String GET_USER_CURRENT_STATUS = "/rest/uam/user/status/location";
	 
}
