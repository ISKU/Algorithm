/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5622
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		char[] dial = new Scanner(System.in).next().toCharArray();

		int time = 0;
		for (int i = 0; i < dial.length; i++)
			time += get(dial[i]);

		System.out.print(time);
	}

	private static int get(char letter) {
		switch (letter) {
		case 'A':
		case 'B':
		case 'C':
			return 3;
		case 'D':
		case 'E':
		case 'F':
			return 4;
		case 'G':
		case 'H':
		case 'I':
			return 5;
		case 'J':
		case 'K':
		case 'L':
			return 6;
		case 'M':
		case 'N':
		case 'O':
			return 7;
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
			return 8;
		case 'T':
		case 'U':
		case 'V':
			return 9;
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			return 10;
		default:
			return 0;
		}
	}
}