/*
 * Author: Minho Kim (ISKU)
 * Date: January 13, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7568
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] record = new int[N];

		Node[] people = new Node[N];
		for (int i = 0; i < N; i++)
			people[i] = new Node(sc.nextInt(), sc.nextInt());

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (people[i].compare(people[j]))
					record[i]++;

		for (int i = 0; i < N; i++)
			System.out.printf("%d ", record[i] + 1);
	}

	private static class Node {
		public int height;
		public int weight;

		public boolean compare(Node o) {
			if (this.height < o.height && this.weight < o.weight)
				return true;
			return false;
		}

		public Node(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
	}
}