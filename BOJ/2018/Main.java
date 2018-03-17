/*
 * Author: Minho Kim (ISKU)
 * Date: March 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2018
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = i + 1;

		int count = 0;
		int i = 0, j = 0, sum = 0;
		while (true) {
			if (sum >= N)
				sum -= array[i++];
			else if (j == N)
				break;
			else
				sum += array[j++];

			if (sum == N)
				count++;
		}

		System.out.print(count);
	}
}