/*
 * Author: Minho Kim (ISKU)
 * Date: August 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13537
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Node[] pst;
	private static int[] array;
	private static Integer[] set;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hashSet = new HashSet<Integer>();
		array = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			hashSet.add(array[i]);
		}
		set = hashSet.toArray(new Integer[hashSet.size()]);
		Arrays.sort(set);

		pst = new Node[N + 1];
		pst[0] = new Node(0, null, null);
		pst[0].left = pst[0];
		pst[0].right = pst[0];
		for (int i = 1; i <= N; i++)
			pst[i] = update(1, set.length, Arrays.binarySearch(set, array[i]) + 1, pst[i - 1]);

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int rc = count(1, set.length, upperBound(K), set.length, pst[r]);
			int lc = count(1, set.length, upperBound(K), set.length, pst[l - 1]);
			bw.write((rc - lc) + "\n");
		}

		bw.close();
	}

	private static int count(int l, int r, int L, int R, Node p) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return p.value;

		int mid = (l + r) / 2;
		return count(l, mid, L, R, p.left) + count(mid + 1, r, L, R, p.right);
	}

	private static Node update(int l, int r, int i, Node p) {
		if (i < l || r < i)
			return p;
		if (l == r)
			return new Node(p.value + 1, null, null);

		int mid = (l + r) / 2;
		return new Node(p.value + 1, update(l, mid, i, p.left), update(mid + 1, r, i, p.right));
	}

	private static int upperBound(int K) {
		int l = 0;
		int r = set.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (set[mid] <= K)
				l = mid + 1;
			else
				r = mid;
		}

		return (set[l] <= K) ? l + 2 : l + 1;
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