/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2985
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberA = input.nextInt();
		int numberB = input.nextInt();
		int numberC = input.nextInt();

		if (numberA + numberB == numberC)
			System.out.print(numberA + "+" + numberB + "=" + numberC);
		else if (numberA - numberB == numberC)
			System.out.print(numberA + "-" + numberB + "=" + numberC);
		else if (numberA / numberB == numberC)
			System.out.print(numberA + "/" + numberB + "=" + numberC);
		else if (numberA * numberB == numberC)
			System.out.print(numberA + "*" + numberB + "=" + numberC);
		else if (numberB + numberC == numberA)
			System.out.print(numberA + "=" + numberB + "+" + numberC);
		else if (numberB - numberC == numberA)
			System.out.print(numberA + "=" + numberB + "-" + numberC);
		else if (numberB / numberC == numberA)
			System.out.print(numberA + "=" + numberB + "/" + numberC);
		else if (numberB * numberC == numberA)
			System.out.print(numberA + "=" + numberB + "*" + numberC);
	}
}