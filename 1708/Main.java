/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.01.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1708
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int numberOfPoints = Integer.parseInt(parser.nextToken());

		ArrayList<Point> points = new ArrayList<Point>();
		for (int index = 0; index < numberOfPoints; index++) {
			parser = new StringTokenizer(input.readLine());
			points.add(new Point(Long.parseLong(parser.nextToken()), Long.parseLong(parser.nextToken())));
		}

		System.out.print(getConvexHull(points).size());
	}

	private static ArrayList<Point> getConvexHull(ArrayList<Point> points) {
		ArrayList<Point> tempPoints = new ArrayList<Point>();
		ArrayList<Point> hull = new ArrayList<Point>();
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

		return hull;
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