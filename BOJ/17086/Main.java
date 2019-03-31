/*
 * Author: Minho Kim (ISKU)
 * Date: March 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17086
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int[] dy = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static final int[] dx = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

	private static boolean[][] map;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new boolean[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++)
				map[y][x] = st.nextToken().equals("1") ? true : false;
		}

		int answer = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (!map[y][x])
					answer = Math.max(answer, bfs(y, x));

		System.out.println(answer);
	}

	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[Y][X];
		q.add(new int[] { sy, sx, 0 });
		visited[sy][sx] = true;

		while (!q.isEmpty()) {
			int[] u = q.poll();
			if (map[u[0]][u[1]])
				return u[2];

			for (int i = 0; i < 8; i++) {
				int y = u[0] + dy[i];
				int x = u[1] + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x])
					continue;

				visited[y][x] = true;
				q.add(new int[] { y, x, u[2] + 1 });
			}
		}

		return 0;
	}
}