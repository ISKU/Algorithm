/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.02.02
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/problems/2014/onlineset.pdf
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class E {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());

		while (testCase-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int numberOfPoints = Integer.parseInt(parser.nextToken());

			ArrayList<Point> points = new ArrayList<Point>();
			for (int index = 0; index < numberOfPoints; index++) {
				parser = new StringTokenizer(input.readLine());
				points.add(new Point(Long.parseLong(parser.nextToken()), Long.parseLong(parser.nextToken())));
			}

			output.append(rotatingCalipers(points));
		}

		System.out.print(output);
	}

	private static String rotatingCalipers(ArrayList<Point> points) {
		ArrayList<Point> hull = new ArrayList<Point>();
		getConvexHull(points, hull);

		long dist = 0;
		int cur = 1;
		hull.add(hull.get(0));

		for (; cur + 1 < hull.size(); cur++) {
			long ccw = product(subtract(hull.get(0), hull.get(1)),
					subtract(hull.get(cur), hull.get(cur + 1)));
			if (ccw <= 0)
				break;
		}

		Point A = hull.get(0);
		Point B = hull.get(cur);
		dist = dist(subtract(hull.get(cur), hull.get(0)));

		for (int i = 1; i + 1 < hull.size(); i++) {
			for (; cur + 1 < hull.size(); cur++) {
				long ccw = product(subtract(hull.get(i), hull.get(i + 1)), subtract(hull.get(cur), hull.get(cur + 1)));

				if (dist(subtract(hull.get(cur), hull.get(i))) > dist) {
					dist = dist(subtract(hull.get(cur), hull.get(i)));
					A = hull.get(i);
					B = hull.get(cur);
				}

				if (ccw <= 0)
					break;
			}

			if (dist(subtract(hull.get(cur), hull.get(i))) > dist) {
				dist = dist(subtract(hull.get(cur), hull.get(i)));
				A = hull.get(i);
				B = hull.get(cur);
			}
		}

		return String.format("%d %d %d %d\n", A.x, A.y, B.x, B.y);
	}

	private static void getConvexHull(ArrayList<Point> points, ArrayList<Point> hull) {
		ArrayList<Point> tempPoints = new ArrayList<Point>();
		Point mn = points.get(0);

		for (int i = 0; i < points.size(); i++)
			if (comp(mn, points.get(i)))
				mn = points.get(i);
		for (int i = 0; i < points.size(); i++)
			tempPoints.add(subtract(points.get(i), mn));

		Collections.sort(tempPoints);

		for (int i = 0; i < tempPoints.size(); i++) {
			Point third = tempPoints.get(i);

			while (hull.size() >= 2) {
				Point first = hull.get(hull.size() - 1);
				Point second = hull.get(hull.size() - 2);

				if (product(subtract(second, first), subtract(third, first)) >= 0)
					hull.remove(hull.size() - 1);
				else
					break;
			}

			if (hull.size() == 0 || !equal(hull.get(hull.size() - 1), third))
				hull.add(third);
		}

		for (int i = 0; i < hull.size(); i++)
			hull.set(i, add(hull.get(i), mn));
	}

	private static Point add(Point A, Point B) {
		return new Point(A.x + B.x, A.y + B.y);
	}

	private static Point subtract(Point A, Point B) {
		return new Point(A.x - B.x, A.y - B.y);
	}

	private static long product(Point A, Point B) {
		return (A.x * B.y) - (B.x * A.y);
	}

	private static long dist(Point A) {
		return (A.x * A.x) + (A.y * A.y);
	}

	private static boolean comp(Point A, Point B) {
		if (A.x > B.x)
			return true;
		else if (A.x < B.x)
			return false;
		else {
			if (A.y > B.y)
				return true;
			else
				return false;
		}
	}

	private static boolean equal(Point A, Point B) {
		if (A.x == B.x && A.y == B.y)
			return true;
		else
			return false;
	}

	private static class Point implements Comparable<Point> {
		public long x;
		public long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point A) {
			if (A.x == 0 && A.y == 0)
				return 1;
			if (this.x == 0 && this.y == 0)
				return -1;
			if (product(this, A) != 0) {
				if (product(this, A) > 0)
					return -1;
				else if (product(this, A) < 0)
					return 1;
				else
					return 0;
			} else {
				if (dist(this) < dist(A))
					return -1;
				else if (dist(this) > dist(A))
					return 1;
				else
					return 0;
			}
		}
	}
}