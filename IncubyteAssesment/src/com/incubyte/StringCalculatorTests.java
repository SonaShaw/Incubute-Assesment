package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTests {

	
	
		@Test
		void test1() {
			StringCalculator stringCalculator = new StringCalculator();
			String numbers = "";
			int res = stringCalculator.Add(numbers);
			assertEquals(res, 0);
		}
		
	
		
		@Test
		void test2() {
			StringCalculator stringCalculator = new StringCalculator();
			String numbers = "1";
			int res = stringCalculator.Add(numbers);
			assertEquals(res, 1);
		}
	
	
	
	@Test
	void test3() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "1,2";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 3);
	}
	
	@Test
	void testForUnownAmountofNumbers1() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "900,800";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 1700);
		
		String numbers2 = "100,800";
		res = stringCalculator.Add(numbers2);
		assertEquals(res, 900);
		
		String numbers3 = "900,85";
		res = stringCalculator.Add(numbers3);
		assertEquals(res, 985);
		
		String numbers4 = "500,800";
		res = stringCalculator.Add(numbers4);
		assertEquals(res, 1300);
	}
	
	
	
	
	@Test
	void testForhandleNewLines() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "1\n2,3";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 6);
		
		numbers = "1,\n";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 1);
		
		numbers = "1,\n,45,5";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 51);
		
	}
	
	
	@Test
	void testForSupportDifferentDelimeter() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "//;\n1;2,6";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 9);
		
		numbers = "//;\n1;2,6\n\n,1,12";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 22);
			
	}
	
	@Test
	void testForCallingWithNegativeNumber() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "//;\n1;-2,-9";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
			
	}
	
	@Test
	void testForNumberGreaterThan_1000() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "//;\n1;100000,90";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 91);
			
		numbers = "//;\n;100000,0,,;;,,;;,10976";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 0);
	}
	
	

}
