/*
 * Author: Minho Kim (ISKU)
 * Date: March 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14733
 */

import java.util.*;
import java.io.*;

public class Main {

	private static long[] tree, count;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		Rectangle[] rectangle = new Rectangle[N * 2];
		for (int i = 0; i < rectangle.length; i += 2) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 50000;
			int y1 = Integer.parseInt(st.nextToken()) + 50000;
			int x2 = Integer.parseInt(st.nextToken()) + 50000;
			int y2 = Integer.parseInt(st.nextToken()) + 50000;
			rectangle[i] = new Rectangle(x1, y1, y2, 1);
			rectangle[i + 1] = new Rectangle(x2, y1, y2, -1);
		}
		Arrays.sort(rectangle);

		H = 1 << (int) Math.ceil(Math.log(100001) / Math.log(2));
		tree = new long[H * 2];
		count = new long[H * 2];

		int dx = rectangle[0].x;
		long area = 0;
		for (Rectangle p : rectangle) {
			area += tree[1] * (p.x - dx);
			update(1, H, 1, p.y1 + 1, p.y2, p.status);
			dx = p.x;
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
			tree[i] = r - l + 1;
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