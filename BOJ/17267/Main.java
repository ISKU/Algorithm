/*
 * Author: Minho Kim (ISKU)
 * Date: June 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17267
 */

import java.io.*;
import java.util.*;

public class Main {

	private static boolean[][] map;
	private static int[][] left, right;
	private static int Y, X, L, R, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new boolean[Y][X];
		int sy = -1;
		int sx = -1;
		for (int y = 0; y < Y; y++) {
			String line = br.readLine();
			for (int x = 0; x < X; x++) {
				if (line.charAt(x) == '1')
					map[y][x] = true;
				if (line.charAt(x) == '2') {
					sy = y;
					sx = x;
				}
			}
		}

		left = new int[Y][X];
		right = new int[Y][X];
		dfs(sy, sx, 0, 0);
		System.out.print(answer);
	}

	private static void dfs(int y, int x, int l, int r) {
		if (!map[y][x]) {
			map[y][x] = true;
			answer++;
		}
		left[y][x] = l;
		right[y][x] = r;

		if (y - 1 >= 0 && (!map[y - 1][x] || left[y - 1][x] > l || right[y - 1][x] > r))
			dfs(y - 1, x, l, r);
		if (y + 1 < Y && (!map[y + 1][x] || left[y + 1][x] > l || right[y + 1][x] > r))
			dfs(y + 1, x, l, r);
		if (x - 1 >= 0 && l < L && (!map[y][x - 1] || left[y][x - 1] > l || right[y][x - 1] > r))
			dfs(y, x - 1, l + 1, r);
		if (x + 1 < X && r < R && (!map[y][x + 1] || left[y][x + 1] > l || right[y][x + 1] > r))
			dfs(y, x + 1, l, r + 1);
	}
}