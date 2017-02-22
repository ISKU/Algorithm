/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11800
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int test = 1; test <= testCase; test++) {
			int first = input.nextInt();
			int second = input.nextInt();

			if (first < second) {
				int temp = second;
				second = first;
				first = temp;
			}

			if (first == second)
				System.out.printf("Case %d: %s\n", test, getDuple(first));
			else if ((first == 5 || first == 6) && (second == 5 || second == 6))
				System.out.printf("Case %d: Sheesh Beesh\n", test);
			else
				System.out.printf("Case %d: %s %s\n", test, get(first), get(second));
		}
	}

	private static String get(int dice) {
		switch (dice) {
		case 1:
			return "Yakk";
		case 2:
			return "Doh";
		case 3:
			return "Seh";
		case 4:
			return "Ghar";
		case 5:
			return "Bang";
		case 6:
			return "Sheesh";
		default:
			return "";
		}
	}

	private static String getDuple(int dice) {
		switch (dice) {
		case 1:
			return "Habb Yakk";
		case 2:
			return "Dobara";
		case 3:
			return "Dousa";
		case 4:
			return "Dorgy";
		case 5:
			return "Dabash";
		case 6:
			return "Dosh";
		default:
			return "";
		}
	}
}