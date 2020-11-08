package com.highken.training.bootlearn.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MathUtilTest {

	@Test
	public void testSum() {
		double result=MathUtil.sum(1, 2);
		assertEquals(3.0, result);
	}
	
	@Test
	public void testDevision() {
		double result=MathUtil.division(9, 3);
		assertEquals(3.0, result);
	}
	
	@Test()
	public void testDevisionExpectException() {
		assertThrows(IllegalArgumentException.class, ()->MathUtil.division(9, 0));
//		double result=MathUtil.division(9, 3);
	}
	
}
