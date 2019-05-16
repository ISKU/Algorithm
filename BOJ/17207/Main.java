/*
 * Author: Minho Kim (ISKU)
 * Date: May 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17207
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node[] node = new Node[5];
		node[0] = new Node("Inseo");
		node[1] = new Node("Junsuk");
		node[2] = new Node("Jungwoo");
		node[3] = new Node("Jinwoo");
		node[4] = new Node("Youngki");

		int[][] A = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] B = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 5; k++)
					node[i].total += A[i][k] * B[k][j];

		Arrays.sort(node);
		System.out.print(node[0].name);
	}

	private static class Node implements Comparable<Node> {
		public String name;
		public int total;

		public Node(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Node o) {
			if (this.total == o.total)
				return (o.name).compareTo(this.name);
			return Integer.compare(this.total, o.total);
		}
	}
}