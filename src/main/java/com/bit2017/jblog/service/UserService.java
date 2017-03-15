package com.bit2017.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.UserDao;
import com.bit2017.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public boolean join(UserVo vo) {
		return dao.join(vo); 
		  
		 
	}
	
	
	public UserVo login(String id, String password) {

		return dao.login(id,password); 
		
	}

}
