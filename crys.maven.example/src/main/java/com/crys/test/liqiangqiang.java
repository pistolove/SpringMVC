package com.crys.test;

import java.math.BigDecimal;

/**
 * @author liqiangqiang 
 * 用java语言实现计算n的阶乘的函数
 * 考虑到结果可能大于int、long的最大值，所以使用BigDecimal为返回值
 */

public class liqiangqiang {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			System.err.println(getN(i));
			System.err.println(getNByRecursion(i));
			System.err.println();
		}

		for (int i = -10; i < 0; i++) {
			System.err.println(getN(i));
			System.err.println(getNByRecursion(i));
			System.err.println();
		}
	}

	// 非递归算法
	public static BigDecimal getN(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n must be a positive number");
		}

		BigDecimal sum = new BigDecimal(1);
		BigDecimal temp;

		for (int i = 2; i <= n; i++) {
			temp = new BigDecimal(i);
			sum = sum.multiply(temp);
		}

		return sum;
	}

	// 递归算法
	public static BigDecimal getNByRecursion(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n must be a positive number");
		}

		if (n == 0 || n == 1) {
			return new BigDecimal(1);
		}

		BigDecimal result = new BigDecimal(n);
		return result.multiply(getNByRecursion(n - 1));
	}
}
