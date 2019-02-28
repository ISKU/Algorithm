/*
 * Author: Minho Kim (ISKU)
 * Date: February 28, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16948
 */

import java.util.*;

public class Main {

	private static final int[] dr = new int[] { -2, -2, 0, 0, 2, 2 };
	private static final int[] dc = new int[] { -1, 1, -2, 2, -1, 1 };
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(bfs(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
	}

	private static int bfs(int r1, int c1, int r2, int c2) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new int[] { r1, c1, 0 });
		visited[r1][c1] = true;

		while (!q.isEmpty()) {
			int[] u = q.poll();
			if (u[0] == r2 && u[1] == c2)
				return u[2];

			for (int i = 0; i < 6; i++) {
				int r = u[0] + dr[i];
				int c = u[1] + dc[i];
				if (r < 0 || r >= N || c < 0 || c >= N || visited[r][c])
					continue;

				visited[r][c] = true;
				q.add(new int[] { r, c, u[2] + 1 });
			}
		}

		return -1;
	}
}