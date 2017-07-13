/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11048
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[][] array = new int[N][M];
		int[][] table = new int[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				array[i][j] = input.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i - 1 < 0 && j - 1 < 0) {
					table[i][j] = array[i][j];
					continue;
				}

				if (i - 1 < 0) {
					table[i][j] = array[i][j] + table[i][j - 1];
					continue;
				}

				if (j - 1 < 0) {
					table[i][j] = array[i][j] + table[i - 1][j];
					continue;
				}

				int temp = Math.max(table[i - 1][j], table[i - 1][j - 1]);
				table[i][j] = Math.max(temp, table[i][j - 1]) + array[i][j];
			}
		}

		System.out.println(table[N - 1][M - 1]);
	}
}