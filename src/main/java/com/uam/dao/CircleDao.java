package com.uam.dao;

import java.util.List;

import com.uam.entity.Circle;

public interface CircleDao {

	List<Circle> fetchCircleByLOB(int lobId);
	Circle findCirclebyId(int circleMstrId);
}
