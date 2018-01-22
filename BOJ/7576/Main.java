/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7576
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();

		Queue<Tomato> queue = new LinkedList<Tomato>();
		int[][] map = new int[Y][X];
		int count = 0, empty = 0;

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				map[y][x] = sc.nextInt();
				if (map[y][x] == 1) {
					queue.add(new Tomato(y, x, 0));
					count++;
				}
				if (map[y][x] == -1)
					empty++;
			}
		}

		if (count == Y * X - empty) {
			System.out.print(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			int y = tomato.y;
			int x = tomato.x;
			int step = tomato.step;

			if (x - 1 >= 0 && map[y][x - 1] == 0) {
				map[y][x - 1] = 1;
				queue.add(new Tomato(y, x - 1, step + 1));
				count++;
			}
			if (x + 1 < X && map[y][x + 1] == 0) {
				map[y][x + 1] = 1;
				queue.add(new Tomato(y, x + 1, step + 1));
				count++;
			}
			if (y - 1 >= 0 && map[y - 1][x] == 0) {
				map[y - 1][x] = 1;
				queue.add(new Tomato(y - 1, x, step + 1));
				count++;
			}
			if (y + 1 < Y && map[y + 1][x] == 0) {
				map[y + 1][x] = 1;
				queue.add(new Tomato(y + 1, x, step + 1));
				count++;
			}

			if (count == Y * X - empty) {
				System.out.print(step + 1);
				System.exit(0);
			}
		}

		System.out.print(-1);
	}

	private static class Tomato {
		public int y;
		public int x;
		public int step;

		public Tomato(int y, int x, int step) {
			this.y = y;
			this.x = x;
			this.step = step;
		}
	}
}