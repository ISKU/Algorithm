/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11650
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Point[] points = new Point[input.nextInt()];

		for (int i = 0; i < points.length; i++)
			points[i] = new Point(input.nextInt(), input.nextInt());

		Arrays.sort(points, (a, b) -> {
			if (a.x < b.x)
				return -1;
			else if (a.x > b.x)
				return 1;
			else {
				if (a.y < b.y)
					return -1;
				else if (a.y > b.y)
					return 1;
				else
					return 0;
			}
		});

		for (int i = 0; i < points.length; i++)
			System.out.println(points[i].x + " " + points[i].y);
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