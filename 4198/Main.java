/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4198
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		int[] max = new int[array.length];
		int[] min = new int[array.length];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		for (int i = array.length - 1; i >= 0; i--) {
			max[i] = min[i] = 1;

			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j] && max[j] + 1 > max[i])
					max[i] = max[j] + 1;
				if (array[i] < array[j] && min[j] + 1 > min[i])
					min[i] = min[j] + 1;
			}
		}

		int answer = 0;
		for (int i = 0; i < array.length; i++)
			answer = Math.max(answer, max[i] + min[i] - 1);
		System.out.print(answer);
	}
}