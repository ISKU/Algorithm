/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11179
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] binaryNumber = Integer.toBinaryString(input.nextInt()).split("");
		int reverseBinaryNumberToDigitNumber = 0;

		for (int index = 0; index < binaryNumber.length; index++)
			if (binaryNumber[index].equals("1"))
				reverseBinaryNumberToDigitNumber += (int) Math.pow(2, index);

		System.out.println(reverseBinaryNumberToDigitNumber);
	}
}