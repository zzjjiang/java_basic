package com.zzj.utils;


import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public StringUtils() {
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static final boolean isEmpty(String... str) {
		String[] var1 = str;
		int var2 = str.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			String string = var1[var3];
			if (isEmpty(string)) {
				return true;
			}
		}

		return false;
	}

	public static final boolean isNotEmpty(String... str) {
		return !isEmpty(str);
	}

	public static String upperCase(String str, int index) {
		Character ch = str.charAt(index);
		char[] array = str.toCharArray();
		array[index] = Character.toUpperCase(ch);
		return String.valueOf(array);
	}

	public static String firstUpperCase(String str) {
		return upperCase(str, 0);
	}

	public static String lowerCase(String str, int index) {
		Character ch = str.charAt(index);
		char[] array = str.toCharArray();
		array[index] = Character.toLowerCase(ch);
		return String.valueOf(array);
	}

	public static String firstLowerCase(String str) {
		return lowerCase(str, 0);
	}

	public static String toString(Object object) {
		return null;
	}

	public static final boolean regex(String str, String regex) {
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}

}
