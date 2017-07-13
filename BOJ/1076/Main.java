/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1076
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String first = String.valueOf(get(input.next(), false));
		String second = String.valueOf(get(input.next(), false));
		long red = get(input.next(), true);
		System.out.println(Long.parseLong(first + second) * red);
	}

	private static long get(String color, boolean last) {
		switch (color) {
		case "black":
			return last ? 1 : 0;
		case "brown":
			return last ? 10 : 1;
		case "red":
			return last ? 100 : 2;
		case "orange":
			return last ? 1000 : 3;
		case "yellow":
			return last ? 10000 : 4;
		case "green":
			return last ? 100000 : 5;
		case "blue":
			return last ? 1000000 : 6;
		case "violet":
			return last ? 10000000 : 7;
		case "grey":
			return last ? 100000000 : 8;
		case "white":
			return last ? 1000000000 : 9;
		default:
			return 0;
		}
	}
}