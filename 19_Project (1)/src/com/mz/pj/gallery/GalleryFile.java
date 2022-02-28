package com.mz.pj.gallery;

import java.math.BigDecimal;

public class GalleryFile {
	private BigDecimal g_no;
	private String g_owner;
	private String g_title;
	private String g_file;
	
	public GalleryFile() {
		// TODO Auto-generated constructor stub
	}

	public GalleryFile(BigDecimal g_no, String g_owner, String g_title, String g_file) {
		super();
		this.g_no = g_no;
		this.g_owner = g_owner;
		this.g_title = g_title;
		this.g_file = g_file;
	}

	public BigDecimal getG_no() {
		return g_no;
	}

	public void setG_no(BigDecimal g_no) {
		this.g_no = g_no;
	}

	public String getG_owner() {
		return g_owner;
	}

	public void setG_owner(String g_owner) {
		this.g_owner = g_owner;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_file() {
		return g_file;
	}

	public void setG_file(String g_file) {
		this.g_file = g_file;
	}
	
}
