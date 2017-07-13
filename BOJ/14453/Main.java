/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14453
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] table = new int[N];
		int[] reverse = new int[N];

		for (int i = 0; i < N; i++) {
			String gesture = input.next();

			if (gesture.equals("P"))
				table[i] = 1;
			else if (gesture.equals("S"))
				table[i] = 2;

			reverse[table.length - 1 - i] = table[i];
		}

		int[][] prefix = getMatch(table);
		int[][] suffix = getMatch(reverse);
		int ret = 0;

		for (int k = 0; k <= N; k++)
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					ret = Math.max(ret, prefix[i][k] + suffix[j][N - k]);

		System.out.print(ret);
	}

	public static int[][] getMatch(int[] table) {
		int[][] match = new int[3][table.length + 1];

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < 3; j++)
				match[j][i + 1] = match[j][i];
			match[table[i]][i + 1]++;
		}

		return match;
	}
}