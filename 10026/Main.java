/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10026
 */

import java.util.Scanner;

public class Main {

	private static int N;
	private static char[][] grid;
	private static boolean[][] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		grid = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++)
			grid[i] = input.next().toCharArray();

		int first = 0;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (!visited[y][x]) {
					dfs(y, x);
					first++;
				}

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (grid[y][x] == 'G')
					grid[y][x] = 'R';

		int second = 0;
		visited = new boolean[N][N];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (!visited[y][x]) {
					dfs(y, x);
					second++;
				}

		System.out.printf("%d %d", first, second);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		if (x - 1 >= 0 && !visited[y][x - 1] && grid[y][x - 1] == grid[y][x])
			dfs(y, x - 1);
		if (x + 1 < N && !visited[y][x + 1] && grid[y][x + 1] == grid[y][x])
			dfs(y, x + 1);
		if (y - 1 >= 0 && !visited[y - 1][x] && grid[y - 1][x] == grid[y][x])
			dfs(y - 1, x);
		if (y + 1 < N && !visited[y + 1][x] && grid[y + 1][x] == grid[y][x])
			dfs(y + 1, x);
	}
}