package com.mz.pj.community;

import java.math.BigDecimal;
import java.util.Date;

public class CommunityMsg {
	private BigDecimal c_no;
	private String c_from;
	private String c_to;
	private String c_txt;
	private Date c_when;
	
	public CommunityMsg() {
		// TODO Auto-generated constructor stub
	}

	public CommunityMsg(BigDecimal c_no, String c_from, String c_to, String c_txt, Date c_when) {
		super();
		this.c_no = c_no;
		this.c_from = c_from;
		this.c_to = c_to;
		this.c_txt = c_txt;
		this.c_when = c_when;
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getC_from() {
		return c_from;
	}

	public void setC_from(String c_from) {
		this.c_from = c_from;
	}

	public String getC_to() {
		return c_to;
	}

	public void setC_to(String c_to) {
		this.c_to = c_to;
	}

	public String getC_txt() {
		return c_txt;
	}

	public void setC_txt(String c_txt) {
		this.c_txt = c_txt;
	}

	public Date getC_when() {
		return c_when;
	}

	public void setC_when(Date c_when) {
		this.c_when = c_when;
	}
	
	
}
