/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13288
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		char[] match = new Scanner(System.in).nextLine().toLowerCase().toCharArray();
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < match.length; i++)
			output.append((match[i] >= 97 && match[i] <= 123) ? get(match[i]) : match[i]);
		System.out.println(output);
	}

	private static String get(char letter) {
		switch (letter) {
		case 'a':
			return "@";
		case 'b':
			return "8";
		case 'c':
			return "(";
		case 'd':
			return "|)";
		case 'e':
			return "3";
		case 'f':
			return "#";
		case 'g':
			return "6";
		case 'h':
			return "[-]";
		case 'i':
			return "|";
		case 'j':
			return "_|";
		case 'k':
			return "|<";
		case 'l':
			return "1";
		case 'm':
			return "[]\\/[]";
		case 'n':
			return "[]\\[]";
		case 'o':
			return "0";
		case 'p':
			return "|D";
		case 'q':
			return "(,)";
		case 'r':
			return "|Z";
		case 's':
			return "$";
		case 't':
			return "']['";
		case 'u':
			return "|_|";
		case 'v':
			return "\\/";
		case 'w':
			return "\\/\\/";
		case 'x':
			return "}{";
		case 'y':
			return "`/";
		case 'z':
			return "2";
		default:
			return "";
		}
	}
}