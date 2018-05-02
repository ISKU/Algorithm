/*
 * Author: Minho Kim (ISKU)
 * Date: May 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15671
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	private static final int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	private static int[][] board;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		board = new int[7][7];
		board[3][4] = board[4][3] = -1;
		board[3][3] = board[4][4] = 1;

		int N = Integer.parseInt(br.readLine());
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int player = (n % 2 == 1) ? -1 : 1;

			board[y][x] = player;
			for (int i = 0; i < 8; i++)
				dfs(y + dy[i], x + dx[i], dy[i], dx[i], player);
		}

		int black = 0;
		int white = 0;
		for (int y = 1; y <= 6; y++) {
			for (int x = 1; x <= 6; x++) {
				if (board[y][x] == -1) {
					bw.write('B');
					black++;
				}
				if (board[y][x] == 1) {
					bw.write('W');
					white++;
				}
				if (board[y][x] == 0)
					bw.write('.');
			}
			bw.newLine();
		}

		bw.write((black > white) ? "Black" : "White");
		bw.close();
	}

	private static boolean dfs(int y, int x, int dy, int dx, int player) {
		if (y < 1 || y > 6 || x < 1 || x > 6 || board[y][x] == 0)
			return false;
		if (board[y][x] == player)
			return true;

		boolean result = dfs(y + dy, x + dx, dy, dx, player);
		if (result)
			board[y][x] = player;
		return result;
	}
}