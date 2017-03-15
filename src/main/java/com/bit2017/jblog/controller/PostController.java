package com.bit2017.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2017.jblog.service.CategoryService;
import com.bit2017.jblog.service.PostService;
import com.bit2017.jblog.vo.CategoryVo;
import com.bit2017.jblog.vo.PostVo;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	@Autowired
	private CategoryService categoryS;
	@RequestMapping("/{id}/admin/write")
	public String write(@ModelAttribute PostVo vo,Model model,@PathVariable String id){
		System.out.println("여기가 포스트 vovovovovovovovovo" + vo);
		 service.write(vo);
		 
				return "redirect:/{id}";
		
	}
	@RequestMapping("/{id}/admin/write1")
	public String write1(Model model){
		List<CategoryVo> list = categoryS.list();
		
		model.addAttribute("list",list);
		System.out.println("포스트 vovovovovovovovovo" + list);
		return "/blog/blog-admin-write";
		
	}
	@RequestMapping("/{id}/admin/list")
	public String list(@ModelAttribute PostVo vo,Model model){
		
		return "blog/blog-main"; //웹에 정보는 잘받음 그런데 콘솔엔 엉뚱한게 찍혀있음.디폴트 벨류 왜 1이 들어가야 오류가 안나는지 질문.
		  
	}

}
