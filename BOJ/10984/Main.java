/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10984
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int subjects = input.nextInt();
			int credit = 0;
			float grade = 0;

			for (int count = 0; count < subjects; count++) {
				int tempCredit = input.nextInt();
				credit += tempCredit;
				grade += tempCredit * input.nextFloat();
			}

			System.out.printf("%d %.1f\n", credit, grade / credit);
		}
	}
}