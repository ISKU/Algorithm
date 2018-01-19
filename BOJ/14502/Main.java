/*
 * Author: Minho Kim (ISKU)
 * Date: January 19, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14502
 */

import java.util.*;

public class Main {

	private static int[][] map;
	private static int Y, X;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();

		int[][] origin = new int[Y][X];
		ArrayList<Point> zero = new ArrayList<Point>();
		ArrayList<Point> virus = new ArrayList<Point>();
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				origin[y][x] = sc.nextInt();
				if (origin[y][x] == 0)
					zero.add(new Point(y, x));
				if (origin[y][x] == 2)
					virus.add(new Point(y, x));
			}
		}

		int max = 0;
		for (int i = 0; i < zero.size(); i++) {
			for (int j = i + 1; j < zero.size(); j++) {
				for (int k = j + 1; k < zero.size(); k++) {
					map = new int[Y][X];
					for (int y = 0; y < Y; y++)
						map[y] = Arrays.copyOf(origin[y], X);

					map[zero.get(i).y][zero.get(i).x] = 1;
					map[zero.get(j).y][zero.get(j).x] = 1;
					map[zero.get(k).y][zero.get(k).x] = 1;

					for (Point p : virus)
						dfs(p.y, p.x);

					int count = 0;
					for (int y = 0; y < Y; y++)
						for (int x = 0; x < X; x++)
							if (map[y][x] == 0)
								count++;

					max = Math.max(max, count);
				}
			}
		}

		System.out.print(max);
	}

	private static void dfs(int y, int x) {
		map[y][x] = 2;

		if (y - 1 >= 0 && map[y - 1][x] == 0)
			dfs(y - 1, x);
		if (y + 1 < Y && map[y + 1][x] == 0)
			dfs(y + 1, x);
		if (x - 1 >= 0 && map[y][x - 1] == 0)
			dfs(y, x - 1);
		if (x + 1 < X && map[y][x + 1] == 0)
			dfs(y, x + 1);
	}

	private static class Point {
		public int y;
		public int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}