/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3460
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int number = input.nextInt();

			for (int index = 0; number > 0; index++) {
				if (number % 2 == 1)
					System.out.print(index + " ");
				number = number / 2;
			}
			System.out.println();
		}
	}
}