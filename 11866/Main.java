/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11866
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder("<");
		int N = input.nextInt();
		int M = input.nextInt();

		Node root = new Node(-1, null);
		Node pointer = root;
		for (int i = 1; i <= N; i++, pointer = pointer.next)
			pointer.next = new Node(i, null);
		pointer.next = root.next;

		while (true) {
			for (int i = 1; i < M; i++)
				pointer = pointer.next;

			if (pointer.next.value == pointer.value)
				break;

			output.append(pointer.next.value + ", ");
			pointer.next = pointer.next.next;
		}

		System.out.print(output.toString() + pointer.value + ">");
	}

	private static class Node {
		public int value;
		public Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}