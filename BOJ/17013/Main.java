/*
 * Author: Minho Kim (ISKU)
 * Date: May 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17013
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] grid = new int[] { 1, 2, 3, 4 };
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'H') {
				int temp = grid[0];
				grid[0] = grid[2];
				grid[2] = temp;

				temp = grid[1];
				grid[1] = grid[3];
				grid[3] = temp;
			} else {
				int temp = grid[0];
				grid[0] = grid[1];
				grid[1] = temp;

				temp = grid[2];
				grid[2] = grid[3];
				grid[3] = temp;
			}
		}

		System.out.printf("%d %d\n%d %d\n", grid[0], grid[1], grid[2], grid[3]);
	}
}