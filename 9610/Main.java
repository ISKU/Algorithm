/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9610
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int Q1 = 0;
		int Q2 = 0;
		int Q3 = 0;
		int Q4 = 0;
		int AXIS = 0;

		while (testCase-- > 0) {
			int x = input.nextInt();
			int y = input.nextInt();

			if (x == 0 || y == 0)
				AXIS++;
			else if (x > 0 && y > 0)
				Q1++;
			else if (x < 0 && y > 0)
				Q2++;
			else if (x < 0 && y < 0)
				Q3++;
			else if (x > 0 && y < 0)
				Q4++;
		}

		System.out.printf("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d", Q1, Q2, Q3, Q4, AXIS);
	}
}