package com.api.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.product.model.ProductModel;

public interface ProductRepository  extends CrudRepository<ProductModel, Integer >{
	
	//list product
	List<ProductModel> findAll();//select all 
	
	//search for code
	ProductModel findByCodigo(int codigo);
	
	//remove 
	void delete(ProductModel product);
	
	//alter 
	<ProdMod extends ProductModel> ProdMod save(ProdMod product);
}
