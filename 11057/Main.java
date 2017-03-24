/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11057
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int[][] table = new int[new Scanner(System.in).nextInt()][10];

		for (int i = 1; i <= 10; i++)
			table[0][i - 1] = i;

		for (int i = 1; i < table.length; i++) {
			table[i][0] = 1;
			for (int j = 1; j < 10; j++)
				table[i][j] = table[i - 1][j] + table[i][j - 1] % 10007;
		}

		System.out.print(table[table.length - 1][9] % 10007);
	}
}