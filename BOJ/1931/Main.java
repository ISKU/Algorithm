/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1931
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Node[] array = new Node[input.nextInt()];

		for (int i = 0; i < array.length; i++)
			array[i] = new Node(input.nextInt(), input.nextInt());

		Arrays.sort(array);
		int end = array[0].end;
		int count = 1;

		for (int i = 1; i < array.length; i++) {
			if (end <= array[i].start) {
				end = array[i].end;
				count++;
			}
		}

		System.out.print(count);
	}

	private static class Node implements Comparable<Node> {
		public int start;
		public int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.end < o.end)
				return -1;
			else if (this.end > o.end)
				return 1;
			else {
				if (this.start < o.start)
					return -1;
				else if (this.start > o.start)
					return 1;
				else
					return 0;
			}
		}
	}
}