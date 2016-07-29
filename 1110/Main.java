/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1110
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int firstNumber = input.nextInt();
		int lengthOfCycle = 0; // count
		
		int createNumber = firstNumber; // initialization
		do {
			// calculated new number
			createNumber = (createNumber % 10) * 10 + ((createNumber / 10) + (createNumber % 10)) % 10;
			lengthOfCycle++;
		} while (createNumber != firstNumber);

		System.out.println(lengthOfCycle);
	}
}