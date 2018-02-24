/*
 * Author: Minho Kim (ISKU)
 * Date: February 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3392
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int MAX = 30001;
	private static int[] tree;
	private static int[] count;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) * 2;

		H = 1 << (int) Math.ceil(Math.log(MAX) / Math.log(2));
		tree = new int[H * 2];
		count = new int[H * 2];

		Map[] map = new Map[N];
		for (int i = 0; i < N; i += 2) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			map[i] = new Map(x1, y1, y2, 1);
			map[i + 1] = new Map(x2, y1, y2, -1);
		}
		Arrays.sort(map);

		int dx = map[0].x;
		int area = 0;
		for (int i = 0; i < N; i++) {
			area += tree[1] * (map[i].x - dx);
			update(1, H, 1, map[i].y1 + 1, map[i].y2, map[i].status);
			dx = map[i].x;
		}

		System.out.print(area);
	}

	private static void merge(int l, int r, int i) {
		if (count[i] > 0)
			tree[i] = r - l + 1;
		else if (l != r)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		else
			tree[i] = 0;
	}

	private static void update(int l, int r, int i, int L, int R, int value) {
		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			count[i] += value;
			merge(l, r, i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R, value);
		update(mid + 1, r, i * 2 + 1, L, R, value);
		merge(l, r, i);
	}

	private static class Map implements Comparable<Map> {
		public int x, y1, y2;
		public int status;

		public Map(int x, int y1, int y2, int status) {
			this.x = x;
			this.y1 = y1;
			this.y2 = y2;
			this.status = status;
		}

		@Override
		public int compareTo(Map o) {
			return this.x - o.x;
		}
	}
}