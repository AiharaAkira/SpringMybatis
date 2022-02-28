package com.mz.pj.sns;

import java.util.Date;
import java.util.List;

public class SNSMsg {
	private int s_no;
	private String s_owner;
	private String s_txt;
	private Date s_date;
	
	private String m_photo;
	private List<SNSReply> s_replys;
	
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(int s_no, String s_owner, String s_txt, Date s_date, String m_photo, List<SNSReply> s_replys) {
		super();
		this.s_no = s_no;
		this.s_owner = s_owner;
		this.s_txt = s_txt;
		this.s_date = s_date;
		this.m_photo = m_photo;
		this.s_replys = s_replys;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_owner() {
		return s_owner;
	}

	public void setS_owner(String s_owner) {
		this.s_owner = s_owner;
	}

	public String getS_txt() {
		return s_txt;
	}

	public void setS_txt(String s_txt) {
		this.s_txt = s_txt;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public List<SNSReply> getS_replys() {
		return s_replys;
	}

	public void setS_replys(List<SNSReply> s_replys) {
		this.s_replys = s_replys;
	}
	
	
	
}
