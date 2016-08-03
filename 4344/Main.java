
/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4344
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int numberOfStudents = input.nextInt();
			int[] student = new int[numberOfStudents];
			float totalScore = 0;
			float moreThanAverageNumberOfStudents = 0;

			for (int count = numberOfStudents - 1; count >= 0; count--) {
				int score = input.nextInt();
				student[count] = score;
				totalScore = totalScore + score;
			}

			float averageScore = totalScore / numberOfStudents;

			for (int index = numberOfStudents - 1; index >= 0; index--)
				if (student[index] > averageScore)
					moreThanAverageNumberOfStudents++;

			System.out.printf("%.3f%%\n", (float) moreThanAverageNumberOfStudents / numberOfStudents * 100);
		}
	}
}