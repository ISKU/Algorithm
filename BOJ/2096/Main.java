/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.09
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2096
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = input.nextInt();
		int[][] minTable = new int[numberOfLines][3];
		int[][] maxTable = new int[numberOfLines][3];

		// initialization, first line
		for (int count = 0; count < 3; count++) {
			int number = input.nextInt();
			minTable[0][count] = number;
			maxTable[0][count] = number;
		}

		for (int line = 1; line < numberOfLines; line++) {
			int firstNumber = input.nextInt();
			int secondNumber = input.nextInt();
			int thirdNumber = input.nextInt();

			// minimum
			minTable[line][0] = Math.min(minTable[line - 1][0], minTable[line - 1][1]) + firstNumber;
			minTable[line][1] = Math.min(minTable[line - 1][0], Math.min(minTable[line - 1][1], minTable[line - 1][2])) + secondNumber;
			minTable[line][2] = Math.min(minTable[line - 1][1], minTable[line - 1][2]) + thirdNumber;

			// maximum
			maxTable[line][0] = Math.max(maxTable[line - 1][0], maxTable[line - 1][1]) + firstNumber;
			maxTable[line][1] = Math.max(maxTable[line - 1][0], Math.max(maxTable[line - 1][1], maxTable[line - 1][2])) + secondNumber;
			maxTable[line][2] = Math.max(maxTable[line - 1][1], maxTable[line - 1][2]) + thirdNumber;
		}

		// output
		System.out.print(Math.max(maxTable[numberOfLines - 1][0], Math.max(maxTable[numberOfLines - 1][1], maxTable[numberOfLines - 1][2])) + " ");
		System.out.println(Math.min(minTable[numberOfLines - 1][0], Math.min(minTable[numberOfLines - 1][1], minTable[numberOfLines - 1][2])));
	}
}