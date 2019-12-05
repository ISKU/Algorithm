/*
 * Author: Minho Kim (ISKU)
 * Date: December 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17836
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = { -1, 1, 0, 0 };
	public static final int[] dx = { 0, 0, -1, 1 };
	public static final int MAX = 500000;

	private static int[][] map;
	private static int Y, X, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int pcount = 0;
		map = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2)
					pcount = (Y - 1 - y) + (X - 1 - x);
			}
		}

		int first = bfs(1);
		int second = bfs(2);
		if (first == MAX && second == MAX || (first > T && second + pcount > T)) {
			System.out.println("Fail");
			System.exit(0);
		}
		System.out.println((first < second + pcount) ? first : second + pcount);
	}

	private static int bfs(int target) {
		Queue<int[]> q = new LinkedList<>();
		int[][] visited = new int[Y][X];

		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int py = p[0];
			int px = p[1];
			int count = visited[py][px];
			if (target == 1 && py == Y - 1 && px == X - 1)
				return count;
			if (target == 2 && map[py][px] == 2)
				return count;

			for (int i = 0; i < 4; i++) {
				int y = py + dy[i];
				int x = px + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x] > 0 || map[y][x] == 1)
					continue;

				visited[y][x] = count + 1;
				q.add(new int[] { y, x });
			}
		}

		return MAX;
	}
}
