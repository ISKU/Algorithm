/*
 * Author: Minho Kim (ISKU)
 * Date: December 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1018
 */

import java.util.*;

public class Main {

	private static boolean[][] board, first, second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		first = new boolean[8][8];
		second = new boolean[8][8];
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				first[y][x] = ((y + x) % 2 == 0);
				second[y][x] = !first[y][x];
			}
		}

		board = new boolean[N][M];
		for (int y = 0; y < N; y++) {
			String line = sc.next();
			for (int x = 0; x < M; x++)
				board[y][x] = (line.charAt(x) == 'W');
		}

		int answer = Integer.MAX_VALUE;
		for (int y = 0; y <= N - 8; y++)
			for (int x = 0; x <= M - 8; x++)
				answer = Math.min(answer, find(y, x));

		System.out.print(answer);
	}

	private static int find(int dy, int dx) {
		int count = 0;
		int count2 = 0;

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (board[y + dy][x + dx] != first[y][x])
					count++;
				if (board[y + dy][x + dx] != second[y][x])
					count2++;
			}
		}

		return Math.min(count, count2);
	}
}