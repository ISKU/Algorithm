/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11651
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Point[] points = new Point[input.nextInt()];

		for (int i = 0; i < points.length; i++)
			points[i] = new Point(input.nextInt(), input.nextInt());

		Arrays.sort(points);
		for (int i = 0; i < points.length; i++)
			System.out.println(points[i].x + " " + points[i].y);
	}

	private static class Point implements Comparable<Point> {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y < o.y)
				return -1;
			else if (this.y > o.y)
				return 1;
			else {
				if (this.x < o.x)
					return -1;
				else if (this.x > o.x)
					return 1;
				else
					return 0;
			}
		}
	}
}