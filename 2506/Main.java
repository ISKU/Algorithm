/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2506
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] score = new int[input.nextInt()];
		int prevGrade = 0;
		int sum = 0;

		for (int index = 0; index < score.length; index++) {
			int currentScore = input.nextInt();

			if (currentScore == 1) {
				prevGrade++;
				sum += prevGrade;
			} else
				prevGrade = 0;
		}

		System.out.print(sum);
	}
}