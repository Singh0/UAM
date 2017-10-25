package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.GenericDao;
import com.uam.dao.ProductDao;
import com.uam.entity.ProductMSTR;

@Component
public class ProductDaoImpl extends GenericDao<Integer, ProductMSTR>implements ProductDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<ProductMSTR> fetchAllProduct() {
		String hql = "SELECT P.id ,P.productName FROM ProductMSTR AS P";
		try {
			return findByQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductMSTR> fetchProductByLOB(int lobId) {
		//String hql = "SELECT P.id ,P.productName FROM ProductMSTR AS P";
		try {
			return findByNamedQuery("ProductMSTR.findByLobId", "id", lobId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
