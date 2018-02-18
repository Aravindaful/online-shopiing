package net.ah.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ah.onlineshopping.util.FileUploadUtility;
import net.ah.shoppingbackend.dao.CategoryDAO;
import net.ah.shoppingbackend.dao.ProductDAO;
import net.ah.shoppingbackend.dto.Category;
import net.ah.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
    
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nproduct = new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		
		
		
		mv.addObject("product",nproduct);
		 
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product submitted successfully!");
				mv.addObject("msgType","successful");
			}
		}
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,Model model,HttpServletRequest request) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation failed for product submission!");
			model.addAttribute("msgType","fail");
			return "page";
		}
		
		
		
		logger.info(mProduct.toString());
		
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
}
