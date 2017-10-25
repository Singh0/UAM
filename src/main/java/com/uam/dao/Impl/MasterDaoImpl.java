package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.GenericDao;
import com.uam.dao.MasterDao;
import com.uam.entity.ProductLobMaster;

@Component
public class MasterDaoImpl  extends GenericDao<Integer, ProductLobMaster> implements MasterDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Autowired
	private SessionFactory sessionFactory;*/
	//@Autowired
	//GenericDao genrs;
	/*@PersistenceContext 
	private EntityManager entityManager;*/
	/*MasterDao(){
		System.out.println("kkkkkkkkkkkkkkkkk");
	}*/
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductLobMaster> fetchAllProductLob() {
		//System.out.println("-----hjghjghjgjhghjghjg-----SELECT P.id ,P.productLobName ,P.status---");
		String hql = " FROM ProductLobMaster AS P";
		try {
			return findByQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
