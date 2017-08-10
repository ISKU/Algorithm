/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2015/ONLINE/preliminary-problemset.pdf
 */

import java.util.*;
import java.io.*;

public class G {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());

		while (testCase-- > 0) {
			Point[] points = new Point[Integer.parseInt(input.readLine())];
			Point[] number = new Point[points.length];
			int[] count = new int[1000001];

			for (int i = 0; i < points.length; i++) {
				parser = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(parser.nextToken());
				int y = Integer.parseInt(parser.nextToken());
				points[i] = new Point(x, y);
				count[x]++;
			}

			Arrays.sort(points);
			int prev = 0;
			for (int index = 0; index < points.length;) {
				int start = index, end = index + count[points[index].x] - 1;

				if (prev == points[index].y) {
					for (int i = start; i <= end; i++)
						number[index++] = points[i];
					prev = points[end].y;
				} else {
					for (int i = end; i >= start; i--)
						number[index++] = points[i];
					prev = points[start].y;
				}
			}

			parser = new StringTokenizer(input.readLine());
			int m = Integer.parseInt(parser.nextToken());
			while (m-- > 0) {
				int index = Integer.parseInt(parser.nextToken());
				System.out.printf("%d %d\n", number[index - 1].x, number[index - 1].y);
			}
		}
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
			if (this.x != o.x)
				return this.x - o.x;
			else
				return this.y - o.y;
		}
	}
}