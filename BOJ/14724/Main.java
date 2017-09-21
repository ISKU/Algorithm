/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14724
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String[] club = new String[] { "PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY" };
		int N = input.nextInt();

		int[] maxScore = new int[9];
		for (int i = 0; i < 9; i++) {
			int max = 0;
			for (int j = 0; j < N; j++)
				max = Math.max(max, input.nextInt());
			maxScore[i] = max;
		}

		int answer = 0;
		int max = 0;
		for (int i = 0; i < 9; i++)
			if (max < maxScore[i]) {
				answer = i;
				max = maxScore[i];
			}

		System.out.print(club[answer]);
	}
}