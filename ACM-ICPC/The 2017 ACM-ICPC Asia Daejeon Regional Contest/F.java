/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.11.11
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2017/regional/problemset-2017.pdf
 */

import java.util.Scanner;

public class F {

	private static int X, Y;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		X = Y = 1;
		find(0, 0, M - 1, N, false);
		System.out.printf("%d %d", X, Y);
	}

	private static void find(int direction, int index, int t, int l, boolean flag) {
		if (t == 0) {
			if (flag) {
				X += l - 1;
				Y += l - 1;
			}
			return;
		}

		int hl = l / 2;
		int k = t / (hl * hl);
		int nextDirection = direction;
		int nextIndex = index;

		if (k == 0)
			nextDirection = (direction + 1) % 2;
		if (k == 3) {
			nextDirection = (direction + 1) % 2;
			nextIndex = (index + 2) % 4;
			flag = !flag;
		}

		int temp = ((direction == 1) ? (4 + index - k) : (index + k)) % 4;
		if (temp == 1)
			Y = Y + hl;
		if (temp == 2) {
			X = X + hl;
			Y = Y + hl;
		}
		if (temp == 3)
			X = X + hl;

		find(nextDirection, nextIndex, t - (hl * hl * k), hl, flag);
	}
}