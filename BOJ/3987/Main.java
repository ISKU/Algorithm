/*
 * Author: Minho Kim (ISKU)
 * Date: July 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3987
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final char[] direction = new char[] { 'U', 'R', 'D', 'L' };
	private static char[][] map;
	private static int Y, X, dirIdx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new char[Y][];
		for (int y = 0; y < Y; y++)
			map[y] = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int sx = Integer.parseInt(st.nextToken()) - 1;

		int dir = 0;
		int answer = 0;
		for (int i = 0; i < 4; i++, dirIdx++) {
			int count = dfs(sy, sx, i, 0);
			if (answer < count) {
				answer = count;
				dir = i;
			}
		}

		System.out.println(direction[dir]);
		System.out.println(answer);
	}

	private static int dfs(int y, int x, int dir, int count) {
		if (count > 250000) {
			System.out.println(direction[dirIdx]);
			System.out.println("Voyager");
			System.exit(0);
		}
		if (y < 0 || y >= Y || x < 0 || x >= X)
			return count;
		if (map[y][x] == 'C')
			return count;

		if (map[y][x] == '/') {
			if (dir == 0)
				return dfs(y, x + 1, 1, count + 1);
			else if (dir == 1)
				return dfs(y - 1, x, 0, count + 1);
			else if (dir == 2)
				return dfs(y, x - 1, 3, count + 1);
			else
				return dfs(y + 1, x, 2, count + 1);
		}
		else if (map[y][x] == '\\') {
			if (dir == 0)
				return dfs(y, x - 1, 3, count + 1);
			else if (dir == 1)
				return dfs(y + 1, x, 2, count + 1);
			else if (dir == 2)
				return dfs(y, x + 1, 1, count + 1);
			else
				return dfs(y - 1, x, 0, count + 1);
		}
		else {
			if (dir == 0)
				return dfs(y - 1, x, dir, count + 1);
			else if (dir == 1)
				return dfs(y, x + 1, dir, count + 1);
			else if (dir == 2)
				return dfs(y + 1, x, dir, count + 1);
			else
				return dfs(y, x - 1, dir, count + 1);
		}
	}
}