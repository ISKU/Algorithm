/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.29
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13238
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		int max = 0;
		for (int i = 0; i < array.length; i++)
			for (int j = i; j < array.length; j++)
				max = Math.max(max, array[j] - array[i]);

		System.out.print(max);
	}
}