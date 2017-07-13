/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.01.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13310
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

	public static ArrayList<Point> points;

	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());

		int numberOfPoints = Integer.parseInt(parser.nextToken());
		long days = Long.parseLong(parser.nextToken());

		points = new ArrayList<Point>();
		for (int index = 0; index < numberOfPoints; index++) {
			parser = new StringTokenizer(input.readLine());
			points.add(new Point(
					Long.parseLong(parser.nextToken()), Long.parseLong(parser.nextToken()),
					Long.parseLong(parser.nextToken()), Long.parseLong(parser.nextToken())));
		}

		long left = 0, right = days;
		long midLeft, midRight;

		while (left <= right) {
			midLeft = (left * 2 + right) / 3;
			midRight = (left + right * 2 + 1) / 3;
			long distLeft = rotatingCalipers(midLeft);
			long distRight = rotatingCalipers(midRight);

			if (distLeft <= distRight)
				right = midRight - 1;
			else
				left = midLeft + 1;
		}

		System.out.println(left);
		System.out.println(rotatingCalipers(left));
	}

	private static long rotatingCalipers(long day) {
		ArrayList<Point> computePoints = new ArrayList<Point>();
		for (int index = 0; index < points.size(); index++) {
			Point point = points.get(index);
			computePoints.add(new Point(point.x + (day * point.dx), point.y + (day * point.dy)));
		}

		ArrayList<Point> hull = new ArrayList<Point>();
		scanConvexHull(computePoints, hull);

		long dist = 0;
		int cDay = 1;
		hull.add(hull.get(0));

		for (; cDay + 1 < hull.size(); cDay++) {
			long ccw = product(subtract(hull.get(0), hull.get(1)), subtract(hull.get(cDay), hull.get(cDay + 1)));
			if (ccw <= 0)
				break;
		}

		dist = dist(subtract(hull.get(cDay), hull.get(0)));
		for (int i = 1; i + 1 < hull.size(); i++) {
			for (; cDay + 1 < hull.size(); cDay++) {
				long ccw = product(subtract(hull.get(i), hull.get(i + 1)),
						subtract(hull.get(cDay), hull.get(cDay + 1)));
				dist = Math.max(dist, dist(subtract(hull.get(cDay), hull.get(i))));
				if (ccw <= 0)
					break;
			}

			dist = Math.max(dist, dist(subtract(hull.get(cDay), hull.get(i))));
		}

		return dist;
	}

	private static void scanConvexHull(ArrayList<Point> computePoints, ArrayList<Point> hull) {
		ArrayList<Point> tempPoints = new ArrayList<Point>();
		Point mn = computePoints.get(0);

		for (int i = 0; i < computePoints.size(); i++)
			if (comp(mn, computePoints.get(i)))
				mn = computePoints.get(i);
		for (int i = 0; i < computePoints.size(); i++)
			tempPoints.add(subtract(computePoints.get(i), mn));

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
		public long dx;
		public long dy;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public Point(long x, long y, long dx, long dy) {
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
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