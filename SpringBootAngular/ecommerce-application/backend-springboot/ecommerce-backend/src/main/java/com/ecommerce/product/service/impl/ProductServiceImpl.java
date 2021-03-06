package com.ecommerce.product.service.impl;



import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.ecommerce.common.exception.ResourceNotFoundException;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.productcategory.model.ProductCategory;
import com.ecommerce.productcategory.repository.ProductCategoryRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	private ProductCategoryRepository productCategoryRepository;

	public ProductServiceImpl(ProductRepository productRepository,ProductCategoryRepository productCategoryRepository) {
		super();
		this.productRepository = productRepository;		
		this.productCategoryRepository=productCategoryRepository;
	}

	/**
	 * @param product the product to be added
	 * @return the product that has been added
	 * @apiNote creates a new product
	 */
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * @return List of Product Objects
	 * @apiNote returns all the products
	 */
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 * @apiNote Returns Product object if found else throws
	 *          ResourceNotFoundException
	 */
	@Override
	public Product getProductById(long id) {
		/*
		 * Optional<Product> product = productRepository.findById(id); if
		 * (product.isPresent()) { return product.get(); } else { throw new
		 * ResourceNotFoundException("Product", "Id", id); }
		 */
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	}

	/**
	 * @param product contains fiels to be updated
	 * @param id      the product id
	 * @return the updated product
	 * @apiNote Checks with id if product present.Returns updated product if present
	 *          else throws ResourceNotFoundException
	 */
	@Override
	public Product updateProduct(Product product, long id) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
		existingProduct.setActive(product.isActive());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setImageUrl(product.getImageUrl());
		existingProduct.setName(product.getName());
		existingProduct.setSku(product.getSku());
		existingProduct.setUnitPrice(product.getUnitPrice());
		existingProduct.setUnitsInStock(product.getUnitsInStock());

		productRepository.save(existingProduct);
		return existingProduct;
	}

	/**
	 * @param id the product id
	 * @apiNote Checks with id if product present.Deletes product if present else
	 *          throws ResourceNotFoundException
	 */
	@Override
	public void deleteProduct(long id) {
		productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
	}

	/**
	 * @param List<Product> List of Product Objects
	 * @param categoryId    the Category id
	 * @return the List of Products for the Category Id
	 * @apiNote the List of Products for the Category Id
	 */
	public List<Product> getProductByCategoryId(long categoryId) {
		log.info("Entering getProductByCategoryId...");
		ProductCategory existingProductCategory = productCategoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "Id", categoryId));
		log.info("Fetched  Category with id {}...:Result Category Name {}",categoryId,existingProductCategory.getCategoryName());
		
		 
		Product matchingProduct = new Product();
		matchingProduct.setCategory(existingProductCategory);

		// it will return all Products with the Category
		Example<Product> matchingProductExample = Example.of(matchingProduct, ExampleMatcher.matchingAny());
		log.info("matchingProductExample:Result Category Name {}",matchingProductExample.getProbe().getCategory().getCategoryName());
		List<Product> products= productRepository.findAll(matchingProductExample);
		log.info("Exiting getProductByCategoryId...{}",products.size());
		return products;
	}
	
	/**
	 * @param List<Product> List of Product Objects
	 * @param searchString the searchString
	 * @return the List of Products for the searchString
	 * @apiNote the List of Products for the searchString
	 */
	public List<Product> getProductBySearchString(String searchString){
		log.info("Entering getProductBySearchString...");
		Product matchingProduct = new Product();
		 ExampleMatcher matcher = ExampleMatcher
	                .matchingAny()
	                .withIgnoreNullValues()
	                .withStringMatcher(StringMatcher.CONTAINING)
	                .withIgnoreCase(true);
		
		matchingProduct.setName(searchString);
		matchingProduct.setDescription(searchString);

		// it will return all Products with the Category
		Example<Product> matchingProductExample = Example.of(matchingProduct, matcher);
		log.info("matchingProductExample:Result  Name {} Description {}",matchingProductExample.getProbe().getName(),matchingProductExample.getProbe().getDescription());
		List<Product> products= productRepository.findAll(matchingProductExample);
		log.info("Exiting getProductBySearchString...{}",products.size());
		return products;
		
	}

}