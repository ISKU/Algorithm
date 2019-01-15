/*
 * Author: Minho Kim (ISKU)
 * Date: January 15, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1915
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N + 1][M + 1];
		for (int y = 1; y <= N; y++) {
			String line = br.readLine();
			for (int x = 1; x <= M; x++)
				if (line.charAt(x - 1) == '1')
					map[y][x] = true;
		}

		int[][] dp = new int[N + 1][M + 1];
		int answer = 0;
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!map[y][x])
					continue;

				dp[y][x] = Math.min(dp[y - 1][x - 1], Math.min(dp[y - 1][x], dp[y][x - 1])) + 1;
				answer = Math.max(answer, dp[y][x]);
			}
		}

		System.out.println(answer * answer);
	}
}