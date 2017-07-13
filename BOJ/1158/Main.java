/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1158
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		Node root = new Node(-1, null);
		Node pointer = root;
		for (int i = 1; i <= N; i++) {
			pointer.next = new Node(i, null);
			pointer = pointer.next;
		}
		pointer.next = root.next;

		System.out.print("<");
		while (true) {
			for (int i = 0; i < M - 1; i++)
				pointer = pointer.next;

			if (pointer.next.number == pointer.number)
				break;

			System.out.print(pointer.next.number + ", ");
			pointer.next = pointer.next.next;
		}

		System.out.print(pointer.number + ">");
	}

	private static class Node {
		public int number;
		public Node next;

		public Node(int number, Node next) {
			this.number = number;
			this.next = next;
		}
	}
}