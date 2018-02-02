package net.ah.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ah.shoppingbackend.dao.CategoryDAO;
import net.ah.shoppingbackend.dto.Category;


 

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value= {"/","/home","/index"})
	 public ModelAndView index() {
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Home");
		  mv.addObject("userClickHome",true);
		  mv.addObject("categories",categoryDAO.list());
		  return mv;
	 }
	
	
	@RequestMapping(value= "/about")
	 public ModelAndView about() {
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","About US");
		  mv.addObject("userClickAbout",true);
		  return mv;
	 }
	
	@RequestMapping(value= "/contact")
	 public ModelAndView contact() {
		  ModelAndView mv = new ModelAndView("page");
		  mv.addObject("title","Contact");
		  mv.addObject("userClickContact",true);
		  return mv;
	 }
	
	
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(required=false) String greeting) {
		if(greeting == null) {
			greeting ="welcome" ;
		}
		ModelAndView mv = new ModelAndView("page");
		  mv.addObject("greetings",greeting);
		  return mv;
	}
	
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable() int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category =categoryDAO.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}

}
