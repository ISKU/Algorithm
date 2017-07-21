/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.11.04
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2016/REGIONAL/problemset-2016.pdf
 */

import java.util.Scanner;

public class G {

	private static int[][] matrix;
	private static boolean[][] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String[] size = input.nextLine().split(" ");
		matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
		visited = new boolean[matrix.length][matrix[0].length];
		boolean ans = false;

		for (int i = 0; i < matrix.length; i++) {
			String[] level = input.nextLine().split("");
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = Integer.parseInt(level[j]);
		}

		for (int j = 0; j < matrix[0].length; j++)
			if (matrix[0][j] == 0 && !visited[0][j])
				dfs(0, j);

		for (int j = 0; j < matrix[0].length; j++)
			if (visited[matrix.length - 1][j])
				ans = true;

		System.out.println(ans ? "YES" : "NO");
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		if (x - 1 >= 0 && matrix[y][x - 1] == 0 && !visited[y][x - 1])
			dfs(y, x - 1);
		if (x + 1 < matrix[0].length && matrix[y][x + 1] == 0 && !visited[y][x + 1])
			dfs(y, x + 1);
		if (y - 1 >= 0 && matrix[y - 1][x] == 0 && !visited[y - 1][x])
			dfs(y - 1, x);
		if (y + 1 < matrix.length && matrix[y + 1][x] == 0 && !visited[y + 1][x])
			dfs(y + 1, x);
	}
}