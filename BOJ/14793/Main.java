/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.07
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14793
 */

import java.util.*;

public class Main {

	private static long N;
	private static long K;
	private static long count;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			N = input.nextLong();
			K = input.nextLong();
			PriorityQueue<Node> queue = new PriorityQueue<Node>() {{
				add(new Node(1, (N + 1) / 2, N, N));
			}};

			count = 0;
			while (K != ++count) {
				Node p = queue.poll();
				queue.add(new Node(p.left, (p.left + p.mid) / 2, p.mid - 1, p.mid - p.left));
				queue.add(new Node(p.mid + 1, (p.mid + p.right + 1) / 2, p.right, p.right - p.mid));
			}

			Node p = queue.poll();
			long cLeft = p.mid - p.left;
			long cRight = p.right - p.mid;
			System.out.printf("Case #%d: %d %d\n", tCase, Math.max(cLeft, cRight), Math.min(cLeft, cRight));
		}
	}

	private static class Node implements Comparable<Node> {
		public long left;
		public long mid;
		public long right;
		public long size;

		public Node(long left, long mid, long right, long size) {
			this.left = left;
			this.mid = mid;
			this.right = right;
			this.size = size;
		}

		@Override
		public int compareTo(Node node) {
			if (this.size < node.size)
				return 1;
			else if (this.size > node.size)
				return -1;
			else
				return 0;
		}
	}
}