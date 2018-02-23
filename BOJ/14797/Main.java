/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.15
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14797
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int R = input.nextInt();
			int C = input.nextInt();
			char[][] cake = new char[R][C];

			for (int i = 0; i < R; i++) {
				char[] line = input.next().toCharArray();
				for (int j = 0; j < C; j++)
					cake[i][j] = line[j];
			}

			for (int i = 0; i < R; i++) {
				int check = 0;
				for (int j = 0; j < C; j++)
					if (cake[i][j] == '?')
						check++;

				if (check == C) {
					for (int j = 0; j < C; j++)
						if (i - 1 >= 0)
							cake[i][j] = cake[i - 1][j];
				} else {
					for (int j = 0; j < C; j++) {
						if (cake[i][j] != '?') {
							for (int left = j - 1; left >= 0; left--) {
								if (cake[i][left] != '?')
									break;
								cake[i][left] = cake[i][j];
							}
							for (int right = j + 1; right < C; right++) {
								if (cake[i][right] != '?')
									break;
								cake[i][right] = cake[i][j];
							}
						}
					}
				}
			}

			int check = 0;
			for (int j = 0; j < C; j++)
				if (cake[0][j] == '?')
					check++;

			if (check == C) {
				for (int j = 0; j < C; j++) {
					char cand = '?';

					for (int i = 0; i < R; i++)
						if (cake[i][j] != '?') {
							cand = cake[i][j];
							break;
						}

					for (int i = 0; i < R; i++) {
						if (cake[i][j] == '?')
							cake[i][j] = cand;
						else
							break;
					}
				}
			}

			System.out.printf("Case #%d:\n", tCase);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					System.out.print(cake[i][j]);
				System.out.println();
			}
		}
	}
}