/*
 * Author: Minho Kim (ISKU)
 * Date: December 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5427
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = { -1, 1, 0, 0 };
	public static final int[] dx = { 0, 0, -1, 1 };

	private static int Y, X;
	private static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			map = new char[Y][];
			for (int y = 0; y < Y; y++)
				map[y] = br.readLine().toCharArray();

			int answer = bfs();
			bw.write((answer == -1) ? "IMPOSSIBLE" : String.valueOf(answer));
			bw.write('\n');
		}

		bw.close();
	}

	private static int bfs() {
		Queue<int[]> fireQ = new LinkedList<>();
		Queue<int[]> manQ = new LinkedList<>();
		boolean[][] fireVisited = new boolean[Y][X];
		boolean[][] manVisited = new boolean[Y][X];

		int sy = 0;
		int sx = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x] == '@') {
					sy = y;
					sx = x;
					manVisited[y][x] = true;
				}
				if (map[y][x] == '*') {
					fireQ.add(new int[] { y, x });
					fireVisited[y][x] = true;
				}
			}
		}
		manQ.add(new int[] { sy, sx, 0 });

		while (!manQ.isEmpty() || !fireQ.isEmpty()) {
			int size = fireQ.size();
			while (size-- > 0) {
				int[] f = fireQ.poll();
				int fy = f[0];
				int fx = f[1];
				for (int i = 0; i < 4; i++) {
					int y = fy + dy[i];
					int x = fx + dx[i];
					if (y < 0 || y >= Y || x < 0 || x >= X)
						continue;
					if (fireVisited[y][x] || map[y][x] == '#')
						continue;

					fireVisited[y][x] = true;
					fireQ.add(new int[] { y, x });
				}
			}

			size = manQ.size();
			while (size-- > 0) {
				int[] m = manQ.poll();
				int my = m[0];
				int mx = m[1];
				int mcount = m[2];
				for (int i = 0; i < 4; i++) {
					int y = my + dy[i];
					int x = mx + dx[i];
					if (y < 0 || y >= Y || x < 0 || x >= X)
						return mcount + 1;
					if (fireVisited[y][x] || manVisited[y][x] || map[y][x] != '.')
						continue;

					manVisited[y][x] = true;
					manQ.add(new int[] { y, x, mcount + 1 });
				}
			}
		}

		return -1;
	}
}
