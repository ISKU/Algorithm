/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8394
 */

import java.util.Scanner;

public class Main {

	private static final int DIVISOR = 10;

	public static void main(String args[]) {
		int numberOfPeople = new Scanner(System.in).nextInt();
		int[] table = new int[numberOfPeople + 1];

		table[1] = 1;
		table[2] = 2;
		for (int i = 3; i <= numberOfPeople; i++)
			table[i] = (table[i - 1] % 10 + table[i - 2] % DIVISOR) % DIVISOR;

		System.out.println(table[numberOfPeople]);
	}
}