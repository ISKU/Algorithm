/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11559
 */

import java.util.*;

public class Main {

	private static LinkedList<LinkedList<Point>> field;
	private static LinkedList<Point> candidate;
	private static LinkedList<Point> temp;
	private static boolean[][] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		field = new LinkedList<LinkedList<Point>>();

		for (int i = 0; i < 6; i++)
			field.add(new LinkedList<Point>());

		for (int y = 0; y < 12; y++) {
			char[] row = input.next().toCharArray();
			for (int x = 0; x < 6; x++)
				field.get(x).add(new Point(y, x, row[x]));
		}

		boolean check = true;
		int answer = 0;

		while (check) {
			check = false;
			candidate = new LinkedList<Point>();
			visited = new boolean[12][6];

			for (int y = 0; y < 12; y++) {
				for (int x = 0; x < 6; x++)
					if (!visited[y][x] && field.get(x).get(y).space != '.') {
						temp = new LinkedList<Point>();
						dfs(y, x, field.get(x).get(y).space);

						if (temp.size() >= 4) {
							check = true;
							candidate.addAll(temp);
						}
					}
			}

			if (check) {
				for (Point point : candidate) {
					field.get(point.x).remove(point);
					field.get(point.x).addFirst(new Point(point.y, point.x, '.'));
				}
				answer++;
			}
		}

		System.out.print(answer);
	}

	private static void dfs(int y, int x, char color) {
		visited[y][x] = true;
		temp.add(field.get(x).get(y));

		if (y - 1 >= 0 && !visited[y - 1][x] && field.get(x).get(y - 1).space == color)
			dfs(y - 1, x, color);
		if (x - 1 >= 0 && !visited[y][x - 1] && field.get(x - 1).get(y).space == color)
			dfs(y, x - 1, color);
		if (y + 1 < 12 && !visited[y + 1][x] && field.get(x).get(y + 1).space == color)
			dfs(y + 1, x, color);
		if (x + 1 < 6 && !visited[y][x + 1] && field.get(x + 1).get(y).space == color)
			dfs(y, x + 1, color);
	}

	private static class Point {
		public int y;
		public int x;
		public char space;

		public Point(int y, int x, char space) {
			this.y = y;
			this.x = x;
			this.space = space;
		}
	}
}