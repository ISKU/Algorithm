/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2615
 */

import java.util.*;

public class Main {

	private static int[][] map;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		map = new int[19][19];
		for (int y = 0; y < 19; y++)
			for (int x = 0; x < 19; x++)
				map[y][x] = sc.nextInt();

		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				if (map[y][x] == 0)
					continue;

				int player = map[y][x];
				int count = 0;
				count = Math.max(count, left(y, x, player, 0) + right(y, x, player, 0) - 1);
				count = Math.max(count, top(y, x, player, 0) + bottom(y, x, player, 0) - 1);
				count = Math.max(count, tl(y, x, player, 0) + br(y, x, player, 0) - 1);
				if (count == 5)
					exit(y + 1, x + 1, player);

				count = tr(y, x, player, 0) + bl(y, x, player, 0) - 1;
				if (count == 5)
					exit(y + 5, x - 3, player);
			}
		}

		System.out.print(0);
	}

	private static int left(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return left(y, x - 1, player, c + 1);
	}

	private static int right(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return right(y, x + 1, player, c + 1);
	}

	private static int top(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return top(y - 1, x, player, c + 1);
	}

	private static int bottom(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return bottom(y + 1, x, player, c + 1);
	}

	private static int tl(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return tl(y - 1, x - 1, player, c + 1);
	}

	private static int tr(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return tr(y - 1, x + 1, player, c + 1);
	}

	private static int bl(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return bl(y + 1, x - 1, player, c + 1);
	}

	private static int br(int y, int x, int player, int c) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19 || map[y][x] != player)
			return c;
		return br(y + 1, x + 1, player, c + 1);
	}

	private static void exit(int y, int x, int player) {
		System.out.println(player);
		System.out.printf("%d %d", y, x);
		System.exit(0);
	}
}