package com.springboot.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.crud.entity.Product;
import com.springboot.example.crud.service.ProductService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.saveProduct(product);
	}
	
	@PostMapping("/add/products")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}
	
	@GetMapping("/all")
	public List<Product> findAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Product findProductByName(@RequestParam(value="name") String name) {
		return productService.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Successfully deleted product", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "Couldn't find the product")
	})
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
}
