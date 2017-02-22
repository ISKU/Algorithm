/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2178
 */

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	private static Node[][] maze;
	private static int N;
	private static int M;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		maze = new Node[N + 2][M + 2];
		for (int y = 1; y <= N; y++) {
			String[] line = input.next().split("");

			for (int x = 1; x <= M; x++)
				maze[y][x] = (line[x - 1].equals("1")) ? new Node(y, x, true) : new Node(y, x, false);
		}

		for (int x = 0; x <= M + 1; x++) {
			maze[0][x] = new Node(0, x, false);
			maze[N + 1][x] = new Node(N + 1, x, false);
		}
		for (int y = 1; y <= N + 1; y++) {
			maze[y][0] = new Node(y, 0, false);
			maze[y][M + 1] = new Node(y, M + 1, false);
		}

		bfs(maze[1][1]);
	}

	private static void bfs(Node v) {
		LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(v);
		maze[v.y][v.x].visited++;

		while (!queue.isEmpty()) {
			v = queue.poll();

			if (v.y == N && v.x == M) {
				System.out.print(maze[v.y][v.x].visited);
				break;
			}

			if (maze[v.y - 1][v.x].visited == 0 && maze[v.y - 1][v.x].cell) {
				queue.add(maze[v.y - 1][v.x]);
				maze[v.y - 1][v.x].visited = maze[v.y][v.x].visited + 1;
			}
			if (maze[v.y + 1][v.x].visited == 0 && maze[v.y + 1][v.x].cell) {
				queue.add(maze[v.y + 1][v.x]);
				maze[v.y + 1][v.x].visited = maze[v.y][v.x].visited + 1;
			}
			if (maze[v.y][v.x - 1].visited == 0 && maze[v.y][v.x - 1].cell) {
				queue.add(maze[v.y][v.x - 1]);
				maze[v.y][v.x - 1].visited = maze[v.y][v.x].visited + 1;
			}
			if (maze[v.y][v.x + 1].visited == 0 && maze[v.y][v.x + 1].cell) {
				queue.add(maze[v.y][v.x + 1]);
				maze[v.y][v.x + 1].visited = maze[v.y][v.x].visited + 1;
			}
		}
	}

	private static class Node {
		public int y;
		public int x;
		public boolean cell;
		public int visited;

		public Node(int y, int x, boolean cell) {
			this.y = y;
			this.x = x;
			this.cell = cell;
			this.visited = 0;
		}
	}
}