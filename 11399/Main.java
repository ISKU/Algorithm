/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11399
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfPeople = input.nextInt(); // number of people
		int[] fixLine = new int[numberOfPeople]; // get into a straight line

		for (int person = 0; person < numberOfPeople; person++)
			fixLine[person] = input.nextInt(); // input value, the time it takes to withdraw money

		Arrays.sort(fixLine); // ascending sort

		int minimumTime = fixLine[0];
		for (int index = 1; index < numberOfPeople; index++) {
			fixLine[index] = fixLine[index] + fixLine[index - 1];
			minimumTime = minimumTime + fixLine[index];
		}

		// output, minimum time necessary for each person to withdraw money
		System.out.println(minimumTime);
	}
}