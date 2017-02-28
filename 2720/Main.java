/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2720
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] cost = new int[] { 25, 10, 5, 1 };
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int C = input.nextInt();

			for (int i = 0; i < 4; i++) {
				System.out.print(C == 0 ? "0 " : (C / cost[i]) + " ");
				C = C % cost[i];
			}
			System.out.println();
		}
	}
}