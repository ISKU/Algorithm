/*
 * Author: Minho Kim (ISKU)
 * Date: March 28, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17090
 */

import java.util.*;
import java.io.*;

public class Main {

	private static char[][] map;
	private static int[][] check;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new char[Y][];
		for (int y = 0; y < Y; y++)
			map[y] = br.readLine().toCharArray();

		check = new int[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (check[y][x] == 0)
					dfs(y, x);

		int count = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (check[y][x] == 1)
					count++;

		System.out.println(count);
	}

	private static int dfs(int y, int x) {
		check[y][x] = 3;

		if (map[y][x] == 'U') {
			if (y == 0 || check[y - 1][x] == 1)
				return check[y][x] = 1;
			if (check[y - 1][x] == 3 || check[y - 1][x] == 2)
				return check[y][x] = 2;
			return check[y][x] = dfs(y - 1, x);
		}
		else if (map[y][x] == 'D') {
			if (y == Y - 1 || check[y + 1][x] == 1)
				return check[y][x] = 1;
			if (check[y + 1][x] == 3 || check[y + 1][x] == 2)
				return check[y][x] = 2;
			return check[y][x] = dfs(y + 1, x);
		}
		else if (map[y][x] == 'L') {
			if (x == 0 || check[y][x - 1] == 1)
				return check[y][x] = 1;
			if (check[y][x - 1] == 3 || check[y][x - 1] == 2)
				return check[y][x] = 2;
			return check[y][x] = dfs(y, x - 1);
		}
		else {
			if (x == X - 1 || check[y][x + 1] == 1)
				return check[y][x] = 1;
			if (check[y][x + 1] == 3 || check[y][x + 1] == 2)
				return check[y][x] = 2;
			return check[y][x] = dfs(y, x + 1);
		}
	}
}