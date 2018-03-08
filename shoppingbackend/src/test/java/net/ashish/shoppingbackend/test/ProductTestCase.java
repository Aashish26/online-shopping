package net.ashish.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ashish.shoppingbackend.dao.ProductDAO;
import net.ashish.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ashish.shoppingbackend.config");
		context.scan("net.ashish.shoppingbackend.daoimpl");
		context.refresh();
		System.out.println("refresh done");
		productDAO = (ProductDAO) context.getBean("productDAO");
		System.out.println(productDAO);
	}

	/*@Test
	public void testCRUDCategory() {

		// adding a category in the table.
		product = new Product();
		product.setName("Oppq Selfie S53");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Somthing went wrong while inserting a new product!", true, productDAO.add(product));

		// fetching and updating a category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Somthing went wrong while updating the existing record!", true, productDAO.update(product));

		// Deleting a category
		assertEquals("Somthing went wrong while deleting the existing record!", true, productDAO.delete(product));

		// Fetching the list
		assertEquals("Successfully fetched a list of category from the table", 6 , productDAO.list().size());

	}*/
	
	
	/*@Test
	public void testListActiveProducts(){
		
		assertEquals("Successfully fetched a list of category from the table", 5 , productDAO.listActiveProducts().size());
	}*/
	
	
	@Test
	public void testListActiveProductsByCategory(){
		
		assertEquals("Successfully fetched a list of category from the table", 3 , productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Successfully fetched a list of category from the table", 2 , productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testLatestActiveProduct(){
		
		assertEquals("Successfully fetched a list of category from the table", 3 , productDAO.getLatestActiveProducts(3).size());
		
	}
	
	
}