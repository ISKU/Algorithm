/*
 * Author: Minho Kim (ISKU)
 * Date: March 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14925
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] map = new int[Y + 1][X + 1];
		for (int y = 1; y <= Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= X; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[Y + 1][X + 1];
		int answer = 0;
		for (int y = 1; y <= Y; y++) {
			for (int x = 1; x <= X; x++) {
				if (map[y][x] != 0)
					continue;

				dp[y][x] = Math.min(dp[y - 1][x - 1], Math.min(dp[y - 1][x], dp[y][x - 1])) + 1;
				answer = Math.max(answer, dp[y][x]);
			}
		}

		System.out.println(answer);
	}
}