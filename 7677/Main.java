/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7677
 */

import java.util.Scanner;

public class Main {

	private static final int MODULAR = 10000;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int number = input.nextInt();
			if (number == -1)
				break;

			System.out.println(nth_FibonacciNumber(number));
		}
	}

	private static int nth_FibonacciNumber(int number) {
		int[][] matrix = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] fibonacciMatrix = new int[][] { { 1, 1 }, { 1, 0 } };

		while (number != 0) {
			if (number % 2 == 1)
				matrix = matrixMultiply(matrix, fibonacciMatrix);
			fibonacciMatrix = matrixMultiply(fibonacciMatrix, fibonacciMatrix);
			number = number / 2;
		}

		return matrix[0][1];
	}

	private static int[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {
		int[][] newMatrix = new int[2][2];

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					newMatrix[i][j] = (newMatrix[i][j] + (matrixA[i][k] * matrixB[k][j])) % MODULAR;

		return newMatrix;
	}
}