package com.bit2017.jblog.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.vo.BlogVo;
import com.bit2017.jblog.vo.PostVo;

@Repository
public class BlogDao {
	private static final String URL = "jblog/";
	private static final String SAVE_PATH = "/Upload";
	@Autowired
	private SqlSession sql;
	public boolean update(String blogId,String title, MultipartFile logo) 
	{
		BlogVo vo = new BlogVo();
		String url = "";
		try{
		if(logo.isEmpty() == true){
			return  false;
		} 
		
		String originalFileName = logo.getOriginalFilename();
		System.out.println("originalFileName==========="+originalFileName);
		Long fileSize = logo.getSize();
		String extName = originalFileName.substring(originalFileName.lastIndexOf(".")+1,originalFileName.length());
	
		
		String saveFileName = generateSaveFileName(extName);
		System.out.println("getnerateSaveFileName = = = =" +  saveFileName);
		
		url = URL + saveFileName;
		System.out.println("#########" + originalFileName);
		System.out.println("#########" + fileSize);
		System.out.println("#########" + extName);
		System.out.println("#########" + saveFileName); 
		vo.setLogo(saveFileName);
		vo.setTitle(title);
		vo.setBlogId(blogId);
		writeFile(logo,saveFileName);//해주는 이유
		}catch (Exception e) {
			System.out.println("eeeeeeeeeee" + e);
		}
		System.out.println("url = = = = = = =" + url);
		System.out.println("blogid = = = = = =" + blogId);
		System.out.println("title = = = = = =" +title);
		System.out.println("log = = = = =" + logo );
		int count = sql.update("blog.update",vo);
		return count == 1;
		
	}
	private void writeFile(MultipartFile file,String saveFileName)throws IOException
	{
		byte[] data = file.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" +saveFileName);
		fos.write(data);
		fos.close();
		
	}
	private String generateSaveFileName(String extName)
	{
		String fileName="";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE); 
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += ("." + extName);
		return fileName;
		
	}
	public boolean write(PostVo vo){
		return false;
		
		
	}
	public BlogVo getphoto(String id) {

		return sql.selectOne("blog.select",id);
	}
	public BlogVo getphoto1() {

		return sql.selectOne("blog.select1");
	}
	}


