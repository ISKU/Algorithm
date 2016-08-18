/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4571
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		int testCase = 1;
		while (true) {
			long firstOperand = input.nextLong();
			long secondOperand = input.nextLong();
			long resultNumber = firstOperand * secondOperand;
			int maxLineLength = String.valueOf(resultNumber).length();
			boolean checkPrintResult = true;
			String[] reverseSecondOperand = reverseString(String.valueOf(secondOperand).split(""));

			if (firstOperand == 0 && secondOperand == 0)
				break;

			System.out.printf("Problem %d\n", testCase++);
			printSpaceAndNumber(maxLineLength - String.valueOf(firstOperand).length(), firstOperand, true);
			printSpaceAndNumber(maxLineLength - reverseSecondOperand.length, secondOperand, true);
			printLine(maxLineLength);
			checkPrintResult = intermediateCalculation(firstOperand, reverseSecondOperand, resultNumber, maxLineLength);
			printResult(resultNumber, maxLineLength, checkPrintResult);
		}
	}

	private static boolean intermediateCalculation(long firstOperand, String[] reverseSecondOperand, long resultNumber, int maxLineLength) {
		StringBuilder intermediateResultZero = new StringBuilder();
		for (int index = 0; index < reverseSecondOperand.length; index++) {
			long intermediateResult = firstOperand * Integer.parseInt(reverseSecondOperand[index]);
			if (intermediateResult == 0) {
				intermediateResultZero.append("0");
				continue;
			}
			printSpaceAndNumber(maxLineLength - String.valueOf(intermediateResult).length() - index, intermediateResult, false);

			System.out.println(intermediateResultZero);
			if ((intermediateResult + intermediateResultZero.toString()).equals(String.valueOf(resultNumber)))
				return false;
			intermediateResultZero = new StringBuilder();
		}
		return true;
	}

	private static void printSpaceAndNumber(int length, long number, boolean lineBreak) {
		for (int space = 0; space < length; space++)
			System.out.print(" ");
		System.out.print(lineBreak ? number + "\n" : number);
	}

	private static void printLine(int length) {
		for (int line = 0; line < length; line++)
			System.out.print("-");
		System.out.println();
	}

	private static void printResult(long resultNumber, int maxLineLength, boolean checkPrintResult) {
		if (checkPrintResult) {
			printLine(maxLineLength);
			System.out.println(resultNumber);
		}
	}

	private static String[] reverseString(String[] array) {
		String[] reverseArray = new String[array.length];
		int frontIndex = 0;
		int rearIndex = array.length - 1;

		do {
			reverseArray[frontIndex] = array[rearIndex];
			reverseArray[rearIndex] = array[frontIndex];
		} while (frontIndex++ < rearIndex--);

		return reverseArray;
	}
}