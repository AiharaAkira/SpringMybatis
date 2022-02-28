package com.mz.pj.sns;

import java.math.BigDecimal;

public class SNSSelector {
		
	private String search;	// 검색어
	private BigDecimal start;
	private BigDecimal end;
	
	public SNSSelector() {
		// TODO Auto-generated constructor stub
	}

	public SNSSelector(String search, BigDecimal start, BigDecimal end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
