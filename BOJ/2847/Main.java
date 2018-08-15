/*
 * Author: Minho Kim (ISKU)
 * Date: August 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2847
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		int count = 0;
		int last = array[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (array[i] >= last) {
				last--;
				count += array[i] - last;
				continue;
			}

			last = array[i];
		}

		System.out.print(count);
	}
}