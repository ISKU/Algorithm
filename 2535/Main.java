/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2535
 */

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		int N = input.nextInt();

		while (N-- > 0)
			queue.add(new Node(input.nextInt(), input.nextInt(), input.nextInt()));

		for (int count = 0; count != 3;) {
			Node cur = queue.poll();
			table.put(cur.nation, table.containsKey(cur.nation) ? table.get(cur.nation) + 1 : 1);

			if (table.get(cur.nation) < 3) {
				System.out.printf("%d %d\n", cur.nation, cur.number);
				count++;
			}
		}
	}

	private static class Node implements Comparable<Node> {
		public int nation;
		public int number;
		public int score;

		public Node(int nation, int number, int score) {
			this.nation = nation;
			this.number = number;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {
			if (this.score > o.score)
				return -1;
			else if (this.score < o.score)
				return 1;
			else
				return 0;
		}
	}
}