/*
 * Author: Minho Kim (ISKU)
 * Date: February 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7626
 */

import java.util.*;
import java.io.*;

public class Main {

	private static long[] tree;
	private static long[] count;
	private static ArrayList<Integer> range;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) * 2;

		Rectangle[] rectangles = new Rectangle[N];
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < N; i += 2) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			rectangles[i] = new Rectangle(x1, y1, y2, 1);
			rectangles[i + 1] = new Rectangle(x2, y1, y2, -1);
			set.add(y1);
			set.add(y2);
		}
		Arrays.sort(rectangles);
		range = new ArrayList<Integer>(set);

		H = 1 << (int) Math.ceil(Math.log(range.size()) / Math.log(2));
		tree = new long[H * 2];
		count = new long[H * 2];

		int dx = rectangles[0].x;
		long area = 0;
		for (int i = 0; i < N; i++) {
			area += tree[1] * (rectangles[i].x - dx);
			int l = Collections.binarySearch(range, rectangles[i].y1) + 1;
			int r = Collections.binarySearch(range, rectangles[i].y2);
			update(1, H, 1, l, r, rectangles[i].status);
			dx = rectangles[i].x;
		}

		System.out.print(area);
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

	private static void merge(int l, int r, int i) {
		if (count[i] > 0)
			tree[i] = range.get(r) - range.get(l - 1);
		else if (l != r)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		else
			tree[i] = 0;
	}

	private static class Rectangle implements Comparable<Rectangle> {
		public int x, y1, y2;
		public int status;

		public Rectangle(int x, int y1, int y2, int status) {
			this.x = x;
			this.y1 = y1;
			this.y2 = y2;
			this.status = status;
		}

		@Override
		public int compareTo(Rectangle o) {
			return this.x - o.x;
		}
	}
}