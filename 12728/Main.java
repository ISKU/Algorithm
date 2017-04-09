/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12728
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] matrix = new int[10000000];
		int testCase = input.nextInt();

		matrix[0] = 1;
		matrix[1] = 5;
		for (int i = 2; i <= 105; i++)
			matrix[i] = (6 * matrix[i - 1] - 4 * matrix[i - 2] + 1 + 100000) % 1000;

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int n = input.nextInt();

			if (n > 102) {
				n %= 100;
				n = (n < 3) ? n + 100 : n;
			}

			System.out.printf("Case #%d: %03d\n", tCase, matrix[n]);
		}
	}
}