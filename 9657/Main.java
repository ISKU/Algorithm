/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9657
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int[] table = new int[1001];
		table[1] = 1;
		table[2] = 0;
		table[3] = 1;
		table[4] = 1;

		for (int i = 5; i < table.length; i++) {
			if (table[i - 1] + table[i - 3] + table[i - 4] == 3)
				table[i] = 0;
			else
				table[i] = 1;
		}

		System.out.print(table[N] == 0 ? "CY" : "SK");
	}
}