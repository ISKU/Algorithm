/*
 * Author: Minho Kim (ISKU)
 * Date: February 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13547
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 1000000;
	private static int[] array;
	private static Node[] quries;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		array = new int[N + 1];
		for (int i = 1; i <= N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		int SQRT = (int) Math.sqrt(N);
		quries = new Node[M + 1];
		quries[0] = new Node(0, 0, 0);
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			quries[i] = new Node(i, l, r);
		}
		Arrays.sort(quries, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int first = o1.l / SQRT;
				int second = o2.l / SQRT;

				if (first == second)
					return Integer.compare(o1.r, o2.r);
				return Integer.compare(first, second);
			}
		});

		int[] answer = new int[M + 1];
		int[] count = new int[MAX + 1];
		int d = 0;
		for (int i = 1; i <= M; i++) {
			int l1 = quries[i - 1].l;
			int r1 = quries[i - 1].r;
			int l2 = quries[i].l;
			int r2 = quries[i].r;

			for (int j = l1 - 1; j >= l2; j--)
				if (count[array[j]]++ == 0)
					d++;
			for (int j = r1 + 1; j <= r2; j++)
				if (count[array[j]]++ == 0)
					d++;
			for (int j = l1; j < l2; j++)
				if (--count[array[j]] == 0)
					d--;
			for (int j = r1; j > r2; j--)
				if (--count[array[j]] == 0)
					d--;

			answer[quries[i].index] = d;
		}

		for (int i = 1; i <= M; i++) {
			bw.write(String.valueOf(answer[i]));
			bw.write('\n');
		}
		bw.close();
	}

	private static class Node {
		public int index;
		public int l, r;

		public Node(int index, int l, int r) {
			this.index = index;
			this.l = l;
			this.r = r;
		}
	}
}