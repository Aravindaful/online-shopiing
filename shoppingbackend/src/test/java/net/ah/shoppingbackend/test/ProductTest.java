package net.ah.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ah.shoppingbackend.dao.ProductDAO;
import net.ah.shoppingbackend.dto.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ah.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	/*
	 * @Test public void testProductGet() {
	 * 
	 * assertEquals("Successfully fetched the single product","iphone 5s",productDAO
	 * .get(1).getName()); }
	 * 
	 * 
	 * 
	 * @Test public void testProductList() {
	 * 
	 * assertEquals("Successfully fetched the lsit of products",7,productDAO.list().
	 * size()); }
	 * 
	 */

	/*
	@Test
	public void testProductList() {
		Product product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones !");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Successfully add a single product", true, productDAO.add(product));
	}
	
	*/
	
	
	@Test
	public void testListActiveProducts() {
		assertEquals("something went wrong while fetching the list of products !", 8,
				productDAO.listActiveProducts().size());

	 
	}
	
	@Test
	public void testListActiveProductsByCategory() {
	
		assertEquals("something went wrong while fetching the list of products !", 5,
				productDAO.listActiveProductsByCategory(3).size());
		 
		assertEquals("something went wrong while fetching the list of products !", 3,
				productDAO.listActiveProductsByCategory(2).size());  
	}
	
	@Test
	public void testGetLatestActiveProducts() {
	
		assertEquals("something went wrong while fetching the list of products !", 3,
				productDAO.getLatestActiveProducts(3).size());
		  
	}

}
