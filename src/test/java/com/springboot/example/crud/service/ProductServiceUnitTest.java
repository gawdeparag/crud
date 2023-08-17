package com.springboot.example.crud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.example.crud.entity.Product;
import com.springboot.example.crud.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceUnitTest {
	
	@InjectMocks
	@Autowired
	private ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void saveProduct() {
		Product product1 = new Product();
		product1.setName("Books");
		product1.setPrice(8000.00);
		product1.setQuantity(90);
		
		productService.saveProduct(product1);
		
		Product productResult = productService.getProductById(product1.getId()); 
		
		assertEquals(productResult.getName(), product1.getName());
		assertEquals(productResult.getQuantity(), product1.getQuantity());
		assertEquals(productResult.getPrice(), product1.getPrice());
	}
	
	@Test
	public void getProducts() {
		List<Product> products = productService.getProducts();
		
		assertNotEquals(products, null);
		assertNotEquals(products.size(), 0);
		
	}
	
	@Test
	public void getProductById() {
		Product productResult = productService.getProductById(1);
		
		assertNotEquals(productResult, null);
	}
	
	@Test
	public void getProductByName() {
		Product productResult = productService.getProductByName("Laptops");
		
		assertNotEquals(productResult, null);
	}
}
