package com.ecommerce.productcategory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.common.exception.ResourceNotFoundException;
import com.ecommerce.productcategory.model.ProductCategory;
import com.ecommerce.productcategory.repository.ProductCategoryRepository;
import com.ecommerce.productcategory.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	private ProductCategoryRepository productCategoryRepository;

	public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
		super();
		this.productCategoryRepository = productCategoryRepository;
	}

	/**
	 * @param productCategory the productCategory to be added
	 * @return the productCategory that has been added
	 * @apiNote creates a new productCategory
	 */
	@Override
	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	/**
	 * @return List of ProductCategory Objects
	 * @apiNote returns all the productCategorys
	 */
	@Override
	public List<ProductCategory> getAllProductCategorys() {
		return productCategoryRepository.findAll();
	}
	
	/**
	 * @param id
	 * @return
	 * @apiNote Returns ProductCategory object if found else throws ResourceNotFoundException 
	 */
	@Override
	public ProductCategory getProductCategoryById(long id) {
		/*
		 * Optional<ProductCategory> productCategory = productCategoryRepository.findById(id); if
		 * (productCategory.isPresent()) { return productCategory.get(); } else { throw new
		 * ResourceNotFoundException("ProductCategory", "Id", id); }
		 */
		return productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "Id", id));
	}
	/**
	 * @param productCategory contains fields to be updated
	 * @param id the productCategory id
	 * @return the updated productCategory
	 * @apiNote Checks with id if productCategory present.Returns updated productCategory if present else throws ResourceNotFoundException
	 */
	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory, long id) {
		// TODO Auto-generated method stub
		ProductCategory existingProductCategory=productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "Id", id));
		existingProductCategory.setCategoryName(productCategory.getCategoryName());
		existingProductCategory.setProducts(productCategory.getProducts());			
		productCategoryRepository.save(existingProductCategory);
		return existingProductCategory;
	}
	/**
	 * @param id the productCategory id
	 * @apiNote Checks with id if productCategory present.Deletes productCategory if present else throws ResourceNotFoundException
	 */
	@Override
	public void deleteProductCategory(long id) {
		productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "Id", id));
		productCategoryRepository.deleteById(id);		
	}

}