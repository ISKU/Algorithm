/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17130
 */

import java.io.*;
import java.util.*;

public class Main {

	private static char[][] map;
	private static int[][] dp;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int startY = 0;
		int startX = 0;
		map = new char[Y][X];
		dp = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			String line = br.readLine();
			for (int x = 0; x < X; x++) {
				map[y][x] = line.charAt(x);
				dp[y][x] = -1;
				if (map[y][x] == 'R') {
					startY = y;
					startX = x;
					dp[y][x] = 0;
				}
			}
		}

		int answer = -1;
		for (int x = startX + 1, sy = startY, ey = startY; x < X; x++) {
			if (sy - 1 >= 0)
				sy--;
			if (ey + 1 < Y)
				ey++;

			for (int y = sy; y <= ey; y++) {
				if (map[y][x] == '#')
					continue;

				if (dp[y][x - 1] != -1)
					dp[y][x] = dp[y][x - 1];
				if (y - 1 >= 0 && dp[y - 1][x - 1] != -1)
					dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1]);
				if (y + 1 < Y && dp[y + 1][x - 1] != -1)
					dp[y][x] = Math.max(dp[y][x], dp[y + 1][x - 1]);

				if (map[y][x] == 'C' && dp[y][x] != -1)
					dp[y][x]++;
				if (map[y][x] == 'O' && dp[y][x] != -1)
					answer = Math.max(answer, dp[y][x]);
			}
		}

		System.out.println(answer);
	}
}