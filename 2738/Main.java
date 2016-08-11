/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2738
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		// matrix A,B n*m
		int matrixRow = input.nextInt();
		int matrixColumn = input.nextInt();

		// input, matrix A
		int[][] matrixA = new int[matrixRow][matrixColumn];
		for (int row = 0; row < matrixRow; row++)
			for (int column = 0; column < matrixColumn; column++)
				matrixA[row][column] = input.nextInt();

		// input, matrix B
		int[][] matrixB = new int[matrixRow][matrixColumn];
		for (int row = 0; row < matrixRow; row++)
			for (int column = 0; column < matrixColumn; column++)
				matrixB[row][column] = input.nextInt();

		// calculate
		int[][] newMatrix = new int[matrixRow][matrixColumn];
		for (int i = 0; i < matrixRow; i++)
			for (int j = 0; j < matrixColumn; j++)
				newMatrix[i][j] += matrixA[i][j] + matrixB[i][j];

		// ouput
		for (int i = 0; i < matrixRow; i++) {
			for (int j = 0; j < matrixColumn; j++)
				System.out.print(newMatrix[i][j] + " ");
			System.out.println();
		}
	}
}