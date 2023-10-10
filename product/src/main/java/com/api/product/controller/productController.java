package com.api.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.product.model.ProductModel;
import com.api.product.model.Respost;
import com.api.product.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class productController {
	
	//my routes
	
	//action
	@Autowired
	private ProductRepository action;
	
	
	//list product
	@RequestMapping(value="/product",method = RequestMethod.GET)
	public @ResponseBody List<ProductModel> list() {
		return action.findAll();
	}
	//register product
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public @ResponseBody ProductModel register(@RequestBody ProductModel product) {
		
		return action.save(product);
		
	}
	//filter product
	@RequestMapping(value="/product/{codigo}",method=RequestMethod.GET)
	public @ResponseBody ProductModel filter(@PathVariable Integer codigo) {
		
		return action.findByCodigo(codigo);
	}
	//to alter
	@RequestMapping(value="/product",method=RequestMethod.PUT)
	public @ResponseBody ProductModel alter(@RequestBody ProductModel product) {
		return action.save(product);
	}
	//remove product
	@RequestMapping(value="/product/{codigo}",method=RequestMethod.DELETE)
	public @ResponseBody Respost remove(@PathVariable Integer codigo) {
		
		Respost resp=new Respost();
		try {
		ProductModel product=filter(codigo);
		
		this.action.delete(product);
		resp.setMensage("Sucess");
		}
		catch(Exception e) {
			resp.setMensage("Error"+e.getMessage());
		}
		return resp;
	}
}
