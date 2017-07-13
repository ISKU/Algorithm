/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5800
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int X = 1; X <= testCase; X++) {
			int[] score = new int[input.nextInt()];
			for (int i = 0; i < score.length; i++)
				score[i] = input.nextInt();

			Arrays.sort(score);
			int maxGap = 0;
			for (int i = score.length - 1; i > 0; i--)
				maxGap = Math.max(maxGap, score[i] - score[i - 1]);
			
			System.out.printf("Class %d\nMax %d, Min %d, Largest gap %d\n", 
					X, score[score.length - 1], score[0], maxGap);
		}
	}
}