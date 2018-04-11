/*
 * Author: Minho Kim (ISKU)
 * Date: April 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/962/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int total = 0;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
			total += array[i];
		}

		total = (total % 2 == 1) ? total / 2 + 1 : total / 2;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += array[i];
			if (sum >= total) {
				System.out.print(i + 1);
				break;
			}
		}
	}
}