/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1697
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[100001];
		queue.add(new Node(N, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int count = node.count;

			if (x == K) {
				System.out.print(count);
				break;
			}

			if (x - 1 >= 0 && !visited[x - 1]) {
				visited[x - 1] = true;
				queue.add(new Node(x - 1, count + 1));
			}
			if (x + 1 <= 100000 && !visited[x + 1]) {
				visited[x + 1] = true;
				queue.add(new Node(x + 1, count + 1));
			}
			if (x * 2 <= 100000 && !visited[x * 2]) {
				visited[x * 2] = true;
				queue.add(new Node(x * 2, count + 1));
			}
		}
	}

	private static class Node {
		public int x;
		public int count;

		public Node(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
}