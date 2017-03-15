package com.bit2017.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.CategoryVo;
@Repository
public class CategoryDao {
	@Autowired
	private SqlSession session;
	
	public List<CategoryVo> list() {
		
		List<CategoryVo> list = session.selectList("category.getList");
		System.out.println("vovovovovovovovovovovovovo = = = ==" + list);
		
		return list;
		
	}

	public boolean add(CategoryVo vo) {
		
		System.out.println("add  = = = =vovovo = = = = =" + vo );
		 int count= session.insert("category.insert",vo );
		return count==1;
		 
				
	}

	public boolean delete(CategoryVo vo) {
		session.delete("category.delete",vo);
		return false;
		
	}

	public CategoryVo categoryno(int no) {
		session.selectOne("category.categoryno",no);
		return null;
		
	}

	public List<CategoryVo> getCa() {
		return session.selectList("category.getCa");
	}

}
