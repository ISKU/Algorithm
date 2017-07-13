/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14450
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		int[] move = new int[N];
		int[][][] table = new int[N + 1][K + 1][3];

		for (int i = 0; i < N; i++) {
			String gesture = input.next();
			if (gesture.equals("H"))
				move[i] = 0;
			else if (gesture.equals("P"))
				move[i] = 1;
			else if (gesture.equals("S"))
				move[i] = 2;
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				for (int k = 0; k < 3; k++) {
					if (i == 0)
						table[i][j][k] = 0;
					else {
						if (j == 0)
							table[i][j][k] = table[i - 1][j][k] + (move[i - 1] == k ? 1 : 0);
						else {
							int first = (k + 1) % 3;
							int second = (k + 2) % 3;
							table[i][j][k] = Math.max(Math.max(table[i - 1][j][k], table[i - 1][j - 1][first]),
									table[i - 1][j - 1][second]) + (move[i - 1] == k ? 1 : 0);
						}
					}
				}
			}
		}

		System.out.print(Math.max(Math.max(table[N][K][0], table[N][K][1]), table[N][K][2]));
	}
}