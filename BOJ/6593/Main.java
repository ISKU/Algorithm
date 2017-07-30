/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6593
 */

import java.util.*;

public class Main {

	private static boolean[][][] graph;
	private static int L, R, C;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			L = input.nextInt();
			R = input.nextInt();
			C = input.nextInt();
			if (L == 0 && R == 0 && C == 0)
				break;
			input.nextLine();

			Edge start = new Edge(0, 0, 0, 0);
			Edge end = new Edge(0, 0, 0, 0);
			graph = new boolean[L][R][C];
			for (int z = 0; z < L; z++) {
				for (int y = 0; y < R; y++) {
					char[] line = input.nextLine().toCharArray();
					for (int x = 0; x < C; x++) {
						if (line[x] == 'S')
							start = new Edge(z, y, x, 0);
						else if (line[x] == 'E')
							end = new Edge(z, y, x, 0);
						else if (line[x] == '.')
							graph[z][y][x] = false;
						else
							graph[z][y][x] = true;
					}
				}
				input.nextLine();
			}

			int answer = dijkstra(start, end);
			if (answer == -1)
				System.out.println("Trapped!");
			else
				System.out.printf("Escaped in %d minute(s).\n", answer);
		}
	}

	private static int dijkstra(final Edge start, final Edge end) {
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge A, Edge B) {
				return A.weight - B.weight;
			}
		}) {{ add(new Edge(start.z, start.y, start.x, start.weight)); }};

		int[][][] dist = new int[L][R][C];
		for (int z = 0; z < L; z++)
			for (int y = 0; y < R; y++)
				for (int x = 0; x < C; x++)
					dist[z][y][x] = -1;
		dist[start.z][start.y][start.x] = 0;

		while (!pQueue.isEmpty()) {
			Edge vertex = pQueue.poll();
			int y = vertex.y;
			int x = vertex.x;
			int z = vertex.z;
			int weight = vertex.weight;

			if (z - 1 >= 0 && !graph[z - 1][y][x] &&  (dist[z - 1][y][x] == -1 || dist[z - 1][y][x] > weight + 1)) {
				dist[z - 1][y][x] = weight + 1;
				pQueue.add(new Edge(z - 1, y, x, weight + 1));
			}
			if (y - 1 >= 0 && !graph[z][y - 1][x] && (dist[z][y - 1][x] == -1 || dist[z][y - 1][x] > weight + 1)) {
				dist[z][y - 1][x] = weight + 1;
				pQueue.add(new Edge(z, y - 1, x, weight + 1));
			}
			if (x - 1 >= 0 && !graph[z][y][x - 1] && (dist[z][y][x - 1] == -1 || dist[z][y][x - 1] > weight + 1)) {
				dist[z][y][x - 1] = weight + 1;
				pQueue.add(new Edge(z, y, x - 1, weight + 1));
			}
			if (z + 1 < L && !graph[z + 1][y][x] && (dist[z + 1][y][x] == -1 || dist[z + 1][y][x] > weight + 1)) {
				dist[z + 1][y][x] = weight + 1;
				pQueue.add(new Edge(z + 1, y, x, weight + 1));
			}
			if (y + 1 < R && !graph[z][y + 1][x] && (dist[z][y + 1][x] == -1 || dist[z][y + 1][x] > weight + 1)) {
				dist[z][y + 1][x] = weight + 1;
				pQueue.add(new Edge(z, y + 1, x, weight + 1));
			}
			if (x + 1 < C && !graph[z][y][x + 1] && (dist[z][y][x + 1] == -1 || dist[z][y][x + 1] > weight + 1)) {
				dist[z][y][x + 1] = weight + 1;
				pQueue.add(new Edge(z, y, x + 1, weight + 1));
			}
		}

		return dist[end.z][end.y][end.x];
	}

	private static class Edge {
		public int z;
		public int y;
		public int x;
		public int weight;

		public Edge(int z, int y, int x, int weight) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
	}
}