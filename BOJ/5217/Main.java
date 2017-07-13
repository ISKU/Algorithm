/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5217
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfCases = input.nextInt(); // number of cases

		for (int testCase = 1; testCase <= numberOfCases; testCase++) {
			int sumOfTwoNumbers = input.nextInt();
			StringBuilder output = new StringBuilder("Pairs for " + sumOfTwoNumbers + ": ");

			for (int number = 1; number <= Math.ceil(sumOfTwoNumbers / 2.0) - 1; number++) {
				if (number > 1)
					output.append(", ");
				output.append(number + " " + (sumOfTwoNumbers - number)); // sum of pairs
			}

			// output in lexicographic order the different pairs of numbers
			System.out.println(output);
		}
	}
}