/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11006
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int legs = input.nextInt();
			int chiken = input.nextInt();
			int twoChiken = 0;

			while (chiken + (twoChiken * 2) != legs) {
				chiken -= 1;
				twoChiken += 1;
			}

			System.out.printf("%d %d\n", chiken, twoChiken);
		}
	}
}