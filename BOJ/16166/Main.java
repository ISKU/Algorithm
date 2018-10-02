/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16166
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Map<Integer, List<Integer>> map;
	private static int[][] stations;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new HashMap<Integer, List<Integer>>();
		stations = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			stations[i] = new int[K];
			for (int j = 0; j < K; j++) {
				stations[i][j] = Integer.parseInt(st.nextToken());

				if (!map.containsKey(stations[i][j]))
					map.put(stations[i][j], new ArrayList<Integer>());
				map.get(stations[i][j]).add(i);
			}
		}

		System.out.print(bfs(Integer.parseInt(br.readLine())));
	}

	private static int bfs(int end) {
		Queue<Node> q = new LinkedList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int v : map.keySet())
			visited.put(v, false);

		for (int station : map.get(0)) {
			for (int v : stations[station]) {
				q.add(new Node(v, 0));
				visited.put(v, true);
			}
		}

		while (!q.isEmpty()) {
			Node u = q.poll();
			if (u.vertex == end)
				return u.count;

			for (int station : map.get(u.vertex)) {
				for (int v : stations[station]) {
					if (visited.get(v))
						continue;

					q.add(new Node(v, u.count + 1));
					visited.put(v, true);
				}
			}
		}

		return -1;
	}

	private static class Node {
		public int vertex, count;

		public Node(int vertex, int count) {
			this.vertex = vertex;
			this.count = count;
		}
	}
}