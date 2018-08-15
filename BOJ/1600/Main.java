/*
 * Author: Minho Kim (ISKU)
 * Date: August 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1600
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int[] sy = new int[] { -2, -2, -1, -1, 1, 1, 2, 2 };
	private static final int[] sx = new int[] { -1, 1, -2, 2, -2, 2, -1, 1 };
	private static final int[] dy = new int[] { -1, 0, 0, 1 };
	private static final int[] dx = new int[] { 0, -1, 1, 0 };

	private static boolean[][] map;
	private static int[][][] visited;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		map = new boolean[H][W];
		for (int y = 0; y < H; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < W; x++)
				map[y][x] = (st.nextToken().equals("1")) ? true : false;
		}

		Queue<Cell> q = new LinkedList<>();
		q.add(new Cell(0, 0, 0));
		visited = new int[H][W][K + 1];
		while (!q.isEmpty()) {
			Cell c = q.poll();
			if (c.y == H - 1 && c.x == W - 1) {
				System.out.print(visited[c.y][c.x][c.k]);
				System.exit(0);
			}

			if (c.k < K) {
				for (int i = 0; i < 8; i++) {
					int y = c.y + sy[i];
					int x = c.x + sx[i];
					if (y < 0 || y >= H || x < 0 || x >= W || map[y][x])
						continue;

					if (visited[y][x][c.k + 1] == 0) {
						q.add(new Cell(y, x, c.k + 1));
						visited[y][x][c.k + 1] = visited[c.y][c.x][c.k] + 1;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int y = c.y + dy[i];
				int x = c.x + dx[i];
				if (y < 0 || y >= H || x < 0 || x >= W || map[y][x])
					continue;

				if (visited[y][x][c.k] == 0) {
					q.add(new Cell(y, x, c.k));
					visited[y][x][c.k] = visited[c.y][c.x][c.k] + 1;
				}
			}
		}

		System.out.print(-1);
	}

	private static class Cell {
		public int y, x, k;

		public Cell(int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
}