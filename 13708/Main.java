/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13708
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = input.nextInt(); i > 0; i--)
			points.add(new Point(input.nextInt(), input.nextInt()));

		System.out.printf("%.2f", smallestEnclosingCircle(points).radius * 2);
	}

	private static Circle smallestEnclosingCircle(ArrayList<Point> points) {
		ArrayList<Point> shuffled = new ArrayList<Point>(points);
		Collections.shuffle(shuffled, new Random());

		Circle circle = null;
		for (int i = 0; i < shuffled.size(); i++) {
			Point p = shuffled.get(i);

			if (circle == null || !circle.contains(p))
				circle = onePoint(shuffled.subList(0, i + 1), p);
		}

		return circle;
	}

	private static Circle onePoint(List<Point> points, Point p) {
		Circle circle = new Circle(p, 0);

		for (int i = 0; i < points.size(); i++) {
			Point q = points.get(i);

			if (!circle.contains(q)) {
				if (circle.radius == 0)
					circle = diameter(p, q);
				else
					circle = twoPoint(points.subList(0, i + 1), p, q);
			}
		}

		return circle;
	}

	private static Circle twoPoint(List<Point> points, Point p, Point q) {
		Circle circ = diameter(p, q);
		Circle left = null;
		Circle right = null;

		Point pq = q.subtract(p);
		for (Point r : points) {
			if (circ.contains(r))
				continue;

			double cross = pq.cross(r.subtract(p));
			Circle c = circumcircle(p, q, r);
			if (c == null)
				continue;
			else if (cross > 0 && (left == null || pq.cross(c.center.subtract(p)) > pq.cross(left.center.subtract(p))))
				left = c;
			else if (cross < 0
					&& (right == null || pq.cross(c.center.subtract(p)) < pq.cross(right.center.subtract(p))))
				right = c;
		}

		if (left == null && right == null)
			return circ;
		else if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return left.radius <= right.radius ? left : right;
	}

	private static Circle diameter(Point a, Point b) {
		Point c = new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
		return new Circle(c, Math.max(c.distance(a), c.distance(b)));
	}

	private static Circle circumcircle(Point a, Point b, Point c) {
		double d = (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) * 2;
		if (d == 0)
			return null;

		double x = (a.norm() * (b.y - c.y) + b.norm() * (c.y - a.y) + c.norm() * (a.y - b.y)) / d;
		double y = (a.norm() * (c.x - b.x) + b.norm() * (a.x - c.x) + c.norm() * (b.x - a.x)) / d;

		Point p = new Point(x, y);
		double r = Math.max(Math.max(p.distance(a), p.distance(b)), p.distance(c));
		return new Circle(p, r);
	}

	private static class Circle {
		public static final double MULTIPLICATIVE_EPSILON = 1 + 1e-14;
		public Point center;
		public double radius;

		public Circle(Point center, double radius) {
			this.center = center;
			this.radius = radius;
		}

		public boolean contains(Point p) {
			return center.distance(p) <= radius * MULTIPLICATIVE_EPSILON;
		}
	}

	private static class Point {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Point subtract(Point p) {
			return new Point(x - p.x, y - p.y);
		}

		public double distance(Point p) {
			return Math.hypot(x - p.x, y - p.y);
		}

		public double cross(Point p) {
			return x * p.y - y * p.x;
		}

		public double norm() {
			return x * x + y * y;
		}
	}
}