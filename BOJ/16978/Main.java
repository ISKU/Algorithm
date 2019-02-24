/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16978
 */

import java.io.*;
import java.util.*;

public class Main {

	private static Node[] pst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] array = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			array[i] = Long.parseLong(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		pst = new Node[N + M + 1];
		pst[0] = new Node(0, null, null);
		pst[0].left = pst[0];
		pst[0].right = pst[0];
		for (int i = 1; i <= N; i++)
			pst[i] = build(1, N, i, array[i], pst[i - 1]);

		int count = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				long v = Long.parseLong(st.nextToken());

				long diff = v - sum(1, N, i, i, pst[N + count]);
				pst[N + count + 1] = build(1, N, i, diff, pst[N + count]);
				count++;
			}
			if (cmd == 2) {
				int i = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());

				long sum = sum(1, N, L, R, pst[N + i]);
				bw.write(String.valueOf(sum));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static long sum(int l, int r, int L, int R, Node p) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return p.value;

		int mid = (l + r) / 2;
		return sum(l, mid, L, R, p.left) + sum(mid + 1, r, L, R, p.right);
	}

	private static Node build(int l, int r, int i, long value, Node p) {
		if (r < i || i < l)
			return p;
		if (l == r)
			return new Node(p.value + value, null, null);

		int mid = (l + r) / 2;
		Node left = build(l, mid, i, value, p.left);
		Node right = build(mid + 1, r, i, value, p.right);
		return new Node(p.value + value, left, right);
	}

	private static class Node {
		public long value;
		public Node left, right;

		public Node(long value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}