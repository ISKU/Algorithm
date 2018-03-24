/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14916
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int min = Integer.MAX_VALUE;
		int five = N / 5 + 1;
		while (five-- > 0) {
			int two = (N - (5 * five)) % 2;
			if (two == 0)
				min = Math.min(min, five + (N - (5 * five)) / 2);
		}

		System.out.print((min == Integer.MAX_VALUE || N == 0) ? -1 : min);
	}
}