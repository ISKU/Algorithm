/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11054
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		int[] left = new int[array.length];
		int[] right = new int[array.length];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		for (int i = 0; i < array.length; i++) {
			left[i] = 1;

			for (int j = 0; j < i; j++)
				if (array[i] > array[j] && left[j] + 1 > left[i])
					left[i] = left[j] + 1;
		}

		for (int i = array.length - 1; i >= 0; i--) {
			right[i] = 1;

			for (int j = i + 1; j < array.length; j++)
				if (array[i] > array[j] && right[j] + 1 > right[i])
					right[i] = right[j] + 1;
		}

		int answer = 0;
		for (int i = 0; i < array.length; i++)
			answer = Math.max(answer, left[i] + right[i] - 1);
		System.out.print(answer);
	}
}