/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1629
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BigInteger number = new BigInteger(input.next());
		String[] binaryExponent = reverseStringArray(Integer.toBinaryString(input.nextInt()).split(""));
		BigInteger divisor = new BigInteger(input.next());
		BigInteger[] savePower = new BigInteger[binaryExponent.length];
		BigInteger result = new BigInteger("1");

		savePower[0] = number;
		for (int index = 0; index < binaryExponent.length; index++) {
			if (index >= 1)
				savePower[index] = (savePower[index - 1].pow(2)).remainder(divisor);
			if (binaryExponent[index].equals("1"))
				result = (result.multiply(savePower[index])).remainder(divisor);
		}

		System.out.println(result.toString());
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