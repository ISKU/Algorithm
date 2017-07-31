/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.31
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13326
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		Point[] points = new Point[input.nextInt()];
		for (int i = 0; i < points.length; i++)
			points[i] = new Point(input.nextInt(), input.nextInt());

		Point t1 = null;
		int maxDist = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i; j < points.length; j++) {
				int dist = distance(points[i], points[j]);
				if (dist > maxDist) {
					t1 = points[i];
					maxDist = dist;
				}
			}
		}

		final Point T1 = t1;
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point A, Point B) {
				return distance(T1, A) - distance(T1, B);
			}
		});

		int[] maxB = new int[points.length + 1];
		for (int i = points.length - 2; i > 0; i--) {
			maxB[i] = maxB[i + 1];
			for (int j = i; j < points.length; j++)
				maxB[i] = Math.max(maxB[i], distance(points[i], points[j]));
		}

		double answer = Double.MAX_VALUE;
		int maxA = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < i; j++)
				maxA = Math.max(maxA, distance(points[i], points[j]));
			answer = Math.min(answer, Math.sqrt(maxA) + Math.sqrt(maxB[i + 1]));
		}

		System.out.printf("%.4f", answer);
	}

	private static int distance(Point A, Point B) {
		return ((A.x - B.x) * (A.x - B.x)) + ((A.y - B.y) * (A.y - B.y));
	}

	private static class Point {
		public int y;
		public int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}