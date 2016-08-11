/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2740
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		// input, matrix A
		int matrixRowOfA = input.nextInt();
		int matrixColumnOfA = input.nextInt();
		int[][] matrixA = new int[matrixRowOfA][matrixColumnOfA];
		for (int row = 0; row < matrixRowOfA; row++)
			for (int column = 0; column < matrixColumnOfA; column++)
				matrixA[row][column] = input.nextInt();

		// input, matrix B
		int matrixRowOfB = input.nextInt();
		int matrixColumnOfB = input.nextInt();
		int[][] matrixB = new int[matrixRowOfB][matrixColumnOfB];
		for (int row = 0; row < matrixRowOfB; row++)
			for (int column = 0; column < matrixColumnOfB; column++)
				matrixB[row][column] = input.nextInt();

		// calculate
		int[][] newMatrix = new int[matrixRowOfA][matrixColumnOfB];
		for (int i = 0; i < matrixRowOfA; i++)
			for (int j = 0; j < matrixColumnOfB; j++)
				for (int k = 0; k < matrixColumnOfA; k++)
					newMatrix[i][j] += matrixA[i][k] * matrixB[k][j];

		// ouput
		for (int i = 0; i < matrixRowOfA; i++) {
			for (int j = 0; j < matrixColumnOfB; j++)
				System.out.print(newMatrix[i][j] + " ");
			System.out.println();
		}
	}
}