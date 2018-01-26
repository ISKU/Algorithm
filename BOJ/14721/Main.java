/*
 * Author: Minho Kim (ISKU)
 * Date: January 27, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14721
 */

import java.util.*;

public class Main {

	private static int N;
	private static long x, xx, y, yy, xy;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		Pair[] pair = new Pair[N];
		for (int i = 0; i < N; i++)
			pair[i] = new Pair(sc.nextInt(), sc.nextInt());

		x = xx = y = yy = xy = 0;
		for (Pair p : pair) {
			x += p.x;
			xx += p.x * p.x;
			y += p.y;
			yy += p.y * p.y;
			xy += p.x * p.y;
		}

		int minA = 1, minB = 1;
		long minRss = rss(1, 1);
		for (int a = 1; a <= 100; a++)
			for (int b = 1; b <= 100; b++)
				if (minRss > rss(a, b)) {
					minRss = rss(a, b);
					minA = a;
					minB = b;
				}

		System.out.printf("%d %d", minA, minB);
	}

	private static long rss(int a, int b) {
		return a * a * xx + b * b * N + yy - 2 * a * xy - 2 * b * y + 2 * a * b * x;
	}

	private static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}