package net.ah.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ah.shoppingbackend.dao.CategoryDAO;
import net.ah.shoppingbackend.dao.ProductDAO;
import net.ah.shoppingbackend.dto.Category;
import net.ah.shoppingbackend.dto.Product;


 

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
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

	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		Product product =productDAO.get(id);
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
}
