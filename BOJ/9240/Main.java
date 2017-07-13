/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9240
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	private static final int INFINITY = Integer.MAX_VALUE;
	private static final int INFINITESIMAL = Integer.MIN_VALUE;

	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		ArrayList<Point> points = new ArrayList<Point>();
		int numberOfPoints = Integer.parseInt(parser.nextToken());
		double maxDistance = 0;

		for (int index = 0; index < numberOfPoints; index++) {
			parser = new StringTokenizer(input.readLine());
			points.add(new Point(Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken())));
		}

		points = quickHull(points);
		for (int i = 0; i < points.size(); i++)
			for (int j = i; j >= 0; j--)
				maxDistance = Math.max(maxDistance, 
						Math.pow(points.get(i).x - points.get(j).x, 2)
						+ Math.pow(points.get(i).y - points.get(j).y, 2));

		System.out.print(Math.sqrt(maxDistance));
	}

	private static ArrayList<Point> quickHull(ArrayList<Point> points) {
		ArrayList<Point> convexHull = new ArrayList<Point>();
		int minX = INFINITY, maxX = INFINITESIMAL;
		int minIndex = -1, maxIndex = -1;

		if (points.size() < 3)
			return points;

		for (int index = 0, size = points.size(); index < size; index++) {
			int pointX = points.get(index).x;
			if (pointX < minX) {
				minX = pointX;
				minIndex = index;
			}
			if (pointX > maxX) {
				maxX = pointX;
				maxIndex = index;
			}
		}

		Point A = points.get(minIndex);
		Point B = points.get(maxIndex);
		convexHull.add(A);
		convexHull.add(B);
		points.remove(A);
		points.remove(B);

		ArrayList<Point> leftSet = new ArrayList<Point>();
		ArrayList<Point> rightSet = new ArrayList<Point>();

		for (int index = 0, size = points.size(); index < size; index++) {
			Point point = points.get(index);
			if (pointLocation(A, B, point) == -1)
				leftSet.add(point);
			else if (pointLocation(A, B, point) == 1)
				rightSet.add(point);
		}

		hullSet(A, B, rightSet, convexHull);
		hullSet(B, A, leftSet, convexHull);

		return convexHull;
	}

	private static void hullSet(Point A, Point B, ArrayList<Point> set, ArrayList<Point> hull) {
		int insertIndex = hull.indexOf(B);
		int dist = INFINITESIMAL;
		int furthestPoint = -1;

		if (set.size() == 0)
			return;
		if (set.size() == 1) {
			Point point = set.get(0);
			set.remove(point);
			hull.add(insertIndex, point);
			return;
		}

		for (int index = 0, size = set.size(); index < size; index++) {
			Point point = set.get(index);
			int distance = distance(A, B, point);
			if (distance > dist) {
				dist = distance;
				furthestPoint = index;
			}
		}

		Point P = set.get(furthestPoint);
		set.remove(furthestPoint);
		hull.add(insertIndex, P);

		ArrayList<Point> leftSetAP = new ArrayList<Point>();
		for (int index = 0, size = set.size(); index < size; index++) {
			Point point = set.get(index);
			if (pointLocation(A, P, point) == 1)
				leftSetAP.add(point);
		}

		ArrayList<Point> leftSetPB = new ArrayList<Point>();
		for (int index = 0, size = set.size(); index < size; index++) {
			Point point = set.get(index);
			if (pointLocation(P, B, point) == 1)
				leftSetPB.add(point);
		}

		hullSet(A, P, leftSetAP, hull);
		hullSet(P, B, leftSetPB, hull);
	}

	private static int pointLocation(Point A, Point B, Point P) {
		int location = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
		if (location < 0)
			return -1;
		else if (location > 0)
			return 1;
		else
			return 0;
	}

	private static int distance(Point A, Point B, Point C) {
		int ABx = B.x - A.x;
		int ABy = B.y - A.y;
		int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
		if (num < 0)
			num = -num;
		return num;
	}

	private static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}