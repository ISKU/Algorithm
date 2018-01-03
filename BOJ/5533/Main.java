/* 
 * Author: Minho Kim (ISKU)
 * Date: January 4, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5533
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[][] score = new int[N][4];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++)
				score[i][j] = input.nextInt();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				boolean check = true;

				for (int k = 0; k < N; k++)
					if (j != k && score[j][i] == score[k][i])
						check = false;

				if (check)
					score[j][3] += score[j][i];
			}
		}

		for (int i = 0; i < N; i++)
			System.out.println(score[i][3]);
	}
}