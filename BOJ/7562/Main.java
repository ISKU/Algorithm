/*
 * Author: Minho Kim (ISKU)
 * Date: January 25, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7562
 */

import java.util.*;

public class Main {

	private static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			int l = sc.nextInt();
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			int ty = sc.nextInt();
			int tx = sc.nextInt();

			int[][] visited = new int[l][l];
			Queue<Node> q = new LinkedList<Node>();
			visited[sy][sx] = 1;
			q.add(new Node(sy, sx));

			while (!q.isEmpty()) {
				Node node = q.poll();

				if (node.y == ty && node.x == tx) {
					System.out.println(visited[ty][tx] - 1);
					break;
				}

				for (int i = 0; i < 8; i++) {
					int y = node.y + dy[i];
					int x = node.x + dx[i];

					if (y >= 0 && y < l && x >= 0 && x < l && visited[y][x] == 0) {
						q.add(new Node(y, x));
						visited[y][x] = visited[node.y][node.x] + 1;
					}
				}
			}
		}
	}

	private static class Node {
		public int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}