/*
 * Author: Minho Kim (ISKU)
 * Date: November 30, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16639
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] line = sc.next().toCharArray();
		int size = N / 2 + 1;

		long[][] max = new long[size][size];
		long[][] min = new long[size][size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(max[i], Long.MIN_VALUE);
			Arrays.fill(min[i], Long.MAX_VALUE);
			max[i][i] = line[i * 2] - '0';
			min[i][i] = line[i * 2] - '0';
		}

		for (int count = 1; count < size; count++) {
			for (int k = 0; k < size - count; k++) {
				int i = k;
				int j = k + count;

				for (int r = 1, c = count; r <= count; r++, c--) {
					char oper = line[(j - c) * 2 + 1];
					long first = calc(max[i][j - c], oper, max[i + r][j]);
					long second = calc(max[i][j - c], oper, min[i + r][j]);
					long third = calc(min[i][j - c], oper, max[i + r][j]);
					long fourth = calc(min[i][j - c], oper, min[i + r][j]);
					max[i][j] = Math.max(max[i][j], Math.max(first, Math.max(second, Math.max(third, fourth))));
					min[i][j] = Math.min(min[i][j], Math.min(first, Math.min(second, Math.min(third, fourth))));
				}
			}
		}

		System.out.print(max[0][size - 1]);
	}

	private static long calc(long A, char oper, long B) {
		switch (oper) {
		case '+':
			return A + B;
		case '-':
			return A - B;
		case '*':
			return A * B;
		default:
			throw new RuntimeException();
		}
	}
}