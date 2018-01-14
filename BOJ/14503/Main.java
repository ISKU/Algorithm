/*
 * Author: Minho Kim (ISKU)
 * Date: January 14, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14503
 */

import java.util.*;

public class Main {

	private static int Y, X;
	private static int visited[][];
	private static int COUNT;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		visited = new int[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				visited[y][x] = sc.nextInt();

		run(R, C, D, 0);
		System.out.println(COUNT);
	}

	private static void run(int y, int x, int dir, int step) {
		if (visited[y][x] == 0) {
			visited[y][x] = 2;
			step++;
		}

		if (visited[y][x - 1] >= 1 && visited[y][x + 1] >= 1 && visited[y - 1][x] >= 1 && visited[y + 1][x] >= 1) {
			if (dir == 0) {
				if (visited[y + 1][x] == 1)
					COUNT = Math.max(COUNT, step);
				else
					run(y + 1, x, 0, step);
			} else if (dir == 1) {
				if (visited[y][x - 1] == 1)
					COUNT = Math.max(COUNT, step);
				else
					run(y, x - 1, 1, step);
			} else if (dir == 2) {
				if (visited[y - 1][x] == 1)
					COUNT = Math.max(COUNT, step);
				else
					run(y - 1, x, 2, step);
			} else if (dir == 3) {
				if (visited[y][x + 1] == 1)
					COUNT = Math.max(COUNT, step);
				else
					run(y, x + 1, 3, step);
			}

			return;
		}

		if (dir == 0) {
			if (visited[y][x - 1] == 0)
				run(y, x - 1, 3, step);
			else
				run(y, x, 3, step);
		} else if (dir == 1) {
			if (visited[y - 1][x] == 0)
				run(y - 1, x, 0, step);
			else
				run(y, x, 0, step);
		} else if (dir == 2) {
			if (visited[y][x + 1] == 0)
				run(y, x + 1, 1, step);
			else
				run(y, x, 1, step);
		} else if (dir == 3) {
			if (visited[y + 1][x] == 0)
				run(y + 1, x, 2, step);
			else
				run(y, x, 2, step);
		}
	}
}