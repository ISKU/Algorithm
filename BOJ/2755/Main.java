/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2755
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());
		int credit = 0;
		float grade = 0;

		while (testCase-- > 0) {
			String[] info = input.nextLine().split(" ");
			credit += Integer.parseInt(info[1]);
			grade += Float.parseFloat(info[1]) * grade(info[2]);
		}

		System.out.printf("%.2f", grade / credit);
	}

	private static float grade(String grade) {
		switch (grade) {
		case "A+":
			return 4.3f;
		case "A0":
			return 4.0f;
		case "A-":
			return 3.7f;
		case "B+":
			return 3.3f;
		case "B0":
			return 3.0f;
		case "B-":
			return 2.7f;
		case "C+":
			return 2.3f;
		case "C0":
			return 2.0f;
		case "C-":
			return 1.7f;
		case "D+":
			return 1.3f;
		case "D0":
			return 1.0f;
		case "D-":
			return 0.7f;
		default:
			return 0;
		}
	}
}