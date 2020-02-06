/*
 * Author: Minho Kim (ISKU)
 * Date: February 6, 2020
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2108
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[8001];
		int[] array = new int[N];
		for (int i = 0; i <= 8000; i++)
			nodes[i] = new Node(i - 4000, 0);
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			array[i] = n;
			nodes[n + 4000].count++;
		}

		double sum = 0;
		for (int i = 0; i <= 8000; i++)
			sum += nodes[i].number * nodes[i].count;
		System.out.println(String.format("%.0f", sum / N));

		Arrays.sort(array);
		System.out.println(array[N / 2]);

		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.count == o2.count)
					return Integer.compare(o2.number, o1.number);
				return Integer.compare(o1.count, o2.count);
			}
		});
		System.out.println((nodes[8000].count == nodes[7999].count) ? nodes[7999].number : nodes[8000].number);

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}
		System.out.println(max - min);
	}

	private static class Node {
		public int number;
		public int count;

		public Node(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}
