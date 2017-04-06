/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2346
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		Node start = new Node(0, 0);
		Node p = start;
		for (int i = 1; i <= N; i++) {
			Node temp = p;
			p.next = new Node(i, input.nextInt());
			p = p.next;
			p.prev = temp;
		}
		Node end = p;
		p.next = start.next;
		p = start.next;
		p.prev = end;

		while (N-- > 0) {
			System.out.printf("%d ", p.index);
			int move = p.value;
			Node t = p.prev;
			p.prev.next = p.next;
			p.next.prev = t;

			for (int i = 0; i < Math.abs(move); i++)
				if (move < 0)
					p = p.prev;
				else
					p = p.next;
		}
	}

	private static class Node {
		public int index;
		public int value;
		public Node prev;
		public Node next;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}