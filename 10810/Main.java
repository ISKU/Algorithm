/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10810
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] basket = new int[input.nextInt()];

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int startIndex = input.nextInt() - 2;
			int endIndex = input.nextInt() - 1;
			int ballNumber = input.nextInt();

			while (startIndex++ < endIndex)
				basket[startIndex] = ballNumber;
		}

		for (int index = 0; index < basket.length; index++)
			System.out.print(basket[index] + " ");
	}
}