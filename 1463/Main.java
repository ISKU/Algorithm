/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1463
 */

import java.util.Scanner;

public class Main {

	private static int[] table = new int[1000001];

	public static void main(String args[]) {
		int number = new Scanner(System.in).nextInt();

		for (int index = 2; index <= number; index++) {
			table[index] = table[index - 1] + 1;
			if (index % 2 == 0)
				table[index] = Math.min(table[index], table[index / 2] + 1);
			if (index % 3 == 0)
				table[index] = Math.min(table[index], table[index / 3] + 1);
		}

		System.out.println(table[number]);
	}
}