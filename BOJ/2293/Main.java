/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2293
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] coin = new int[input.nextInt()];
		int[] table = new int[input.nextInt() + 1];

		for (int i = 0; i < coin.length; i++)
			coin[i] = input.nextInt();

		table[0] = 1;
		for (int i = 0; i < coin.length; i++)
			for (int j = coin[i]; j <= table.length - 1; j++)
				table[j] += table[j - coin[i]];

		System.out.println(table[table.length - 1]);
	}
}