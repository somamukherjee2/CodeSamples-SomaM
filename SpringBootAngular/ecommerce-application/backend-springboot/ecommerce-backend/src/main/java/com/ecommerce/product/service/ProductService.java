package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.model.Product;

public interface ProductService {
	/**
	 * @param Product the Product to be added
	 * @return the Product that has been added
	 * @apiNote creates a new Product
	 */
	Product saveProduct(Product product);
	/**
	 * @return List of Product Objects
	 * @apiNote returns all the Products
	 */
	List<Product> getAllProducts();
	/**
	 * @param id
	 * @return
	 * @apiNote Returns Product object if found else throws ResourceNotFoundException 
	 */
	Product getProductById(long id);
	/**
	 * @param Product contains fields to be updated
	 * @param id the Product id
	 * @return the updated Product
	 * @apiNote Checks with id if Product present.Returns updated Product if present else throws ResourceNotFoundException
	 */
	Product updateProduct(Product product,long id);
	/**
	 * @param id the Product id
	 * @apiNote Checks with id if Product present.Deletes Product if present else throws ResourceNotFoundException
	 */
	void deleteProduct(long id);
	
	/**
	 * @param List<Product> List of Product Objects
	 * @param categoryId the Category id
	 * @return the List of Products for the Category Id
	 * @apiNote the List of Products for the Category Id
	 */
	List<Product> getProductByCategoryId(long categoryId);
	
	/**
	 * @param List<Product> List of Product Objects
	 * @param searchString the searchString
	 * @return the List of Products for the searchString
	 * @apiNote the List of Products for the searchString
	 */
	List<Product> getProductBySearchString(String searchString);


}
