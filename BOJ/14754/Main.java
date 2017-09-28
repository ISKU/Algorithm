/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14754
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(parser.nextToken());
		int M = Integer.parseInt(parser.nextToken());

		long[][] grid = new long[N][M];
		boolean[][] check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			parser = new StringTokenizer(input.readLine());
			long max = 0;
			int index = 0;

			for (int j = 0; j < M; j++) {
				grid[i][j] = Long.parseLong(parser.nextToken());
				if (max < grid[i][j]) {
					max = grid[i][j];
					index = j;
				}
			}

			check[i][index] = true;
		}

		for (int j = 0; j < M; j++) {
			long max = 0;
			int index = 0;

			for (int i = 0; i < N; i++) {
				if (max < grid[i][j]) {
					max = grid[i][j];
					index = i;
				}
			}

			check[index][j] = true;
		}

		long sum = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (!check[i][j])
					sum += grid[i][j];

		System.out.print(sum);
	}
}