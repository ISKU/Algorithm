/*
 * Author: Minho Kim (ISKU)
 * Date: October 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2021
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Integer>[] stations, route;
	private static int N, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		stations = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			stations[i] = new ArrayList<Integer>();
		route = new ArrayList[L];
		for (int i = 0; i < L; i++)
			route[i] = new ArrayList<Integer>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1)
					break;
				route[i].add(v);
				stations[v].add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.print(bfs(start, end));
	}

	private static int bfs(int start, int end) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visitedStation = new boolean[N + 1];
		boolean[] visitedRoute = new boolean[L];

		for (int station : stations[start]) {
			visitedRoute[station] = true;

			for (int v : route[station]) {
				q.add(new Node(v, 0));
				visitedStation[v] = true;
			}
		}

		while (!q.isEmpty()) {
			Node u = q.poll();
			if (u.vertex == end)
				return u.count;

			for (int station : stations[u.vertex]) {
				if (visitedRoute[station])
					continue;
				visitedRoute[station] = true;

				for (int v : route[station]) {
					if (visitedStation[v])
						continue;

					q.add(new Node(v, u.count + 1));
					visitedStation[v] = true;
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