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
import com.bit2017.jblog.vo.CategoryVo;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@RequestMapping("/{id}/admin/category")
	public String list(Model model)
	{
		List<CategoryVo> list = service.list();
		model.addAttribute("list",list);
		System.out.println("vovovovovovovovovovovovovo = = = ==" + list);
		 
		return "/blog/blog-admin-category"; 
		
	}
	@RequestMapping("/{id}/add")
	public String add(@ModelAttribute CategoryVo vo,Model model,@PathVariable String id ){
		System.out.println("add add adadad adadadadadadadad="+ vo); 
		service.add(vo);
		return  "redirect:/{id}/admin/category";
	}
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable String id,@ModelAttribute CategoryVo vo){
		System.out.println("delete vo" + vo);
		service.delete(vo);
		return "redirect:/{id}/admin/category"; 
	}
}
