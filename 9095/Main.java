/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9095
 */

import java.util.Scanner;

public class Main {

	private static int count = 0;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			count = 0;
			getCount(input.nextInt());
			System.out.println(count);
		}
	}

	private static void getCount(int number) {
		if (number == 0) {
			count++;
			return;
		}
		if (number < 0)
			return;

		getCount(number - 1);
		getCount(number - 2);
		getCount(number - 3);
	}
}