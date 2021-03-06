/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9461
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		long[] table = new long[101];
		int testCase = input.nextInt();

		table[0] = table[1] = table[2] = table[3] = 1;
		table[4] = table[5] = 2;
		for (int i = 6; i <= 100; i++)
			table[i] = table[i - 1] + table[i - 5];

		while (testCase-- > 0)
			System.out.println(table[input.nextInt()]);
	}
}