package net.ah.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.ah.shoppingbackend.dao.CategoryDAO;
import net.ah.shoppingbackend.dto.Category;
import net.ah.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
    
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nproduct = new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		
		mv.addObject("product",nproduct);
		 
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
}