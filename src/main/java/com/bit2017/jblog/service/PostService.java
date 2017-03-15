package com.bit2017.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.PostDao;
import com.bit2017.jblog.vo.PostVo;
@Service
public class PostService {
	@Autowired
	private PostDao dao;
	public boolean write(PostVo vo) {
		
		return  dao.write(vo);
		  
		 
		 
	}
	/*public List<PostVo> list() {
		dao.list();
		return null;
	}*/
	public List<PostVo> list() {
		return dao.list();
	}
	public PostVo giveNo(int no, int postNo)
	{
		return dao.giveNo(no,postNo);
	}
public List<PostVo> getC(int no) {
		return dao.getC(no);
	}
/*public PostVo getposttitle() {
	return dao.getposttitle();
}*/
public List<PostVo> gettop() {
	return dao.gettop();
}
public PostVo gettop1(List<PostVo> view) {

	return dao.gettop1(view);
	 
}

}
