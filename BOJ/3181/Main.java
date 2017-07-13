/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3181
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		String[] input = new Scanner(System.in).nextLine().split(" ");

		System.out.print(input[0].substring(0, 1).toUpperCase());
		for (int i = 1; i < input.length; i++) {
			if (check(input[i]))
				continue;
			System.out.print(input[i].substring(0, 1).toUpperCase());
		}
	}

	private static boolean check(String word) {
		switch (word) {
		case "i":
		case "pa":
		case "te":
		case "ni":
		case "niti":
		case "a":
		case "ali":
		case "nego":
		case "no":
		case "ili":
			return true;
		default:
			return false;
		}
	}
}