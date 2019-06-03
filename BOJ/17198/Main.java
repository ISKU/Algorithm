/*
 * Author: Minho Kim (ISKU)
 * Date: June 3, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17198
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };
	private static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[10][10];
		int sy = 0;
		int sx = 0;
		for (int y = 0; y < 10; y++) {
			map[y] = br.readLine().toCharArray();
			for (int x = 0; x < 10; x++) {
				if (map[y][x] == 'B') {
					sy = y;
					sx = x;
				}
			}
		}

		System.out.print(bfs(sy, sx));
	}

	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[10][10];

		q.add(new int[] { sy, sx, 0 });
		visited[sy][sx] = true;
		while (!q.isEmpty()) {
			int[] u = q.poll();
			if (map[u[0]][u[1]] == 'L')
				return u[2] - 1;

			for (int i = 0; i < 4; i++) {
				int y = u[0] + dy[i];
				int x = u[1] + dx[i];
				if (y < 0 || y >= 10 || x < 0 || x >= 10 || visited[y][x] || map[y][x] == 'R')
					continue;

				q.add(new int[] { y, x, u[2] + 1 });
				visited[y][x] = true;
			}
		}

		return 0;
	}
}