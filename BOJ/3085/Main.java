/*
 * Author: Minho Kim (ISKU)
 * Date: January 15, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3085
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		String[][] board = new String[N][N];
		for (int y = 0; y < N; y++) {
			String[] line = sc.nextLine().split("");
			for (int x = 0; x < N; x++)
				board[y][x] = line[x];
		}

		int max = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x + 1 < N) {
					String[][] change = arraycopy(board);
					String temp = change[y][x + 1];
					change[y][x + 1] = change[y][x];
					change[y][x] = temp;

					max = Math.max(max, maxpool(change));
				}

				if (y + 1 < N) {
					String[][] change = arraycopy(board);
					String temp = change[y + 1][x];
					change[y + 1][x] = change[y][x];
					change[y][x] = temp;

					max = Math.max(max, maxpool(change));
				}
			}
		}

		System.out.println(max);
	}

	private static int maxpool(String[][] board) {
		int max = 0;

		for (int y = 0; y < board.length; y++) {
			PriorityQueue<String> queue = new PriorityQueue<String>(comp);
			String line = board[y][0];

			for (int x = 1; x < board.length; x++) {
				if (board[y][x - 1].equals(board[y][x]))
					line += board[y][x];
				else {
					queue.add(line);
					line = board[y][x];
				}
			}
			queue.add(line);

			max = Math.max(max, queue.poll().length());
		}

		for (int x = 0; x < board.length; x++) {
			PriorityQueue<String> queue = new PriorityQueue<String>(comp);
			String line = board[0][x];

			for (int y = 1; y < board.length; y++) {
				if (board[y - 1][x].equals(board[y][x]))
					line += board[y][x];
				else {
					queue.add(line);
					line = board[y][x];
				}
			}
			queue.add(line);

			max = Math.max(max, queue.poll().length());
		}

		return max;
	}

	private static Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
	};

	private static String[][] arraycopy(String[][] board) {
		String[][] array = new String[board.length][board.length];
		for (int y = 0; y < board.length; y++)
			for (int x = 0; x < board.length; x++)
				array[y][x] = board[y][x];
		return array;
	}
}