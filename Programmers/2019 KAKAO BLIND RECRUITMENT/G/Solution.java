/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42894
 */

class Solution {

	private int N;

	public int solution(int[][] board) {
		N = board.length;

		int answer = 0;
		while (true) {
			if (locateBlack(0, board))
				answer++;
			else
				break;
		}

		return answer;
	}

	private boolean locateBlack(int x, int[][] b) {
		for (int y = 0; y < N; y++) {
			if (b[y][x] <= 0)
				continue;

			boolean result = false;
			setBlack(y, x, true, b);
			result = (x == N - 1) ? findBlock(b) : locateBlack(x + 1, b);
			setBlack(y, x, false, b);
			return result;
		}

		return (x == N - 1) ? findBlock(b) : locateBlack(x + 1, b);
	}

	private void setBlack(int y, int x, boolean turn, int[][] b) {
		if (y - 1 >= 0)
			b[y - 1][x] = (turn) ? -1 : 0;
		if (y - 2 >= 0)
			b[y - 2][x] = (turn) ? -1 : 0;
	}

	private boolean findBlock(int[][] b) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (b[y][x] <= 0)
					continue;
				if (removeBlock(y, x, b[y][x], b))
					return true;
			}
		}

		return false;
	}

	private boolean removeBlock(int y, int x, int E, int[][] b) {
		if (y + 1 < N && x + 2 < N
			&& b[y + 1][x] == E && b[y + 1][x + 1] == E && b[y + 1][x + 2] == E
			&& b[y][x + 1] == -1 && b[y][x + 2] == -1)
		{
			b[y][x] = 0;
			b[y + 1][x] = 0;
			b[y + 1][x + 1] = 0;
			b[y + 1][x + 2] = 0;
			return true;
		}

		if (y + 2 < N && x - 1 >= 0
			&& b[y + 1][x] == E && b[y + 2][x] == E && b[y + 2][x - 1] == E
			&& b[y][x - 1] == -1 && b[y + 1][x - 1] == -1)
		{
			b[y][x] = 0;
			b[y + 1][x] = 0;
			b[y + 2][x] = 0;
			b[y + 2][x - 1] = 0;
			return true;
		}

		if (y + 2 < N && x + 1 < N
			&& b[y + 1][x] == E && b[y + 2][x] == E && b[y + 2][x + 1] == E
			&& b[y][x + 1] == -1 && b[y + 1][x + 1] == -1)
		{
			b[y][x] = 0;
			b[y + 1][x] = 0;
			b[y + 2][x] = 0;
			b[y + 2][x + 1] = 0;
			return true;
		}

		if (y + 1 < N && x - 2 >= 0
			&& b[y + 1][x] == E && b[y + 1][x - 1] == E && b[y + 1][x - 2] == E
			&& b[y][x - 1] == -1 && b[y][x - 2] == -1)
		{
			b[y][x] = 0;
			b[y + 1][x] = 0;
			b[y + 1][x - 1] = 0;
			b[y + 1][x - 2] = 0;
			return true;
		}

		if (y + 1 < N && x - 1 >= 0 && x + 1 < N
			&& b[y + 1][x - 1] == E && b[y + 1][x] == E && b[y + 1][x + 1] == E
			&& b[y][x - 1] == -1 && b[y][x + 1] == -1)
		{
			b[y][x] = 0;
			b[y + 1][x - 1] = 0;
			b[y + 1][x] = 0;
			b[y + 1][x + 1] = 0;
			return true;
		}

		return false;
	}
}