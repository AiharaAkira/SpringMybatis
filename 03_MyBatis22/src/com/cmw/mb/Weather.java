package com.cmw.mb;

import java.math.BigDecimal;
import java.util.Date;

public class Weather {
	private BigDecimal w_no;
	private BigDecimal w_temp;
	private String w_country;
	private String w_city;
	private String w_description;
	private Date w_date;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Weather(BigDecimal w_no, BigDecimal w_temp, String w_country, String w_city, String w_description,
			Date w_date) {
		super();
		this.w_no = w_no;
		this.w_temp = w_temp;
		this.w_country = w_country;
		this.w_city = w_city;
		this.w_description = w_description;
		this.w_date = w_date;
	}



	public BigDecimal getW_no() {
		return w_no;
	}
	public void setW_no(BigDecimal w_no) {
		this.w_no = w_no;
	}
	public BigDecimal getW_temp() {
		return w_temp;
	}
	public void setW_temp(BigDecimal w_temp) {
		this.w_temp = w_temp;
	}
	public String getW_country() {
		return w_country;
	}
	public void setW_country(String w_country) {
		this.w_country = w_country;
	}
	public String getW_city() {
		return w_city;
	}
	public void setW_city(String w_city) {
		this.w_city = w_city;
	}
	public String getW_description() {
		return w_description;
	}
	public void setW_description(String w_description) {
		this.w_description = w_description;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
}
