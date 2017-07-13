/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5724
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] table = new int[101];

		for (int i = 1; i <= 100; i++)
			table[i] = table[i - 1] + i * i;

		while (true) {
			int n = input.nextInt();
			if (n == 0)
				break;

			System.out.println(table[n]);
		}
	}
}