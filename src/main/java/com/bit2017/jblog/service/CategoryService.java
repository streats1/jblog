package com.bit2017.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.CategoryDao;
import com.bit2017.jblog.vo.CategoryVo;
import com.bit2017.jblog.vo.PostVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao dao;
	
	public List<CategoryVo> list() {

		List<CategoryVo> list = dao.list();
		System.out.println("vovovovovovovovovovovovovo = = = ==" + list);

		return 	list;
		 
		
	}

	public boolean add(CategoryVo vo) {
		
		return dao.add(vo);
		
	}

	public boolean delete(CategoryVo vo) {
		return dao.delete(vo);
	}

	public CategoryVo categoryno(int no) {
		dao.categoryno(no);
		return null;
	}

	public List<CategoryVo> getCa() {
		return 	dao.getCa();
		
	}


}
