/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.06.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9663
 */

import java.util.Scanner;

public class Main {

	private static int answer = 0;

	public static void main(String... args) {
		solve(new int[new Scanner(System.in).nextInt()], 0);
		System.out.print(answer);
	}

	private static void solve(int[] board, int n) {
		if (n == board.length)
			answer++;
		else {
			for (int i = 0; i < board.length; i++) {
				board[n] = i;
				if (check(board, n))
					solve(board, n + 1);
			}
		}
	}

	private static boolean check(int[] board, int n) {
		for (int i = 0; i < n; i++) {
			if (board[i] == board[n])
				return false;
			if ((board[i] - board[n]) == (n - i))
				return false;
			if ((board[n] - board[i]) == (n - i))
				return false;
		}

		return true;
	}
}