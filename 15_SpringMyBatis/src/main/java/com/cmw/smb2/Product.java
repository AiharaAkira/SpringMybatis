package com.cmw.smb2;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private BigDecimal p_no;
	private String p_name;
	private String p_img;
	private BigDecimal p_price;
	private Date p_exp;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getP_no() {
		return p_no;
	}

	public void setP_no(BigDecimal p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}

	public Date getP_exp() {
		return p_exp;
	}

	public void setP_exp(Date p_exp) {
		this.p_exp = p_exp;
	}

	public Product(BigDecimal p_no, String p_name, String p_img, BigDecimal p_price, Date p_exp) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_img = p_img;
		this.p_price = p_price;
		this.p_exp = p_exp;
	}
	
	
	
}
