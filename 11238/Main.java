/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11238
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static final int MODULAR = 1000000007;
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger TWO = new BigInteger("2");

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			System.out.println(nth_FibonacciNumber(
					getGreatestCommonDivisor(
							new BigInteger(input.next()), new BigInteger(input.next())
			)));
		}
	}

	private static BigInteger getGreatestCommonDivisor(BigInteger first, BigInteger second) {
		while (!second.equals(ZERO)) {
			BigInteger temp = first.remainder(second);
			first = second;
			second = temp;
		}

		return first.abs();
	}

	private static long nth_FibonacciNumber(BigInteger number) {
		long[][] matrix = new long[][] { { 1, 0 }, { 0, 1 } };
		long[][] fibonacciMatrix = new long[][] { { 1, 1 }, { 1, 0 } };

		while (!number.equals(ZERO)) {
			if (number.remainder(TWO).equals(ONE))
				matrix = matrixMultiply(matrix, fibonacciMatrix, 2);
			fibonacciMatrix = matrixMultiply(fibonacciMatrix, fibonacciMatrix, 2);
			number = number.divide(TWO);
		}

		return matrix[0][1];
	}

	private static long[][] matrixMultiply(long[][] matrixA, long[][] matrixB, int length) {
		long[][] newMatrix = new long[length][length];

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				for (int k = 0; k < length; k++)
					newMatrix[i][j] = (newMatrix[i][j] + (matrixA[i][k] * matrixB[k][j])) % MODULAR;

		return newMatrix;
	}
}