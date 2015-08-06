package com.crys.test;

import java.math.BigDecimal;

public class Algorithm {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.err.println(getN(i));
			System.err.println(getNByRecursion(i));
			System.err.println();
		}
	}

	// 非递归算法
	public static BigDecimal getN(int n) {
		BigDecimal sum = new BigDecimal(1);
		BigDecimal temp;
		
		for (int i = 2; i <= n; i++) {
			temp = new BigDecimal(i);
			sum = sum.multiply(temp);
		}
		
		return sum;
	}

	// 递归算法
	public static BigDecimal getNByRecursion(int n) {
		if (n == 0 || n == 1) {
			return new BigDecimal(1);
		}
		
		BigDecimal result = new BigDecimal(n);
		return result.multiply(getNByRecursion(n - 1));
	}
}
