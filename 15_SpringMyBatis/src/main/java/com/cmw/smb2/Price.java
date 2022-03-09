package com.cmw.smb2;

import java.math.BigDecimal;

public class Price {

	private BigDecimal num1;
	private BigDecimal num2;
	
	public Price() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getNum1() {
		return num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	public BigDecimal getNum2() {
		return num2;
	}

	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}

	public Price(BigDecimal num1, BigDecimal num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	
}
