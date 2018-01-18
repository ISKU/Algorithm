/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12094
 */

import java.util.*;

public class Main {

	private static int N;
	private static int MAX;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[][] board = new int[N][N];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				board[y][x] = sc.nextInt();

		find(board, 0);
		System.out.println(MAX);
	}

	private static void find(int[][] array, int step) {
		int max = 0;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				max = Math.max(max, array[y][x]);

		if (step == 10) {
			MAX = Math.max(MAX, max);
			return;
		}
		if (MAX > (int) Math.pow(max, 10 - step))
			return;

		int[][] board = new int[N][N];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				board[y][x] = array[y][x];

		for (int dir = 0; dir < 4; dir++) {
			int[][] copy = new int[N][N];

			for (int y = 0; y < N; y++) {
				List<Integer> temp = new ArrayList<Integer>();
				LinkedList<Integer> cand = new LinkedList<Integer>();

				for (int x = 0; x < N; x++)
					if (((dir <= 1) ? board[y][x] : board[x][y]) != 0)
						temp.add((dir <= 1) ? board[y][x] : board[x][y]);
				if (dir == 1 || dir == 3)
					Collections.reverse(temp);

				for (int i = 0; i < temp.size(); i++)
					cand.add((i + 1 < temp.size() && temp.get(i).equals(temp.get(i + 1))) ? temp.get(i++) * 2 : temp.get(i));

				while (cand.size() < N)
					cand.add(0);
				for (int x = 0; x < N; x++)
					if (dir <= 1)
						copy[y][x] = (dir == 0) ? cand.poll() : cand.pollLast();
					else
						copy[x][y] = (dir == 2) ? cand.poll() : cand.pollLast();
			}

			boolean equal = true;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					if (board[y][x] != copy[y][x])
						equal = false;

			if (equal && N != 1)
				continue;
			find(copy, step + 1);
		}
	}
}