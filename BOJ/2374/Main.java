/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2374
 */

import java.util.Scanner;

public class Main {

	private static long minimumValue = 0;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int maxSize = input.nextInt();
		int[] array = new int[maxSize];

		for (int index = 0; index < maxSize; index++)
			array[index] = input.nextInt();

		getOutput(array);
		System.out.print(minimumValue);
	}

	private static int getOutput(int[] array) {
		if (array.length == 1)
			return array[0];

		int maximumValue = 0;
		int maximumIndex = 0;
		for (int index = 0; index < array.length; index++) {
			if (maximumValue < array[index]) {
				maximumValue = array[index];
				maximumIndex = index;
			}
		}

		if (maximumIndex - 1 >= 0) {
			int[] tempLeft = new int[maximumIndex];
			System.arraycopy(array, 0, tempLeft, 0, maximumIndex);
			int getLeftMaximumValue = getOutput(tempLeft);
			minimumValue += maximumValue - getLeftMaximumValue;
		}
		if (maximumIndex + 1 < array.length) {
			int[] tempRight = new int[array.length - maximumIndex - 1];
			System.arraycopy(array, maximumIndex + 1, tempRight, 0, array.length - maximumIndex - 1);
			int getRightMaximumValue = getOutput(tempRight);
			minimumValue += maximumValue - getRightMaximumValue;
		}

		return maximumValue;
	}
}