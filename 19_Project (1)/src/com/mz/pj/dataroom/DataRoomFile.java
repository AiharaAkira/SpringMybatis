package com.mz.pj.dataroom;

import java.math.BigDecimal;

public class DataRoomFile {
	private BigDecimal d_no;
	private String d_owner;
	private String d_title;
	private String d_file;
	private String d_category;
	
	public DataRoomFile() {
		// TODO Auto-generated constructor stub
	}

	public DataRoomFile(BigDecimal d_no, String d_owner, String d_title, String d_file, String d_category) {
		super();
		this.d_no = d_no;
		this.d_owner = d_owner;
		this.d_title = d_title;
		this.d_file = d_file;
		this.d_category = d_category;
	}

	public BigDecimal getD_no() {
		return d_no;
	}

	public void setD_no(BigDecimal d_no) {
		this.d_no = d_no;
	}

	public String getD_owner() {
		return d_owner;
	}

	public void setD_owner(String d_owner) {
		this.d_owner = d_owner;
	}

	public String getD_title() {
		return d_title;
	}

	public void setD_title(String d_title) {
		this.d_title = d_title;
	}

	public String getD_file() {
		return d_file;
	}

	public void setD_file(String d_file) {
		this.d_file = d_file;
	}

	public String getD_category() {
		return d_category;
	}

	public void setD_category(String d_category) {
		this.d_category = d_category;
	}
	
	
}
