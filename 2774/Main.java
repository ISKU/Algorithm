/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2774
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int[] digit = new int[10];
			int output = 0;
			String[] number = String.valueOf(input.nextInt()).split("");

			for (int index = 0; index < number.length; index++)
				digit[Integer.parseInt(number[index])]++;

			for (int index = 0; index < digit.length; index++)
				if (digit[index] != 0)
					output++;

			System.out.println(output);
		}
	}
}