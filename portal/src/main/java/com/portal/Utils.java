package com.portal;

public class Utils {
	public static boolean isset(String value) {
		return !emptyStr(value);
	}

	public static boolean emptyStr(String value) {
		return value == null || value.length() == 0;
	}

	public static boolean notEmptyStr(String value) {
		return !emptyStr(value);
	}

	public static String getMd5sum(String md5) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

}
