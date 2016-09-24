/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5363
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			StringBuilder newLine = new StringBuilder();
			String[] line = input.nextLine().split(" ");

			for (int index = 2; index < line.length; index++)
				newLine.append(line[index] + " ");

			newLine.append(line[0] + " ");
			newLine.append(line[1]);
			output.append(newLine.toString() + "\n");
		}

		System.out.println(output);
	}
}