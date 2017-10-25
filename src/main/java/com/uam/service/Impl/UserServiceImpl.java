package com.uam.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uam.dao.GenericDao;
import com.uam.dao.UserDao;
import com.uam.entity.UserMaster;
import com.uam.service.UserService;


@Service
public class UserServiceImpl extends GenericDao<Integer, UserMaster>implements UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDao userDao;
	
	@Override
	public String findMobileNo(String mobile) {
		// TODO Auto-generated method stub
		return userDao.findMobileNo(mobile);
	}

}
