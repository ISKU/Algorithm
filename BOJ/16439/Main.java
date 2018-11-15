/*
 * Author: Minho Kim (ISKU)
 * Date: November 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16439
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] table = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				table[i][j] = sc.nextInt();

		int answer = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					int sum = 0;

					for (int n = 0; n < N; n++)
						sum += Math.max(table[n][i], Math.max(table[n][j], table[n][k]));

					answer = Math.max(answer, sum);
				}
			}
		}

		System.out.print(answer);
	}
}