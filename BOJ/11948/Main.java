/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11948
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] grade = new int[6];
		int sum = 0;

		for (int index = 0; index < 6; index++)
			grade[index] = input.nextInt();

		int minimumValue = Integer.MAX_VALUE;
		int minimumValueIndex = 0;
		for (int index = 0; index < 4; index++)
			if (minimumValue > grade[index]) {
				minimumValue = grade[index];
				minimumValueIndex = index;
			}

		for (int index = 0; index < 4; index++)
			if (index != minimumValueIndex)
				sum += grade[index];

		System.out.print((grade[4] > grade[5]) ? (sum + grade[4]) : (sum + grade[5]));
	}
}