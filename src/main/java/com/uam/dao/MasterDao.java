package com.uam.dao;

import java.util.List;

import com.uam.entity.ProductLobMaster;
import com.uam.entity.ProductMSTR;

public interface MasterDao {

	 List<ProductLobMaster> fetchAllProductLob();
	 
}
