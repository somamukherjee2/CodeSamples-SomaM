package com.ecommerce.productcategory.controller;

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

import com.ecommerce.productcategory.model.ProductCategory;
import com.ecommerce.productcategory.service.ProductCategoryService;

/**
 * @author Soma Mukherjee
 * @apiNote The Rest Api Controller for ProductCategory Api Calls
 * @version 1.0.0
 *
 */
@RestController
@RequestMapping("/api/productcategories")
@CrossOrigin("http://localhost:4200")
public class ProductCategoryController {
	private ProductCategoryService productCategoryService;

	public ProductCategoryController(ProductCategoryService productCategoryService) {
		super();
		this.productCategoryService = productCategoryService;
	}

	/**
	 * @param productCategory
	 * @return ResponseEntity with the ProductCategory Object and Status Code
	 * @apiNote Creates a new ProductCategory
	 */
	@PostMapping()
	public ResponseEntity<ProductCategory> saveProductCategory(@RequestBody ProductCategory productCategory) {
		return new ResponseEntity<ProductCategory>(productCategoryService.saveProductCategory(productCategory), HttpStatus.CREATED);
	}

	/**
	 * @return List of ProductCategory Objects
	 * @apiNote Fetches all ProductCategorys
	 */
	@GetMapping()
	public List<ProductCategory> getAllProductCategory() {
		return productCategoryService.getAllProductCategorys();
	}

	/**
	 * @param id
	 * @return ResponseEntity with the ProductCategory Object and Status Code
	 * @apiNote Fetches an ProductCategory with Id
	 */
	@GetMapping("{id}")
	public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable("id") long id) {
		return new ResponseEntity<ProductCategory>(productCategoryService.getProductCategoryById(id), HttpStatus.OK);
	}

	/**
	 * @param productCategory
	 * @param id
	 * @return ResponseEntity with the ProductCategory Object and Status Code
	 * @apiNote Updates an ProductCategory with Id
	 */
	@PutMapping("{id}")
	public ResponseEntity<ProductCategory> updateProductCategory(@RequestBody ProductCategory productCategory, @PathVariable("id") long id) {
		return new ResponseEntity<ProductCategory>(productCategoryService.updateProductCategory(productCategory, id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity with the delete message and Status Code
	 * @apiNote Deletes an ProductCategory with Id
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProductCategoryById(@PathVariable("id") long id) {
		productCategoryService.deleteProductCategory(id);
		return new ResponseEntity<String>("ProductCategory Deleted Successfully!!!", HttpStatus.OK);
	}
	
	
}
