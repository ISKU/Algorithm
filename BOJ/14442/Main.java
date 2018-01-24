/*
 * Author: Minho Kim (ISKU)
 * Date: January 25, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14442
 */

import java.util.*;

public class Main {

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();

		int[][] graph = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			String line[] = sc.next().split("");
			for (int x = 0; x < X; x++)
				graph[y][x] = Integer.parseInt(line[x]);
		}

		int[][][] visited = new int[Y][X][K + 1];
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, 0));
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.y == Y - 1 && node.x == X - 1) {
				System.out.print(visited[node.y][node.x][node.block]);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int y = node.y + dy[i];
				int x = node.x + dx[i];

				if (y >= 0 && y < Y && x >= 0 && x < X) {
					if (graph[y][x] == 0 && visited[y][x][node.block] == 0) {
						q.add(new Node(y, x, node.block));
						visited[y][x][node.block] = visited[node.y][node.x][node.block] + 1;
					}
					if (graph[y][x] == 1 && node.block < K && visited[y][x][node.block + 1] == 0) {
						q.add(new Node(y, x, node.block + 1));
						visited[y][x][node.block + 1] = visited[node.y][node.x][node.block] + 1;
					}
				}
			}
		}

		System.out.print(-1);
	}

	private static class Node {
		public int y, x;
		public int block;

		public Node(int y, int x, int block) {
			this.y = y;
			this.x = x;
			this.block = block;
		}
	}
}