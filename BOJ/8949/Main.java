/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8949
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		String[] numberA = String.valueOf(input.nextInt()).split("");
		String[] numberB = String.valueOf(input.nextInt()).split("");

		if (numberA.length < numberB.length) {
			for (int index = 0; index < numberB.length - numberA.length; index++)
				output.append(numberB[index]);

			int indexOfB = numberB.length - numberA.length;
			for (int index = 0; index < numberA.length; index++)
				output.append(String.valueOf(Integer.parseInt(numberA[index]) + Integer.parseInt(numberB[indexOfB++])));
		} else if (numberB.length < numberA.length) {
			for (int index = 0; index < numberA.length - numberB.length; index++)
				output.append(numberA[index]);

			int indexOfA = numberA.length - numberB.length;
			for (int index = 0; index < numberB.length; index++)
				output.append(String.valueOf(Integer.parseInt(numberA[indexOfA++]) + Integer.parseInt(numberB[index])));
		} else {
			for (int index = 0; index < numberA.length; index++)
				output.append(String.valueOf(Integer.parseInt(numberA[index]) + Integer.parseInt(numberB[index])));
		}

		System.out.println(output);
	}
}