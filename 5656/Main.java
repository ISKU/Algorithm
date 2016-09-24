/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5656
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = 0;

		while (true) {
			String[] equation = input.nextLine().split(" ");
			int numberA = Integer.parseInt(equation[0]);
			int numberB = Integer.parseInt(equation[2]);
			testCase++;

			if (equation[1].equals("E"))
				break;
			else if (equation[1].equals("!="))
				output.append("Case " + testCase + ": " + ((numberA != numberB) ? "true\n" : "false\n"));
			else if (equation[1].equals("<"))
				output.append("Case " + testCase + ": " + ((numberA < numberB) ? "true\n" : "false\n"));
			else if (equation[1].equals("<="))
				output.append("Case " + testCase + ": " + ((numberA <= numberB) ? "true\n" : "false\n"));
			else if (equation[1].equals(">"))
				output.append("Case " + testCase + ": " + ((numberA > numberB) ? "true\n" : "false\n"));
			else if (equation[1].equals(">="))
				output.append("Case " + testCase + ": " + ((numberA >= numberB) ? "true\n" : "false\n"));
			else if (equation[1].equals("=="))
				output.append("Case " + testCase + ": " + ((numberA == numberB) ? "true\n" : "false\n"));
		}

		System.out.print(output);
	}
}