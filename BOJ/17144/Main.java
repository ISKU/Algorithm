/*
 * Author: Minho Kim (ISKU)
 * Date: April 19, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17144
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };
	private static int topCleaner = -1;
	private static int bottomCleaner = -1;
	private static int[][] map, dust;
	private static int Y, X, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[Y][X];
		dust = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == -1) {
					if (topCleaner == -1)
						topCleaner = y;
					else
						bottomCleaner = y;

					map[y][x] = 0;
				}
			}
		}

		while (T-- > 0) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (map[y][x] <= 0)
						continue;

					propagation(y, x, counting(y, x));
				}
			}

			total();
			topClean();
			bottomClean();
		}

		int sum = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				sum += map[y][x];

		System.out.print(sum);
	}

	private static void propagation(int y, int x, int count) {
		for (int i = 0; i < 4; i++) {
			int py = y + dy[i];
			int px = x + dx[i];
			if (py < 0 || py >= Y || px < 0 || px >= X)
				continue;
			if ((py == topCleaner && px == 0) || (py == bottomCleaner && px == 0))
				continue;

			dust[py][px] += map[y][x] / 5;
		}

		map[y][x] = map[y][x] - ((map[y][x] / 5) * count);
	}

	private static int counting(int y, int x) {
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int py = y + dy[i];
			int px = x + dx[i];
			if (py < 0 || py >= Y || px < 0 || px >= X)
				continue;
			if ((py == topCleaner && px == 0) || (py == bottomCleaner && px == 0))
				continue;

			count++;
		}

		return count;
	}

	private static void total() {
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				map[y][x] += dust[y][x];
				dust[y][x] = 0;
			}
		}
	}

	private static void topClean() {
		for (int y = topCleaner - 1; y >= 0; y--)
			if (y - 1 >= 0)
				map[y][0] = map[y - 1][0];

		for (int x = 0; x < X; x++)
			if (x + 1 < X)
				map[0][x] = map[0][x + 1];

		for (int y = 0; y < topCleaner; y++)
			if (y + 1 <= topCleaner)
				map[y][X - 1] = map[y + 1][X - 1];

		for (int x = X - 1; x > 0; x--)
			if (x - 1 >= 0)
				map[topCleaner][x] = map[topCleaner][x - 1];
	}

	private static void bottomClean() {
		for (int y = bottomCleaner + 1; y < Y; y++)
			if (y + 1 < Y)
				map[y][0] = map[y + 1][0];

		for (int x = 0; x < X; x++)
			if (x + 1 < X)
				map[Y - 1][x] = map[Y - 1][x + 1];

		for (int y = Y - 1; y > bottomCleaner; y--)
			if (y - 1 >= bottomCleaner)
				map[y][X - 1] = map[y - 1][X - 1];

		for (int x = X - 1; x > 0; x--)
			if (x - 1 >= 0)
				map[bottomCleaner][x] = map[bottomCleaner][x - 1];
	}
}