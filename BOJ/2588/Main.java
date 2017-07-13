/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2588
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int operandA = input.nextInt();
		int operandB = input.nextInt();
		String[] splitOperandB = String.valueOf(operandB).split("");

		for (int digit = splitOperandB.length - 1; digit >= 0; digit--)
			System.out.println(operandA * Integer.parseInt(splitOperandB[digit]));
		System.out.println(operandA * operandB);
	}
}