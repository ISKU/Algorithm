/*
 * Author: Minho Kim (ISKU)
 * Date: April 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15685
 */

import java.util.*;
import java.io.*;

public class Main {

	private static boolean[][] map;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean[201][201];

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) * 2;
			int y = Integer.parseInt(st.nextToken()) * 2;
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			map[y][x] = true;
			x += (d == 0) ? 2 : (d == 2) ? -2 : 0;
			y += (d == 1) ? -2 : (d == 3) ? 2 : 0;
			map[y][x] = true;

			dfs(new Curve(y, x, d), g, new ArrayList<Boolean>());
		}

		int count = 0;
		for (int i = 1; i < 201; i += 2)
			for (int j = 1; j < 201; j += 2)
				if (map[i - 1][j - 1] && map[i - 1][j + 1] && map[i + 1][j - 1] && map[i + 1][j + 1])
					count++;

		System.out.print(count);
	}

	private static void dfs(Curve c, int g, ArrayList<Boolean> path) {
		if (g == 0)
			return;

		next(c, true);
		path.add(true);

		for (int i = path.size() - 2; i >= 0; i--) {
			next(c, !path.get(i));
			path.add(!path.get(i));
		}

		dfs(c, g - 1, path);
	}

	private static void next(Curve c, boolean dir) {
		if (c.d == 0) {
			c.y += dir ? -2 : 2;
			c.d = dir ? 1 : 3;
		} else if (c.d == 1) {
			c.x += dir ? -2 : 2;
			c.d = dir ? 2 : 0;
		} else if (c.d == 2) {
			c.y += dir ? 2 : -2;
			c.d = dir ? 3 : 1;
		} else if (c.d == 3) {
			c.x += dir ? 2 : -2;
			c.d = dir ? 0 : 2;
		}

		map[c.y][c.x] = true;
	}

	private static class Curve {
		public int y, x, d;

		public Curve(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}