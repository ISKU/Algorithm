/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2579
 */

import java.util.Scanner;

public class Main {

	private static int[] stair;
	private static int[] table;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfSteps = input.nextInt(); // number of steps
		table = new int[numberOfSteps + 1];
		stair = new int[numberOfSteps + 1];

		// input, value of each step
		for (int index = 1; index <= numberOfSteps; index++)
			stair[index] = input.nextInt();

		System.out.println(find(numberOfSteps, 2)); // output, maximum value
	}

	private static int find(int index, int step) {
		if (index <= 0) // end
			return 0;

		if (step == 1) { // move one step
			if (table[index] != 0) // already calculated, important
				return table[index];
			return table[index] = stair[index] + find(index - 2, 2); // move one step and then must move two steps.
		} else // move two step
			return stair[index] + Math.max(find(index - 1, 1), find(index - 2, 2));
	}
}