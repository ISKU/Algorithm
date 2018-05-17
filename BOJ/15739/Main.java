/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15739
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean[] set = new boolean[N * N + 1];
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
				set[matrix[i][j]] = true;
			}
		}

		int S = (N * N * N + N) / 2;
		boolean check = true;
		int sum = 0;

		for (int i = 1; i < set.length; i++)
			if (!set[i])
				check = false;

		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++)
				sum += matrix[i][j];

			if (sum != S)
				check = false;
		}

		for (int j = 0; j < N; j++) {
			sum = 0;
			for (int i = 0; i < N; i++)
				sum += matrix[i][j];

			if (sum != S)
				check = false;
		}

		sum = 0;
		for (int i = 0; i < N; i++)
			sum += matrix[i][i];
		if (sum != S)
			check = false;

		sum = 0;
		for (int i = N - 1; i >= 0; i--)
			sum += matrix[i][i];
		if (sum != S)
			check = false;

		System.out.print(check ? "TRUE" : "FALSE");
	}
}