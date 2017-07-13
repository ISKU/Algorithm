/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11758
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(
				ccw(new Point(input.nextInt(), input.nextInt()), 
					new Point(input.nextInt(), input.nextInt()),
					new Point(input.nextInt(), input.nextInt())));
	}

	private static int ccw(Point A, Point B, Point C) {
		int ccw = A.x * B.y + B.x * C.y + C.x * A.y;
		ccw = ccw - A.y * B.x - B.y * C.x - C.y * A.x;
		return (ccw == 0) ? 0 : (ccw > 0) ? 1 : -1;
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