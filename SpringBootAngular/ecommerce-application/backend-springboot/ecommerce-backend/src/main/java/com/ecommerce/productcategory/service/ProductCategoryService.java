package com.ecommerce.productcategory.service;

import java.util.List;

import com.ecommerce.productcategory.model.ProductCategory;

public interface ProductCategoryService {
	/**
	 * @param ProductCategory the ProductCategory to be added
	 * @return the ProductCategory that has been added
	 * @apiNote creates a new ProductCategory
	 */
	ProductCategory saveProductCategory(ProductCategory productCategory);
	/**
	 * @return List of ProductCategory Objects
	 * @apiNote returns all the ProductCategorys
	 */
	List<ProductCategory> getAllProductCategorys();
	/**
	 * @param id
	 * @return
	 * @apiNote Returns ProductCategory object if found else throws ResourceNotFoundException 
	 */
	ProductCategory getProductCategoryById(long id);
	/**
	 * @param ProductCategory contains fields to be updated
	 * @param id the ProductCategory id
	 * @return the updated ProductCategory
	 * @apiNote Checks with id if ProductCategory present.Returns updated ProductCategory if present else throws ResourceNotFoundException
	 */
	ProductCategory updateProductCategory(ProductCategory productCategory,long id);
	/**
	 * @param id the ProductCategory id
	 * @apiNote Checks with id if ProductCategory present.Deletes ProductCategory if present else throws ResourceNotFoundException
	 */
	void deleteProductCategory(long id);


}
