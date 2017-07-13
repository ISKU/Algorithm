/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3067
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int count = input.nextInt();
			int[] coin = new int[count];

			for (int i = 0; i < count; i++)
				coin[i] = input.nextInt();

			int cost = input.nextInt();
			int[] table = new int[cost + 1];

			table[0] = 1;
			for (int i = 0; i < count; i++)
				for (int j = coin[i]; j <= cost; j++)
					table[j] += table[j - coin[i]];

			System.out.println(table[cost]);
		}
	}
}