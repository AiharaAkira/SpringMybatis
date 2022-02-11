package com.cmw.mb;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAO {

	public static void getAllProduct(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.connect();
			List<Product> products = ss.selectList("cmwqqq.getAllProduct");
			request.setAttribute("products", products);
			ss.close();
			System.out.println("상품조회성공");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void searchName(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			String name = request.getParameter("name");
			Product p = new Product();
			p.setP_name(name);
			List<Product> products = ss.selectList("cmwqqq.getNameProduct", p);

			request.setAttribute("products", products);

			System.out.println("이름으로 조회성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insert(HttpServletRequest request) {
		try {
			SqlSession ss = DBManager_new.connect();

			String path = request.getSession().getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			//값
			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price")) ;
			String img = mr.getFilesystemName("img");
			String exp = mr.getParameter("exp");
			
			System.out.println(name);
			System.out.println(price);
			System.out.println(img);
			System.out.println(exp);
			
			Product p = new Product();
			p.setP_name(name);
			p.setP_price(price);
			p.setP_img(img);
			p.setP_exp(exp);
			
			if(ss.insert("cmwqqq.insert", p) == 1) {
				ss.commit();
				ss.close();
				System.out.println("등록성공!!");
			}else {
				
				System.out.println("등록실패!!");
			}
			


		} catch (IOException e) {
			System.out.println("db서버문제!!");
			e.printStackTrace();
		}
	}

	public static void delete(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();

			//값
			int no = Integer.parseInt(request.getParameter("no")) ;
			Map<String, Integer> num = new HashMap<String, Integer>();
			num.put("no", no);
			
			
			if(ss.delete("cmwqqq.delete", num) == 1) {
				ss.commit();
				ss.close();
				System.out.println("삭제성공!");
			}else {
				System.out.println("삭제실패!");
			}
			
			
			
			
			


		} catch (IOException e) {
			System.out.println("db서버문제!!");
			e.printStackTrace();
		}
		
	}

	public static void searchPrice(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();

			//값
			int price = Integer.parseInt(request.getParameter("price")) ;
			Map<String, Integer> prices = new HashMap<String, Integer>();
			prices.put("price", price);
			
			List<Product> products = ss.selectList("cmwqqq.selectPrice",prices);
			request.setAttribute("products", products);
			
			
				System.out.println("가격검색성공!");
			
			
			
			

		} catch (IOException e) {
			System.out.println("db서버문제!!");
			e.printStackTrace();
		}
		
	}

	public static void twoPriceSearch(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();

			//값
			int price1 = Integer.parseInt(request.getParameter("price1")) ;
			int price2 = Integer.parseInt(request.getParameter("price2")) ;
			Map<String, Integer> prices = new HashMap<String, Integer>();
			prices.put("price1", price1);
			prices.put("price2", price2);
			
			List<Product> products = ss.selectList("cmwqqq.selectTwoPrice",prices);
			request.setAttribute("products", products);
			
			
				System.out.println("가격검색성공!");
			
			
			
			

		} catch (IOException e) {
			System.out.println("db서버문제!!");
			e.printStackTrace();
		}
		
	}

	public static void updatePrice(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.connect();

			//값
			int price1 = Integer.parseInt(request.getParameter("price1")) ;
			int price2 = Integer.parseInt(request.getParameter("price2")) ;
			Map<String, Integer> prices = new HashMap<String, Integer>();
			prices.put("price1", price1);
			prices.put("price2", price2);
			
			if(ss.update("cmwqqq.updatePrice",prices)==1) {
				ss.commit();
				ss.close();
				System.out.println("가격인상성공!");
			}else {
				System.out.println("가격인상실패!");
				
			}
			
				

		} catch (IOException e) {
			System.out.println("db서버문제!!");
			e.printStackTrace();
		}
		
	}

}
