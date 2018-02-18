package net.ah.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.ah.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Product product = (Product)target;
		 
		 if(product.getFile() ==null || product.getFile().getOriginalFilename().equals("")) {
			 errors.rejectValue("file", null, "Please select an image file to upload!");//file means Product pojo class file variable
			 return;
		 }
		 
		 if(!(product.getFile().getContentType().equals("image/jpeg") ||
				 product.getFile().getContentType().equals("image/png")||
				 product.getFile().getContentType().equals("image/gif"))) {
			 
			 errors.rejectValue("file", null,"Please use only image file for upload");
			 return;
			 
		 }

	}

}
