package com.highken.training.bootlearn.util;

public class MathUtil {

	public static double sum(double a,double b) {
		return a+b;
	}
	
	public static double division(double a,double b) {
		if(b==0)
			throw new IllegalArgumentException("0 not allowed for division");
		return a/b;
	}
	
	
}
