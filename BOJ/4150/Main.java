/*
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4150
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger TWO = new BigInteger("2");

	public static void main(String args[]) {
		System.out.print(nth_FibonacciNumber(new BigInteger(new Scanner(System.in).next())));
	}

	private static BigInteger nth_FibonacciNumber(BigInteger number) {
		BigInteger[][] matrix = new BigInteger[][] { { ONE, ZERO }, { ZERO, ONE } };
		BigInteger[][] fibonacciMatrix = new BigInteger[][] { { ONE, ONE }, { ONE, ZERO } };

		while (!number.equals(ZERO)) {
			if (number.remainder(TWO).equals(ONE))
				matrix = matrixMultiply(matrix, fibonacciMatrix);
			fibonacciMatrix = matrixMultiply(fibonacciMatrix, fibonacciMatrix);
			number = number.divide(TWO);
		}

		return matrix[0][1];
	}

	private static BigInteger[][] matrixMultiply(BigInteger[][] matrixA, BigInteger[][] matrixB) {
		BigInteger[][] newMatrix = new BigInteger[][] { { ZERO, ZERO }, { ZERO, ZERO } };

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					newMatrix[i][j] = newMatrix[i][j].add(matrixA[i][k].multiply(matrixB[k][j]));

		return newMatrix;
	}
}