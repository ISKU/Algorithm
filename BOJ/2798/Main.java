/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.08
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2798
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		int M = input.nextInt();

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 0; i < array.length; i++)
			for (int j = i + 1; j < array.length; j++)
				for (int k = j + 1; k < array.length; k++) {
					int sum = array[i] + array[j] + array[k];
					if (M - sum >= 0 && min > M - sum) {
						min = M - sum;
						answer = sum;
					}
				}

		System.out.print(answer);
	}
}