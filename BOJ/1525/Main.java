/*
 * Author: Minho Kim (ISKU)
 * Date: October 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1525
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };
	private static int[][] target;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		target = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
		int[][] start = new int[3][3];
		int sy = 0;
		int sx = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				start[y][x] = sc.nextInt();
				if (start[y][x] == 0) {
					sy = y;
					sx = x;
				}
			}
		}

		System.out.print(astar(heuristic(start), start, sy, sx));

	}

	private static int astar(int h, int[][] smap, int sy, int sx) {
		Set<String> visited = new HashSet<>();
		Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.f, o2.f);
			}
		});

		visited.add(getKey(smap));
		pq.add(new Node(0, h, smap, sy, sx));

		while (!pq.isEmpty()) {
			Node p = pq.poll();
			if (p.f - p.g == 0)
				return p.g;

			for (int i = 0; i < 4; i++) {
				int y = p.sy + dy[i];
				int x = p.sx + dx[i];
				if (y < 0 || y >= 3 || x < 0 || x >= 3)
					continue;

				int[][] puzzle = new int[3][3];
				for (int j = 0; j < 3; j++)
					puzzle[j] = Arrays.copyOf(p.puzzle[j], 3);
				puzzle[p.sy][p.sx] = puzzle[y][x];
				puzzle[y][x] = 0;

				String key = getKey(puzzle);
				if (visited.contains(key))
					continue;

				h = heuristic(puzzle);
				visited.add(key);
				pq.add(new Node(p.g + 1, p.g + 1 + h, puzzle, y, x));
			}
		}

		return -1;
	}

	private static int heuristic(int[][] puzzle) {
		int h = 0;

		for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
				if (puzzle[y][x] != target[y][x])
					h++;

		return h;
	}

	private static String getKey(int[][] puzzle) {
		StringBuilder sb = new StringBuilder();

		for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
				sb.append(puzzle[y][x]);

		return sb.toString();
	}

	private static class Node {
		public int g, f;
		public int[][] puzzle;
		public int sy, sx;

		public Node(int g, int f, int[][] puzzle, int sy, int sx) {
			this.g = g;
			this.f = f;
			this.puzzle = puzzle;
			this.sy = sy;
			this.sx = sx;
		}
	}
}