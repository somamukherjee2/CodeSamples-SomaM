package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;

/**
 * @author Soma Mukherjee
 * @apiNote The Rest Api Controller for Product Api Calls
 * @version 1.0.0
 *
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	/**
	 * @param product
	 * @return ResponseEntity with the Product Object and Status Code
	 * @apiNote Creates a new Product
	 */
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	/**
	 * @return List of Product Objects
	 * @apiNote Fetches all Products
	 */
	@GetMapping()
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}

	/**
	 * @param id
	 * @return ResponseEntity with the Product Object and Status Code
	 * @apiNote Fetches an Product with Id
	 */
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

	/**
	 * @param product
	 * @param id
	 * @return ResponseEntity with the Product Object and Status Code
	 * @apiNote Updates an Product with Id
	 */
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long id) {
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity with the delete message and Status Code
	 * @apiNote Deletes an Product with Id
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product Deleted Successfully!!!", HttpStatus.OK);
	}
	/**
	 * @return List of Product Objects
	 * @apiNote Fetches all Products
	 */
	@GetMapping(value = "/category/{categoryId}")
	public List<Product> getAllProductByCategory(@PathVariable("categoryId") long categoryId) {
		return productService.getProductByCategoryId(categoryId);
	}
	
	/**
	 * @return List of Product Objects
	 * @apiNote Fetches all Products
	 */
	@GetMapping(value = "/search/{searchString}")
	public List<Product> getProductBySearchString(@PathVariable("searchString") String searchString) {
		return productService.getProductBySearchString(searchString);
	}

}
