/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11055
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		int[] table = new int[array.length];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		for (int i = 0; i < array.length; i++) {
			table[i] = array[i];
			for (int j = 0; j < i; j++)
				if (array[i] > array[j] && table[j] + array[i] > table[i])
					table[i] = table[j] + array[i];
		}

		int max = 0;
		for (int i = 0; i < array.length; i++)
			max = Math.max(max, table[i]);

		System.out.print(max);
	}
}