package com.uam.dao;

import java.util.List;

import com.uam.entity.ProductMSTR;

public interface ProductDao {

	List<ProductMSTR> fetchAllProduct();
	List<ProductMSTR> fetchProductByLOB(int lobId);
}
