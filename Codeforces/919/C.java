/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/919/C
 */

import java.util.*;
import java.io.*;

public class C {

	private static int Y, X, K;
	private static boolean[][] map;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[Y][X];
		for (int y = 0; y < Y; y++) {
			String line = br.readLine();
			for (int x = 0; x < X; x++)
				map[y][x] = (line.charAt(x) == '.') ? true : false;
		}

		int answer = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x]) {
					int count = row(y, x, 0);
					if (count >= K)
						answer += count + 1 - K;
					x += count - 1;
				}
			}
		}

		if (K > 1) {
			for (int x = 0; x < X; x++) {
				for (int y = 0; y < Y; y++) {
					if (map[y][x]) {
						int count = column(y, x, 0);
						if (count >= K)
							answer += count + 1 - K;
						y += count - 1;
					}
				}
			}
		}

		System.out.print(answer);
	}

	private static int row(int y, int x, int count) {
		if (x >= X || !map[y][x])
			return count;
		return row(y, x + 1, count + 1);
	}

	private static int column(int y, int x, int count) {
		if (y >= Y || !map[y][x])
			return count;
		return column(y + 1, x, count + 1);
	}
}