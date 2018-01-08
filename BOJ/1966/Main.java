/* 
 * Author: Minho Kim (ISKU)
 * Date: January 8, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1966
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			LinkedList<Node> queue = new LinkedList<Node>();
			int N = input.nextInt();
			int M = input.nextInt();

			for (int i = 0; i < N; i++)
				queue.addLast(new Node(i, input.nextInt()));

			int count = 0;
			while (!queue.isEmpty()) {
				Node node = queue.pollFirst();

				boolean check = true;
				for (Node i : queue)
					if (node.priority < i.priority)
						check = false;

				if (check) {
					count++;
					if (node.index == M)
						break;
				} else
					queue.addLast(node);
			}

			System.out.println(count);
		}
	}

	private static class Node {
		public int index;
		public int priority;

		public Node(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
}