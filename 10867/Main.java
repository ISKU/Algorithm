/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10867
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int[] positive = new int[1001];
		int[] negative = new int[1001];

		for (int count = input.nextInt(); count > 0; count--) {
			int number = input.nextInt();

			if (number >= 0)
				positive[number]++;
			else
				negative[number * -1]++;
		}

		for (int index = 1000; index > 0; index--)
			if (negative[index] != 0)
				output.append((index * -1) + " ");

		for (int index = 0; index < positive.length; index++)
			if (positive[index] != 0)
				output.append(index + " ");

		System.out.print(output);
	}
}