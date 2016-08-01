/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4101
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int firstNumber = input.nextInt();
			int secondNumber = input.nextInt();

			if (firstNumber == 0 && secondNumber == 0) // end
				break;
			System.out.println(firstNumber > secondNumber ? "Yes" : "No");
		}
	}
}