/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3059
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String string = input.nextLine();
			int sum = 0;

			for (int alphabet = 65; alphabet <= 90; alphabet++) {
				if (string.indexOf(alphabet) == -1)
					sum += alphabet;
			}

			System.out.println(sum);
		}
	}
}