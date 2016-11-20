package com.lb.parrot.support.util;


public class TimeUtils {
	
	public static String currentTimeSecondsStr()  {
		return String.valueOf(currentTimeSeconds());
	}

	public static long currentTimeSeconds()  {
		return System.currentTimeMillis() / 1000;
	}

}