package com.zeng.printer;

public class Strings {
	
	public static String repeat(String string, int count) {
		if (string == null) return null;
		
		StringBuilder sb = new StringBuilder();
		while (count-- > 0) {
			sb.append(string);
		}
		return sb.toString();
	}
	
	public static String blank(int length) {
		if (length < 0) return null;
		if (length == 0) return "";
		return String.format("%" + length + "s", "");
	}

}
