/*
 * Author: Minho Kim (ISKU)
 * Date: September 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16113
 */

import java.io.*;

public class Main {

	private static boolean[][] m;
	private static int Y, X;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine()) / 5;
		Y = 5;

		String line = br.readLine();
		m = new boolean[Y][X];
		for (int y = 0, i = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				m[y][x] = (line.charAt(i++) == '#') ? true : false;

		for (int x = 0; x < X;) {
			if (!m[0][x]) {
				x++;
			}
			else if (zero(0, x)) {
				System.out.print(0);
				x += 4;
			}
			else if (two(0, x)) {
				System.out.print(2);
				x += 4;
			}
			else if (three(0, x)) {
				System.out.print(3);
				x += 4;
			}
			else if (four(0, x)) {
				System.out.print(4);
				x += 4;
			}
			else if (five(0, x)) {
				System.out.print(5);
				x += 4;
			}
			else if (six(0, x)) {
				System.out.print(6);
				x += 4;
			}
			else if (seven(0, x)) {
				System.out.print(7);
				x += 4;
			}
			else if (eight(0, x)) {
				System.out.print(8);
				x += 4;
			}
			else if (nine(0, x)) {
				System.out.print(9);
				x += 4;
			}
			else if (one(0, x)) {
				System.out.print(1);
				x += 2;
			}
		}
	}

	private static boolean zero(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2] 
			&& m[y + 2][x] && !m[y + 2][x + 1] && m[y + 2][x + 2]
			&& m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean one(int y, int x) {
		if (m[y][x] && m[y + 1][x] && m[y + 2][x] && m[y + 3][x] && m[y + 4][x])
			return true;
		return false;
	}

	private static boolean two(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2] 
			&& !m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2] 
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& m[y + 3][x] && !m[y + 3][x + 1] && !m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean three(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& !m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2] 
			&& !m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean four(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && !m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& !m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& !m[y + 4][x] && !m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean five(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && !m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& !m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean six(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && !m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean seven(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& !m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2]
			&& !m[y + 2][x] && !m[y + 2][x + 1] && m[y + 2][x + 2]
			&& !m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& !m[y + 4][x] && !m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean eight(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}

	private static boolean nine(int y, int x) {
		if (x + 2 > X)
			return false;
		if (m[y][x] && m[y][x + 1] && m[y][x + 2]
			&& m[y + 1][x] && !m[y + 1][x + 1] && m[y + 1][x + 2]
			&& m[y + 2][x] && m[y + 2][x + 1] && m[y + 2][x + 2]
			&& !m[y + 3][x] && !m[y + 3][x + 1] && m[y + 3][x + 2]
			&& m[y + 4][x] && m[y + 4][x + 1] && m[y + 4][x + 2])
			return true;
		return false;
	}
}