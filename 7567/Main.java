/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7567
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		char[] array = new Scanner(System.in).nextLine().toCharArray();
		int sum = 10;

		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] == '(' && array[i] == '(')
				sum += 5;
			else if (array[i - 1] == ')' && array[i] == ')')
				sum += 5;
			else
				sum += 10;
		}

		System.out.println(sum);
	}
}