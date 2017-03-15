package com.bit2017.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.repository.BlogDao;
import com.bit2017.jblog.vo.BlogVo;
import com.bit2017.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
private BlogDao dao;
	public boolean update(String blogId,String title, MultipartFile logo) {
		System.out.println("2service title logo" +"blogId ="+blogId +"title ="+ title+"logo ="+logo);
		return	dao.update(blogId,title,logo);
		 
		
	}
	/*public boolean write(PostVo vo) {
		int count= dao.write(vo);
		return count ==1;
	}*/
	public BlogVo getphoto(String id) {
		return	dao.getphoto(id);
		
	}
	public BlogVo getphoto1() {
		return	dao.getphoto1();
		
	}
	public void write(PostVo vo) {
		// TODO Auto-generated method stub
		
	}
		

}
