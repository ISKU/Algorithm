/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1357
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println(reverse(reverse(input.nextInt()) + reverse(input.nextInt())));
	}

	private static int reverse(int number) {
		StringBuilder reverseNumber = new StringBuilder();
		for (int index = String.valueOf(number).length() - 1; index >= 0; index--)
			reverseNumber.append(String.valueOf(number).charAt(index));
		return Integer.parseInt(reverseNumber.toString());
	}
}