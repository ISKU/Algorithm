/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1864
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			char[] octopus = input.nextLine().toCharArray();
			if (octopus[0] == '#')
				break;

			long sum = 0;
			for (int i = octopus.length - 1, j = 0; i >= 0; i--, j++)
				sum += get(octopus[j]) * (int) Math.pow(8, i);

			System.out.println(sum);
		}
	}

	private static int get(char letter) {
		switch (letter) {
		case '-':
			return 0;
		case '\\':
			return 1;
		case '(':
			return 2;
		case '@':
			return 3;
		case '?':
			return 4;
		case '>':
			return 5;
		case '&':
			return 6;
		case '%':
			return 7;
		default:
			return -1;
		}
	}
}