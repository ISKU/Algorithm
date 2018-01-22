/*
 * Author: Minho Kim (ISKU)
 * Date: January 23, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13913
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Node> queue = new LinkedList<Node>();
		int[] visited = new int[100001];
		Arrays.fill(visited, -2);
		visited[N] = -1;
		queue.add(new Node(N, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int step = node.step;

			if (x == K) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				while (x != -1) {
					path.add(x);
					x = visited[x];
				}

				System.out.println(step);
				for (int i = path.size() - 1; i >= 0; i--)
					System.out.print(path.get(i) + " ");

				break;
			}

			if (x - 1 >= 0 && visited[x - 1] == -2) {
				visited[x - 1] = x;
				queue.add(new Node(x - 1, step + 1));
			}
			if (x + 1 <= 100000 && visited[x + 1] == -2) {
				visited[x + 1] = x;
				queue.add(new Node(x + 1, step + 1));
			}
			if (x * 2 <= 100000 && visited[x * 2] == -2) {
				visited[x * 2] = x;
				queue.add(new Node(x * 2, step + 1));
			}
		}
	}

	private static class Node {
		public int x;
		public int step;

		public Node(int x, int step) {
			this.x = x;
			this.step = step;
		}
	}
}