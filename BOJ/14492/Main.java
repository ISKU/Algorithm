/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14492
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] A = new int[n][n];
		int[][] B = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = input.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				B[i][j] = input.nextInt();

		A = multiply(A, B, n);
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (A[i][j] > 0)
					sum++;

		System.out.print(sum);
	}

	private static int[][] multiply(int[][] A, int[][] B, int n) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					matrix[i][j] += A[i][k] & B[k][j];

		return matrix;
	}
}