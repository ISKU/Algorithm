/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16397
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int G = sc.nextInt();
		System.out.print(bfs(N, T, G));
	}

	private static String bfs(int N, int T, int G) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[100000];
		q.add(new Node(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Node u = q.poll();
			if (u.n == G)
				return (u.t <= T) ? String.valueOf(u.t) : "ANG";

			if (u.n + 1 < 100000 && !visited[u.n + 1]) {
				q.add(new Node(u.n + 1, u.t + 1));
				visited[u.n + 1] = true;
			}

			String n = String.valueOf(u.n * 2);
			int v = (u.n * 2) - (int) Math.pow(10, n.length() - 1);
			if (u.n * 2 < 100000 && v > 0 && v < 100000 && !visited[v]) {
				q.add(new Node(v, u.t + 1));
				visited[v] = true;
			}
		}

		return "ANG";
	}

	private static class Node {
		public int n, t;

		public Node(int n, int t) {
			this.n = n;
			this.t = t;
		}
	}
}