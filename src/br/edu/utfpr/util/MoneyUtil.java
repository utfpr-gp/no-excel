package br.edu.utfpr.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyUtil {
	//to long
	//format long -> string R$
	
	//parte real divide por 100
	//centamos mod 100
	
	public static long toLong(String number){
		number = number.replaceAll("[^A-Za-z0-9]", "");
		return Long.parseLong(number);
	}
	
	public static String formatMoney(Long number){
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.getDefault()); 
		return n.format(number / 100);		
	}
	
	public static String replaceMoney(String money){		
		return money.replace(',', '.');
	}
	
	public static Long convertTo(BigDecimal number){
		String num = number.toString().replace(".", "");
		return Long.parseLong(num);
	}
}
