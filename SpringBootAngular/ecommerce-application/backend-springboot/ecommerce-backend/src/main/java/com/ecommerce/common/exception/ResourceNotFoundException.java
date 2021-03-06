package com.ecommerce.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Soma Mukherjee
 * @apiNote The Custom Exception when a particular Resource is not found
 * @version 1.0.0
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{ 
private static final long serialVersionUID = 1L;
private String resourceName;
private String fieldName;
private Object fieldValue;

/**
 * @param resourceName -Name of the resource(Entity)
 * @param fieldName -Name of the resource field(Entity column)
 * @param fieldValue -Value of the Entity Column
 * @apiNote Creates a new Custom Exception with the values
 */
public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
	super(String.format("%s not found with name %s:%s",resourceName,fieldName,fieldValue ));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

public String getResourceName() {
	return resourceName;
}

public String getFieldName() {
	return fieldName;
}

public Object getFieldValue() {
	return fieldValue;
}
}

