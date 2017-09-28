/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14732
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		boolean[][] grid = new boolean[501][501];
		int N = input.nextInt();

		while (N-- > 0) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();

			for (int j = y1; j < y2; j++)
				for (int i = x1; i < x2; i++)
					grid[j][i] = true;
		}

		int answer = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j])
					answer++;

		System.out.print(answer);
	}
}