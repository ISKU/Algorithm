/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11966
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] arrayPower = new int[31];
		boolean answer = false;

		arrayPower[0] = 1;
		for (int index = 1; index < arrayPower.length; index++)
			arrayPower[index] = arrayPower[index - 1] * 2;

		for (int index = 0, number = input.nextInt(); index < arrayPower.length; index++)
			if (number == arrayPower[index]) {
				answer = true;
				break;
			}

		System.out.println(answer ? 1 : 0);
	}
}