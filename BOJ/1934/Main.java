/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1934
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int firstNumber = input.nextInt();
			int secondNumber = input.nextInt();
			int multiplyNumber = firstNumber * secondNumber;
			int tempNumber;

			while (secondNumber != 0) {
				tempNumber = firstNumber % secondNumber;
				firstNumber = secondNumber;
				secondNumber = tempNumber;
			}
			System.out.println(multiplyNumber / firstNumber);
		}
	}
}