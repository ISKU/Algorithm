/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2576
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int sum = 0;
		int minimum = Integer.MAX_VALUE;
		int oddCount = 0;

		for (int count = 0; count < 7; count++) {
			int number = input.nextInt();
			if (number % 2 == 1) {
				sum += number;
				minimum = Math.min(minimum, number);
				oddCount++;
			}
		}

		System.out.println(oddCount == 0 ? -1 : sum + "\n" + minimum);
	}
}