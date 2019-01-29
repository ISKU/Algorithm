/*
 * Author: Minho Kim (ISKU)
 * Date: January 29, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13538
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int D = 19;
	public static final int MAX = (1 << D) - 1;
	private static Node[] pst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());

		int index = 0;
		pst = new Node[MAX];
		pst[0] = new Node(0, null, null);
		pst[0].left = pst[0];
		pst[0].right = pst[0];

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int X = Integer.parseInt(st.nextToken());
				index++;
				pst[index] = build(0, MAX, X, pst[index - 1]);
			}
			if (cmd == 2) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				int xor = xor(0, MAX, D - 1, pst[L - 1], pst[R], X);
				bw.write(String.valueOf(xor));
				bw.write('\n');
			}
			if (cmd == 3) {
				int K = Integer.parseInt(st.nextToken());
				index -= K;
			}
			if (cmd == 4) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				int count = count(0, MAX, 0, X, pst[R]) - count(0, MAX, 0, X, pst[L - 1]);
				bw.write(String.valueOf(count));
				bw.write('\n');
			}
			if (cmd == 5) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				int kth = kth(0, MAX, pst[L - 1], pst[R], K);
				bw.write(String.valueOf(kth));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static int xor(int l, int r, int d, Node L, Node R, int X) {
		if (l == r)
			return l;

		int mid = (l + r) / 2;

		if ((X & (1 << d)) != 0) {
			if (R.left.value - L.left.value > 0)
				return xor(l, mid, d - 1, L.left, R.left, X);
			else
				return xor(mid + 1, r, d - 1, L.right, R.right, X);
		} else {
			if (R.right.value - L.right.value > 0)
				return xor(mid + 1, r, d - 1, L.right, R.right, X);
			else
				return xor(l, mid, d - 1, L.left, R.left, X);
		}
	}

	private static int kth(int l, int r, Node L, Node R, int K) {
		if (l == r)
			return l;

		int mid = (l + r) / 2;
		int count = R.left.value - L.left.value;

		if (count >= K)
			return kth(l, mid, L.left, R.left, K);
		else
			return kth(mid + 1, r, L.right, R.right, K - count);
	}

	private static int count(int l, int r, int L, int R, Node p) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return p.value;

		int mid = (l + r) / 2;
		return count(l, mid, L, R, p.left) + count(mid + 1, r, L, R, p.right);
	}

	private static Node build(int l, int r, int i, Node p) {
		if (i < l || r < i)
			return p;
		if (l == r)
			return new Node(p.value + 1, null, null);

		int mid = (l + r) / 2;
		return new Node(p.value + 1, build(l, mid, i, p.left), build(mid + 1, r, i, p.right));
	}

	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}