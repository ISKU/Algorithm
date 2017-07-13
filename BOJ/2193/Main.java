/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2193
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		long[][] table = new long[N + 1][2];

		table[1][0] = 1;
		table[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			table[i][0] = table[i - 1][0] + table[i - 1][1];
			table[i][1] = table[i - 1][0];
		}

		System.out.print(table[N][1]);
	}
}