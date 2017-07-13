/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1009
 */

import java.util.Scanner;

public class Main {

	private static final int DIVISOR = 10;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int number = input.nextInt();
			String[] binaryExponent = reverseStringArray(Integer.toBinaryString(input.nextInt()).split(""));
			int[] savePower = new int[binaryExponent.length];
			int result = 1;

			savePower[0] = number;
			for (int index = 0; index < binaryExponent.length; index++) {
				if (index >= 1)
					savePower[index] = (int) Math.pow(savePower[index - 1], 2) % DIVISOR;
				if (binaryExponent[index].equals("1"))
					result = result * savePower[index] % DIVISOR;
			}

			System.out.println(result == 0 ? 10 : result);
		}
	}

	private static String[] reverseStringArray(String[] array) {
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