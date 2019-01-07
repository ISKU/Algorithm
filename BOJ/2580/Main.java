/*
 * Author: Minho Kim (ISKU)
 * Date: January 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2580
 */

import java.util.*;

public class Main {

	private static final int[][] dy = new int[][] { { 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 3, 3, 3, 4, 4, 4, 5, 5, 5 }, { 3, 3, 3, 4, 4, 4, 5, 5, 5 },
			{ 3, 3, 3, 4, 4, 4, 5, 5, 5 }, { 6, 6, 6, 7, 7, 7, 8, 8, 8 }, { 6, 6, 6, 7, 7, 7, 8, 8, 8 },
			{ 6, 6, 6, 7, 7, 7, 8, 8, 8 } };
	private static final int[][] dx = new int[][] { { 0, 1, 2, 0, 1, 2, 0, 1, 2 }, { 3, 4, 5, 3, 4, 5, 3, 4, 5 },
			{ 6, 7, 8, 6, 7, 8, 6, 7, 8 }, { 0, 1, 2, 0, 1, 2, 0, 1, 2 }, { 3, 4, 5, 3, 4, 5, 3, 4, 5 },
			{ 6, 7, 8, 6, 7, 8, 6, 7, 8 }, { 0, 1, 2, 0, 1, 2, 0, 1, 2 }, { 3, 4, 5, 3, 4, 5, 3, 4, 5 },
			{ 6, 7, 8, 6, 7, 8, 6, 7, 8 } };

	private static Cell[][] map;
	private static List<Cell> candidate;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new Cell[9][9];
		candidate = new ArrayList<Cell>();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				map[y][x] = new Cell(y, x, sc.nextInt());
				if (map[y][x].value == 0)
					candidate.add(map[y][x]);
			}
		}
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				map[dy[i][j]][dx[i][j]].zone = i;

		dfs(0);
	}

	private static void dfs(int idx) {
		if (idx >= candidate.size()) {
			if (!check())
				return;

			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++)
					System.out.printf("%d ", map[y][x].value);
				System.out.println();
			}
			System.exit(0);
		}

		Cell c = candidate.get(idx);
		for (int n = 1; n <= 9; n++) {
			if (!vertical(c.y, c.x, n) || !horizontal(c.y, c.x, n) || !place(c.zone, n))
				continue;
			c.value = n;
			dfs(idx + 1);
			c.value = 0;
		}
	}

	private static boolean vertical(int y, int x, int value) {
		for (int i = x - 1; i >= 0; i--)
			if (map[y][i].value == value)
				return false;
		for (int i = x + 1; i < 9; i++)
			if (map[y][i].value == value)
				return false;
		return true;
	}

	private static boolean horizontal(int y, int x, int value) {
		for (int i = y - 1; i >= 0; i--)
			if (map[i][x].value == value)
				return false;
		for (int i = y + 1; i < 9; i++)
			if (map[i][x].value == value)
				return false;
		return true;
	}

	private static boolean place(int zone, int value) {
		for (int i = 0; i < 9; i++)
			if (map[dy[zone][i]][dx[zone][i]].value == value)
				return false;
		return true;
	}

	private static boolean check() {
		for (int i = 0; i < 9; i++) {
			boolean[] temp = new boolean[10];
			for (int j = 0; j < 9; j++)
				temp[map[dy[i][j]][dx[i][j]].value] = true;
			for (int j = 1; j <= 9; j++)
				if (!temp[j])
					return false;
		}
		for (int i = 0; i < 9; i++) {
			boolean[] temp = new boolean[10];
			for (int j = 0; j < 9; j++)
				temp[map[i][j].value] = true;
			for (int j = 1; j <= 9; j++)
				if (!temp[j])
					return false;
		}
		for (int j = 0; j < 9; j++) {
			boolean[] temp = new boolean[10];
			for (int i = 0; i < 9; i++)
				temp[map[j][i].value] = true;
			for (int i = 1; i <= 9; i++)
				if (!temp[i])
					return false;
		}

		return true;
	}

	private static class Cell {
		public int y, x, zone;
		public int value;

		public Cell(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}
}