package com.bit2017.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.service.BlogService;
import com.bit2017.jblog.service.CategoryService;
import com.bit2017.jblog.service.PostService;
import com.bit2017.jblog.vo.BlogVo;
import com.bit2017.jblog.vo.CategoryVo;
import com.bit2017.jblog.vo.PostVo;

@Controller
public class BlogController {
	@Autowired
	private PostService postS;
	@Autowired
	private BlogService service;
	@Autowired
	private CategoryService categoryS;

	@RequestMapping("/{id}") //
	public String introducing(@PathVariable String id, Model model,
			@RequestParam(value = "PostNo", required = true, defaultValue = "0") int postNo,
			@RequestParam(value = "no", required = true, defaultValue = "0") int no,@ModelAttribute CategoryVo categoryvo
			,HttpSession session)
	{
		BlogVo vo = new BlogVo();
		vo = service.getphoto(id);
	session.setAttribute("title",vo.getTitle());
		System.out.println("여기엔 뭐가 찍혀요?" + vo);//사진
		model.addAttribute("vo", vo);

		/**/
		
		if(no != 0 ){
			List<PostVo> categoryList = postS.getC(no);
			model.addAttribute("categoryList",categoryList );
			System.out.println("포스트 리스트 넘어 옵니까???????????" + categoryList);
		}else{
			List<PostVo> categoryList = postS.list();
			System.out.println("리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트 " + categoryList);//포스트 글 불러오기
			model.addAttribute("categoryList", categoryList);
		}
		 
		
		if(no != 0 && postNo !=0)
		{
			PostVo view = postS.giveNo(no, postNo);
			System.out.println("다 받아오냐??????????????????????????" + view);//메인 찍은글
			model.addAttribute("view", view);
			
		}
		else{
			 List<PostVo> view = postS.gettop();
			 PostVo vo1 = view.get( 0 );
			 
			 System.out.println("뷰가 옵니까??????????????" + view);

//			 PostVo view1 = postS.gettop1(view);
			 model.addAttribute("vo1", vo1); // 최신글
			 
		}
		

		
		/*PostVo view1 = postS.getposttitle();
		System.out.println("다 받아오냐??????????????????????????" + view);//메인 찍은글
		model.addAttribute("view", view);*/
		
		
		
		
		List<CategoryVo> category = categoryS.getCa();
		model.addAttribute("category",category );
		System.out.println("카테고리 넘어 옵니까???????????" + category);
		
		
		
		/*CategoryVo vo1 = categoryS.categoryno(no);
			if(vo1 == null ){
				List<PostVo> list2 = postS.list2(no);
			}
			else{
				
			}*/
		

		return "/blog/blog-main";

	}

	@RequestMapping("/{id}/admin/basic") //
	public String fixing(@PathVariable String id, Model model,HttpSession session) {
		BlogVo vo = new BlogVo();
		
		vo = service.getphoto(id);
		session.setAttribute("title",vo.getTitle());
		model.addAttribute("vo", vo);
		System.out.println("어드민 베이직 = == = = = = =" + id);
		return "/blog/blog-admin-basic";

	}

	@RequestMapping("/{id}/changing")
	public String changing(@RequestParam("blogId") String blogId, @RequestParam("title") String title,
			@RequestParam("logo") MultipartFile logo, Model model) {
		System.out.println(
				"vovovovovovovovovovvoovvovovovovovovovo" + "블로그 =" + blogId + "타이틀 =" + title + "로고 = " + logo);
		System.out.println("id =========");

		service.update(blogId, title, logo);
		// model.addAttribute("",vo);
		System.out.println("final = = = = = =" + logo);
		return "redirect:/{id}";

	}

	@RequestMapping("/{id}/write")
	public String writer(@ModelAttribute PostVo vo) {

		return "/blog/blog-admin-write";
	}

	@RequestMapping("/{id}/write1")
	public String writer1(@ModelAttribute PostVo vo) {
		service.write(vo);
		return "/blog/blog-admin-write";
	}

}
