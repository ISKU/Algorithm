/*
 * Author: Minho Kim (ISKU)
 * Date: February 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16956
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();

		char[][] map = new char[R][C];
		for (int y = 0; y < R; y++)
			map[y] = sc.next().toCharArray();

		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || ny >= R || nx < 0 || nx >= C)
						continue;
					if (map[y][x] == 'S' && map[ny][nx] == 'W') {
						System.out.println(0);
						System.exit(0);
					}
				}
			}
		}

		System.out.println(1);
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++)
				System.out.print((map[y][x] == '.') ? 'D' : map[y][x]);
			System.out.println();
		}
	}
}