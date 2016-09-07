/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11060
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] array = new int[size];
		int[] table = new int[size];

		for (int index = 1; index < size; index++)
			table[index] = 1001;
		for (int index = 0; index < size; index++)
			array[index] = input.nextInt();

		for (int index = 0; index < size; index++) {
			for (int jump = 1; jump <= array[index]; jump++)
				if (index + jump < size)
					table[index + jump] = Math.min(table[index + jump], table[index] + 1);
		}

		System.out.print(table[size - 1] == 1001 ? -1 : table[size - 1]);
	}
}