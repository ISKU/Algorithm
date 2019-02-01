/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11012
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 100000;
	private static Node[] pst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] points = new int[N + 1][2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(points, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0])
						return Integer.compare(o1[1], o2[1]);
					return Integer.compare(o1[0], o2[0]);
				}
			});
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 1; i <= N; i++)
				map.put(points[i][0], i);

			pst = new Node[N + 1];
			pst[0] = new Node(0, null, null);
			pst[0].left = pst[0];
			pst[0].right = pst[0];
			for (int i = 1; i <= N; i++)
				pst[i] = build(0, MAX, points[i][1], pst[i - 1]);

			int sum = 0;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int y1 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int x1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());

				int first = lowerBound(y1, y2, points);
				int second = upperBound(y1, y2, points);
				if (first == -1 || second == -1)
					continue;

				if (second >= 1)
					sum += count(0, MAX, x1, x2, pst[map.get(points[second][0])]);
				if (first >= 2)
					sum -= count(0, MAX, x1, x2, pst[map.get(points[first - 1][0])]);
			}

			bw.write(String.valueOf(sum));
			bw.write('\n');
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

	private static Node build(int l, int r, int i, Node p) {
		if (i < l || r < i)
			return p;
		if (l == r)
			return new Node(p.value + 1, null, null);

		int mid = (l + r) / 2;
		return new Node(p.value + 1, build(l, mid, i, p.left), build(mid + 1, r, i, p.right));
	}

	private static int lowerBound(int L, int R, int[][] points) {
		int l = 1;
		int r = points.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (points[mid][0] < L)
				l = mid + 1;
			else
				r = mid;
		}

		if (points[l][0] < L)
			return -1;
		return l;
	}

	private static int upperBound(int L, int R, int[][] points) {
		int l = 1;
		int r = points.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (points[mid][0] <= R)
				l = mid + 1;
			else
				r = mid;
		}

		if (points[l][0] <= R)
			return l;
		if (l - 1 >= 0 && points[l - 1][0] <= R)
			return l - 1;
		return -1;
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