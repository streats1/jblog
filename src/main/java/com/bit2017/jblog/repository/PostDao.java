package com.bit2017.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.PostVo;
@Repository
public class PostDao {
@Autowired
private SqlSession sql;
	public boolean write(PostVo vo) {
		   int count= sql.insert("post.write",vo);
		   return count == 1;
	}
	/*public boolean list() {
		return sql.;
		
	}*/
	public List<PostVo> list() {
		return	sql.selectList("post.List");
		
	}
	public PostVo giveNo(int no, int postNo) {
		PostVo vo = new PostVo();
		vo.setNo(no);
		vo.setPostNo(postNo);
		System.out.println("각종 넘버들 ======" + no + postNo);
		PostVo as = sql.selectOne("post.giveNo",vo);
		System.out.println("제일중요한거 !!!!!!!!!!!!!!!!!!!!" + as);
		return as;
	}
	public List<PostVo> getC(int no) {
		return sql.selectList("post.getlistpost",no);
	}
	public PostVo getposttitle() {
		return 	sql.selectOne("post.getposttitle");
		
	}
	public PostVo maxno() {
		PostVo vo = new PostVo();
		
		return sql.selectOne("post.maxno"); 
		
	}
	public List<PostVo> gettop() {
		return sql.selectList("post.gettop");
	}
	public PostVo gettop1(List<PostVo> view) {
		
		return sql.selectOne("post.gettop1",view);
	}
	}


