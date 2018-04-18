/*
 * Author: Minho Kim (ISKU)
 * Date: April 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15683
 */

import java.util.*;

public class Main {

	private static final int[] direction = { 0, 4, 2, 4, 4, 1 };

	private static int Y, X;
	private static int[][] origin;
	private static ArrayList<CCTV> cctvs;
	private static int N, answer;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();

		cctvs = new ArrayList<CCTV>();
		origin = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				origin[y][x] = sc.nextInt();
				if (origin[y][x] != 0 && origin[y][x] != 6)
					cctvs.add(new CCTV(y, x, origin[y][x]));
			}
		}

		N = cctvs.size();
		answer = Integer.MAX_VALUE;
		dfs(0, 1, 0);

		System.out.print(answer);
	}

	private static void dfs(int n, int d, int info) {
		if (n >= N) {
			int[][] map = new int[Y][X];
			for (int y = 0; y < Y; y++)
				for (int x = 0; x < X; x++)
					map[y][x] = origin[y][x];

			for (int i = 0; i < N; i++, info /= 10) {
				CCTV cctv = cctvs.get(i);
				int dir = info % 10;

				if (cctv.type == 1) {
					if (dir == 1)
						top(cctv.y, cctv.x, map);
					else if (dir == 2)
						right(cctv.y, cctv.x, map);
					else if (dir == 3)
						bottom(cctv.y, cctv.x, map);
					else if (dir == 4)
						left(cctv.y, cctv.x, map);
				}
				else if (cctv.type == 2) {
					if (dir == 1) {
						top(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
					} else if (dir == 2) {
						right(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					}
				}
				else if (cctv.type == 3) {
					if (dir == 1) {
						top(cctv.y, cctv.x, map);
						right(cctv.y, cctv.x, map);
					} else if (dir == 2) {
						right(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
					} else if (dir == 3) {
						bottom(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					} else if (dir == 4) {
						top(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					}
				}
				else if (cctv.type == 4) {
					if (dir == 1) {
						top(cctv.y, cctv.x, map);
						right(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					} else if (dir == 2) {
						top(cctv.y, cctv.x, map);
						right(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
					} else if (dir == 3) {
						right(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					} else if (dir == 4) {
						top(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					}
				}
				else if (cctv.type == 5) {
					if (dir == 1) {
						top(cctv.y, cctv.x, map);
						right(cctv.y, cctv.x, map);
						bottom(cctv.y, cctv.x, map);
						left(cctv.y, cctv.x, map);
					}
				}
			}

			int count = 0;
			for (int y = 0; y < Y; y++)
				for (int x = 0; x < X; x++)
					if (map[y][x] == 0)
						count++;

			answer = Math.min(answer, count);
			return;
		}

		for (int i = 1; i <= direction[cctvs.get(n).type]; i++)
			dfs(n + 1, d * 10, info + d * i);
	}

	private static void top(int y, int x, int[][] map) {
		for (int i = y - 1; i >= 0; i--) {
			if (map[i][x] == 6)
				return;
			map[i][x] = -1;
		}
	}

	private static void right(int y, int x, int[][] map) {
		for (int j = x + 1; j < X; j++) {
			if (map[y][j] == 6)
				return;
			map[y][j] = -1;
		}
	}

	private static void bottom(int y, int x, int[][] map) {
		for (int i = y + 1; i < Y; i++) {
			if (map[i][x] == 6)
				return;
			map[i][x] = -1;
		}
	}

	private static void left(int y, int x, int[][] map) {
		for (int j = x - 1; j >= 0; j--) {
			if (map[y][j] == 6)
				return;
			map[y][j] = -1;
		}
	}

	private static class CCTV {
		public int y, x;
		public int type;

		public CCTV(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
}