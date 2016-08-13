/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.13
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2240
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int maxTime = input.nextInt();
		int maxStep = input.nextInt();
		int[] treePosition = new int[maxTime];
		int[][] table = new int[maxTime][maxStep + 1];

		// init first
		int firstTreePosition = input.nextInt();
		if (firstTreePosition == 1)
			table[0][0] = 1;
		else
			table[0][1] = 1;

		// input, tree position
		for (int index = 1; index < maxTime; index++) {
			treePosition[index] = input.nextInt();
			table[index][0] = treePosition[index] == 1 ? table[index - 1][0] + 1 : table[index - 1][0];
		}

		for (int time = 1; time < maxTime; time++) {
			int currentTreePosition = treePosition[time];
			for (int step = 1; step <= time + 1; step++) {
				if (step <= maxStep) {
					if (step % 2 + 1 == currentTreePosition)
						table[time][step] = Math.max(table[time - 1][step - 1], table[time - 1][step]) + 1;
					else
						table[time][step] = Math.max(table[time - 1][step - 1], table[time - 1][step]);
				}
			}
		}

		// output
		int numberOfMaximumPlums = 0;
		for (int step = 0; step <= maxTime; step++)
			if (step <= maxStep)
				numberOfMaximumPlums = Math.max(numberOfMaximumPlums, table[maxTime - 1][step]);
		System.out.println(numberOfMaximumPlums);
	}
}