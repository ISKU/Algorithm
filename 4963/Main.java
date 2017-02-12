/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4963
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int w = input.nextInt();
			int h = input.nextInt();

			if (w == 0 && h == 0)
				break;

			boolean[][] matrix = new boolean[h][w];
			boolean[][] visited = new boolean[h][w];
			int numberOfLands = 0;

			for (int i = 0; i < matrix.length; i++)
				for (int j = 0; j < matrix[i].length; j++)
					matrix[i][j] = input.nextInt() == 1 ? true : false;

			for (int i = 0; i < matrix.length; i++)
				for (int j = 0; j < matrix[i].length; j++)
					if (matrix[i][j] && !visited[i][j]) {
						dfs(i, j, matrix, visited);
						numberOfLands++;
					}

			System.out.println(numberOfLands);
		}
	}

	private static void dfs(int i, int j, boolean[][] matrix, boolean[][] visited) {
		visited[i][j] = true;

		if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] && !visited[i - 1][j - 1])
			dfs(i - 1, j - 1, matrix, visited);
		if (i - 1 >= 0 && matrix[i - 1][j] && !visited[i - 1][j])
			dfs(i - 1, j, matrix, visited);
		if (i - 1 >= 0 && j + 1 < matrix[0].length && matrix[i - 1][j + 1] && !visited[i - 1][j + 1])
			dfs(i - 1, j + 1, matrix, visited);
		if (j + 1 < matrix[0].length && matrix[i][j + 1] && !visited[i][j + 1])
			dfs(i, j + 1, matrix, visited);
		if (i + 1 < matrix.length && j + 1 < matrix[0].length && matrix[i + 1][j + 1] && !visited[i + 1][j + 1])
			dfs(i + 1, j + 1, matrix, visited);
		if (i + 1 < matrix.length && matrix[i + 1][j] && !visited[i + 1][j])
			dfs(i + 1, j, matrix, visited);
		if (i + 1 < matrix.length && j - 1 >= 0 && matrix[i + 1][j - 1] && !visited[i + 1][j - 1])
			dfs(i + 1, j - 1, matrix, visited);
		if (j - 1 >= 0 && matrix[i][j - 1] && !visited[i][j - 1])
			dfs(i, j - 1, matrix, visited);
	}
}