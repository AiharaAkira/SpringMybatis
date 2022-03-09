package com.cmw.smb2;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Service
public class ProductDAO {
	
	
	
	@Autowired
	SqlSession ss;
	
	public void getAllProduct(HttpServletRequest request) {
		
		request.setAttribute("products", ss.getMapper(Mapper.class).getAllProduct());
		
	}

	public void delete(Product product, HttpServletRequest request) {
		if(ss.getMapper(Mapper.class).deleteProduct(product)==1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
			
		}
	}

	@SuppressWarnings("deprecation")
	public void regProduct(Product product, HttpServletRequest request) {
		
		try {
			String saveDirectory = request.getSession().getServletContext().getRealPath("resources/file");
			MultipartRequest mr = new MultipartRequest
					(request, saveDirectory,1024*1024*30,"utf-8",new DefaultFileRenamePolicy());	
			
		String name =mr.getParameter("p_name");	
		String price = mr.getParameter("p_price");	
		String exp = mr.getParameter("p_exp");	
		String img = mr.getFilesystemName("p_img");	
			
		System.out.println(name);
		System.out.println(price);
		System.out.println(exp);
		System.out.println(img);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		product.setP_name(name);
		product.setP_price(new BigDecimal(price));
		product.setP_exp(sdf.parse(exp));
		product.setP_img(img);
		
		if(ss.getMapper(Mapper.class).regProduct(product)==1) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void searchProductByRange(Product product,Price p, HttpServletRequest request) {
		request.setAttribute("products", ss.getMapper(Mapper.class).searchProductByRange(p));
	}

	public void searchProductByName(Product product, HttpServletRequest request) {
		request.setAttribute("products", ss.getMapper(Mapper.class).searchProductByName(product));
	}

	public void searchProductByLowerPrice(Product product, HttpServletRequest request) {
		request.setAttribute("products", ss.getMapper(Mapper.class).searchProductByLowerPrice(product));
		
	}

	public void updateNewPrice(Product product, HttpServletRequest request) {

		
		Map<String, String> prices = new HashMap<String, String>();
		prices.put("p_price", request.getParameter("p_price"));
		prices.put("newPrice", request.getParameter("newPrice"));
		
		
		if(ss.getMapper(Mapper.class).updateNewPrice(prices)==1) {
			System.out.println("가격수정성공");
		}else {
			System.out.println("가격수정성공");
		}
		
		
	}
	
}
