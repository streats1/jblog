package com.bit2017.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
private SqlSession sql;
	public boolean join(UserVo vo) {
		int count = sql.insert("user.insert", vo);
		return count ==1;

		
	}

	public UserVo login(String id, String password) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("password",password);
		System.out.println("id==========password" + id + password);
		return 	sql.selectOne("user.getbyEmailandPassword", map);
	
		// TODO Auto-generated method stub
		
	}

}
