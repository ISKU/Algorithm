/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2675
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int length = input.nextInt();
			String string = input.next();

			for (int index = 0; index < string.length(); index++)
				for (int count = 0; count < length; count++)
					System.out.print(string.charAt(index));
			System.out.println();
		}
	}
}