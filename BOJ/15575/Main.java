/*
 * Author: Minho Kim (ISKU)
 * Date: March 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15575
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeMap<Long, TreeSet<Long>> map = new TreeMap<>();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			if (!map.containsKey(x))
				map.put(x, new TreeSet<Long>());
			map.get(x).add(y);
		}

		double high = 0;
		double low = 0;
		long dx = map.firstKey();
		long dhy = map.get(dx).last();
		long dly = map.get(dx).first();
		map.pollFirstEntry();
		for (long x : map.keySet()) {
			long hy = map.get(x).last();
			long ly = map.get(x).first();
			double dh = high;
			double dl = low;

			double h2h = euclidean(dx, dhy, x, hy);
			double h2l = euclidean(dx, dhy, x, ly);
			double l2h = euclidean(dx, dly, x, hy);
			double l2l = euclidean(dx, dly, x, ly);
			high = Math.max(dh + h2h, dl + l2h);
			low = Math.max(dh + h2l, dl + l2l);

			dhy = hy;
			dly = ly;
			dx = x;
		}

		System.out.printf("%.7f", Math.max(high, low));
	}

	private static double euclidean(long x1, long y1, long x2, long y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}