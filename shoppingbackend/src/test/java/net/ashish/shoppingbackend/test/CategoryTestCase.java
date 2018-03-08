package net.ashish.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ashish.shoppingbackend.dao.CategoryDAO;
import net.ashish.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ashish.shoppingbackend.config");
		context.scan("net.ashish.shoppingbackend.daoimpl");
		context.refresh();
		System.out.println("refresh done");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		System.out.println(categoryDAO);
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); //category.setActive(true);
	 * 
	 * category.setName("laptop"); category.setDescription(
	 * "This is some description for laptop!");
	 * category.setImageURL("CAT_448.png");
	 * 
	 * assertEquals("laptop done", true, categoryDAO.add(category));
	 * 
	 * 
	 * }
	 */

	/*@Test
	public void testGetCategory() {

		category = categoryDAO.get(3);
		
		assertEquals("Successfully fetched a single category from the table", "laptop", category.getName());

	}*/
	
	
	
	/*@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(3);
		category.setName("lappy");
		
		assertEquals("Successfully fetched a single category from the table", true, categoryDAO.update(category));

	}
*/
	
	/*@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(3);		
		assertEquals("Successfully fetched a single category from the table", true, categoryDAO.delete(category));

	}*/
	
	
	/*@Test
	public void testListCategory() {

				
		assertEquals("Successfully fetched a list of category from the table",2, categoryDAO.list().size()); 

	}
*/
	
	@Test
	public void testCRUDCategory(){
	
		// adding a category in the table.
		  category = new Category(); //category.setActive(true);		 
		  category.setName("laptop"); category.setDescription(
		  "This is some description for laptop!");
		  category.setImageURL("CAT_001.png");		  
		  assertEquals("Successfully added a category of laptop in the table", true, categoryDAO.add(category));
		  
		  category = new Category(); //category.setActive(true);			 
		  category.setName("Television"); 
		  category.setDescription("This is some description for Television!");
		  category.setImageURL("CAT_002.png");		  
		  assertEquals("Successfully added a category of Television in the table", true, categoryDAO.add(category));
		  
		  
		// fetching and updating a category
		   category = categoryDAO.get(2);
		   category.setName("TV");			
		   assertEquals("Successfully fetched a single category from the table", true, categoryDAO.update(category));
		   
		// Deleting a category		   	
		   assertEquals("Successfully deleted a single category from the table", true, categoryDAO.delete(category));
			
		// Fetching the list
		   assertEquals("Successfully fetched a list of category from the table",1, categoryDAO.list().size());
		   
	}
}