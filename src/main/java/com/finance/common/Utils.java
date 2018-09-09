package com.finance.common;

import java.text.DecimalFormat;

public class Utils {
	public static double formatDouble_2(double num) {
		DecimalFormat newFormat = new DecimalFormat(Constants.DECIMAL_2);
		double formattedDecimal =  Double.valueOf(newFormat.format(num));
		return formattedDecimal;

	}
	public static double formatDouble_4(double num) {
		DecimalFormat newFormat = new DecimalFormat(Constants.DECIMAL_4);
		double formattedDecimal =  Double.valueOf(newFormat.format(num));
		return formattedDecimal;

	}
}
