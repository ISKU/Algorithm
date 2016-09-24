/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11005
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int number = input.nextInt();
		int system = input.nextInt();

		while (number > 0) {
			int remainder = number % system;

			if (remainder < 10)
				output.append(remainder);
			else
				output.append((char) (remainder + 55));
			number = number / system;
		}

		System.out.print(output.reverse());
	}
}