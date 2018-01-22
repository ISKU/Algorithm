/*
 * Author: Minho Kim (ISKU)
 * Date: January 23, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13549
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		queue.add(new Node(N, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int step = node.step;

			if (x == K) {
				System.out.print(step);
				break;
			}

			int tempX = x * 2;
			while (tempX <= 100000 && !visited[tempX]) {
				visited[tempX] = true;
				queue.add(new Node(tempX, step));
				tempX *= 2;
			}
			if (x - 1 >= 0 && !visited[x - 1]) {
				visited[x - 1] = true;
				queue.add(new Node(x - 1, step + 1));
			}
			if (x + 1 <= 100000 && !visited[x + 1]) {
				visited[x + 1] = true;
				queue.add(new Node(x + 1, step + 1));
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