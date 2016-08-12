/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.12
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11444
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static final int DIVISOR = 1000000007;
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger TWO = new BigInteger("2");

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BigInteger inputNumber = new BigInteger(input.next());
		long[][] matrix = new long[][] { { 1, 0 }, { 0, 1 } };
		long[][] fibonacciMatrix = new long[][] { { 1, 1 }, { 1, 0 } };

		while (!inputNumber.equals(ZERO)) {
			if (inputNumber.remainder(TWO).equals(ONE))
				matrix = matrixMultiply(matrix, fibonacciMatrix, 2);
			fibonacciMatrix = matrixMultiply(fibonacciMatrix, fibonacciMatrix, 2);
			inputNumber = inputNumber.divide(TWO);
		}

		System.out.println(matrix[0][1]);
	}

	// n by n (n=length) matrix multiply
	private static long[][] matrixMultiply(long[][] matrixA, long[][] matrixB, int length) {
		long[][] newMatrix = new long[length][length];

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				for (int k = 0; k < length; k++)
					newMatrix[i][j] = (newMatrix[i][j] + (matrixA[i][k] * matrixB[k][j])) % DIVISOR;

		return newMatrix;
	}
}