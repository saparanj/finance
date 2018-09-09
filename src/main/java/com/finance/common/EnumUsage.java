package com.finance.common;

import java.text.DecimalFormat;

public class EnumUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TransactionType.PURCHASE.getValue());
		
		double d = 2121123.76628729;

		DecimalFormat newFormat = new DecimalFormat("#.####");
		double twoDecimal =  Double.valueOf(newFormat.format(d));
	
		System.out.println(d);
		System.out.println(twoDecimal);
	}

}
