/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11022
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfCase = input.nextInt();
		for (int testCase = 1; testCase <= numberOfCase; testCase++) {
			int operandA = input.nextInt();
			int operandB = input.nextInt();
			System.out.printf("Case #%d: %d + %d = %d\n", testCase, operandA, operandB, operandA + operandB);
		}
	}
}