package com.uam.dao.Impl;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.uam.dao.GenericDao;
import com.uam.dao.UserDao;
import com.uam.entity.UserMaster;

@Component
public class UserDaoImpl extends GenericDao<Integer, UserMaster> implements UserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String findMobileNo(String mobile) {
		try {
		//	Object object  = findSingleResult("SELECT COUNT(1) FROM UserMaster WHERE mobile ="+mobile);
			Query jpaQuery = getEntityManager().createQuery("SELECT COUNT(1) FROM UserMaster WHERE mobile ='"+mobile+"'");
			long mob  = (Long)jpaQuery.getSingleResult();
			System.out.println(mob);
			return ""+mob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
