/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.05
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10830
 */

import java.util.Scanner;

public class Main {

	private static int[][] Matrix;
	private static int[][] unitMatrix;
	private static int numberOfLines;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfLines = input.nextInt(); // the number of lines
		long exponent = input.nextLong(); // exponent part
		String[] binaryExponent = reverseStringArray(Long.toBinaryString(exponent).split("")); // digit to binary and reverse
		Matrix = new int[numberOfLines][numberOfLines];
		unitMatrix = createUnitMatrix(numberOfLines);
		Object[] savePowerMatrix = new Object[38]; // 100,000,000,000 to binary length: 0~37
		savePowerMatrix[0] = Matrix;

		// input, matrix
		for (int row = 0; row < numberOfLines; row++)
			for (int column = 0; column < numberOfLines; column++)
				Matrix[row][column] = input.nextInt();

		// calculate matrix
		int[][] output = unitMatrix;
		for (int index = 0; index < binaryExponent.length; index++) {
			if (index >= 1)
				savePowerMatrix[index] = matrixPower((int[][]) savePowerMatrix[index - 1], 2);
			if (binaryExponent[index].equals("1"))
				output = matrixMultiply(output, (int[][]) savePowerMatrix[index]);
		}

		// output, A^B matrix
		StringBuilder outMatrix = new StringBuilder();
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++)
				outMatrix.append(output[i][j] + " ");
			outMatrix.append("\n");
		}
		System.out.println(outMatrix);
	}

	private static int[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {
		int[][] newMatrix = new int[numberOfLines][numberOfLines];

		for (int i = 0; i < numberOfLines; i++)
			for (int j = 0; j < numberOfLines; j++)
				for (int k = 0; k < numberOfLines; k++)
					newMatrix[i][j] = (newMatrix[i][j] + (matrixA[i][k] * matrixB[k][j])) % 1000;

		return newMatrix;
	}

	private static int[][] matrixPower(int[][] matrixA, int exponent) {
		int[][] newMatrix = matrixA;

		for (int count = 0; count < exponent - 1; count++)
			newMatrix = matrixMultiply(newMatrix, matrixA);

		return newMatrix;
	}

	private static int[][] createUnitMatrix(int lines) {
		int[][] unitMatrix = new int[lines][lines];

		for (int index = 0; index < lines; index++)
			unitMatrix[index][index] = 1;

		return unitMatrix;
	}

	private static String[] reverseStringArray(String[] array) {
		String[] reverseArray = new String[array.length];
		int frontIndex = 0;
		int rearIndex = array.length - 1;

		do {
			String frontString = array[frontIndex];
			String rearString = array[rearIndex];
			reverseArray[frontIndex] = rearString;
			reverseArray[rearIndex] = frontString;
		} while (frontIndex++ < rearIndex--);

		return reverseArray;
	}
}