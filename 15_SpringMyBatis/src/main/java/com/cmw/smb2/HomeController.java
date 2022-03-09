package com.cmw.smb2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDAO pdao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		pdao.getAllProduct(request);
		
		return "index";
	}
	
	@RequestMapping(value = "/del.product", method = RequestMethod.GET)
	public String delete(Product product, HttpServletRequest request) {
		
		pdao.delete(product, request);
		pdao.getAllProduct(request);
		
		return "index";
	}
	
	@RequestMapping(value = "/reg.product", method = RequestMethod.POST)
	public String regProduct(Product product, HttpServletRequest request) {
		
		
		
		pdao.regProduct(product, request);
		pdao.getAllProduct(request);
		
		return "index";
		
	}
	
	@RequestMapping(value = "/search.productByRange", method = RequestMethod.GET)
	public String searchProductByRange(Product product,Price p, HttpServletRequest request) {
		
		
		pdao.searchProductByRange(product,p, request);
		
		return "index";
		
	}
	
	@RequestMapping(value = "/search.productByName", method = RequestMethod.GET)
	public String searchProductByName(Product product, HttpServletRequest request) {
		
		
		pdao.searchProductByName(product, request);
		
		return "index";
		
	}
	
	@RequestMapping(value = "/search.productByLowerPrice", method = RequestMethod.GET)
	public String searchProductByLowerPrice(Product product, HttpServletRequest request) {
		
		
		pdao.searchProductByLowerPrice(product, request);
		
		return "index";
		
	}
	
	@RequestMapping(value = "/update.newPrice", method = RequestMethod.GET)
	public String updateNewPrice(Product product, HttpServletRequest request) {
		
		
		pdao.updateNewPrice(product, request);
		pdao.getAllProduct(request);
		
		return "index";
		
	}
	
}
