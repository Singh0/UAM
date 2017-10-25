package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.CircleDao;
import com.uam.dao.GenericDao;
import com.uam.entity.Circle;

@Component
public class CircleDaoImpl extends GenericDao<Integer, Circle> implements CircleDao {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Circle> fetchCircleByLOB(int lobId) {
		//String hql = "SELECT P.id ,P.productName FROM ProductMSTR AS P";
		try {
			return findByNamedQuery("Circle.findCircleByLobId", "id", lobId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Circle findCirclebyId(int circleMstrId) {
		try {
			return findById(circleMstrId, Circle.class);
		} catch (Exception e) {
		}
		return null;
	}
}
