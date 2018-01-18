/*
 * Author: Minho Kim (ISKU)
 * Date: January 19, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14500
 */

import java.util.*;

public class Main {

	private static int Y, X;
	private static int[][] p;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();

		p = new int[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				p[y][x] = sc.nextInt();

		int max = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				max = Math.max(max, find(y, x));

		System.out.print(max);
	}

	private static int find(int y, int x) {
		int m = 0;

		if (y + 1 < Y && x + 1 < X)
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y + 1][x] + p[y + 1][x + 1]);

		if (x + 3 < X)
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y][x + 2] + p[y][x + 3]);
		if (y + 3 < Y)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 2][x] + p[y + 3][x]);

		if (y + 1 < Y && x - 1 >= 0 && x + 1 < X)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x - 1] + p[y + 1][x + 1]);
		if (y + 2 < Y && x + 1 < X)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x + 1] + p[y + 2][x]);
		if (y + 1 < Y && x + 2 < X)
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y][x + 2] + p[y + 1][x + 1]);
		if (y + 2 < Y && x - 1 >= 0)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 2][x] + p[y + 1][x - 1]);

		if (y + 2 < Y && x + 1 < X) {
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y + 1][x + 1] + p[y + 2][x + 1]);
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y + 1][x] + p[y + 2][x]);
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 2][x] + p[y + 2][x + 1]);
		}
		if (y + 2 < Y && x - 1 >= 0)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 2][x] + p[y + 2][x - 1]);
		if (y + 1 < Y && x + 2 < X) {
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x + 1] + p[y + 1][x + 2]);
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y][x + 1] + p[y][x + 2]);
		}
		if (y + 1 < Y && x - 2 >= 0) {
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x - 1] + p[y + 1][x - 2]);
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y][x - 1] + p[y][x - 2]);
		}

		if (y + 2 < Y && x + 1 < X)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x + 1] + p[y + 2][x + 1]);
		if (y + 2 < Y && x - 1 >= 0)
			m = Math.max(m, p[y][x] + p[y + 1][x] + p[y + 1][x - 1] + p[y + 2][x - 1]);
		if (y + 1 < Y && x + 2 < X)
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y + 1][x + 1] + p[y + 1][x + 2]);
		if (y - 1 >= 0 && x + 2 < X)
			m = Math.max(m, p[y][x] + p[y][x + 1] + p[y - 1][x + 1] + p[y - 1][x + 2]);

		return m;
	}
}