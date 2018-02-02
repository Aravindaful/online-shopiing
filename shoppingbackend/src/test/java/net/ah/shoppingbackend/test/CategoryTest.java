package net.ah.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ah.shoppingbackend.dao.CategoryDAO;
import net.ah.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ah.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("Cat1.png");
		assertEquals("Successfully added a category inside a table!",true,categoryDAO.add(category));
	}
	
	
	
	@Test
	public void testGetCategory() {
		 category =categoryDAO.get(3);
		 assertEquals("Successfully fetched the single category from the table!","Mobile",category.getName());
		 
	}
	
	
	
	@Test
	public void testUpdateCategory() {
		 category =categoryDAO.get(4);
		 category.setName("Radio");
		 assertEquals("Successfully updated the single category from the table!",true,categoryDAO.update(category));
		 
	}
	
	

	@Test
	public void testDeleteCategory() {
		 category =categoryDAO.get(4);
		 assertEquals("Successfully deleted the single category from the table!",true,categoryDAO.delete(category));
		 
	}
	
	
	
	@Test
	public void testListCategory() {
		  
		 assertEquals("Successfully fetched the list of category from the table!",3,categoryDAO.list().size());
		 
	}
	
	*/
	
}
