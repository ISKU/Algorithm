/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14912
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D = sc.nextInt();

		int[] freq = new int[10];
		for (int i = 1; i <= N; i++) {
			int temp = i;

			while (temp > 0) {
				freq[temp % 10]++;
				temp /= 10;
			}
		}

		System.out.print(freq[D]);
	}
}