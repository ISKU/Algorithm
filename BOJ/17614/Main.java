/*
 * Author: Minho Kim (ISKU)
 * Date: October 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17614
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();

		int count = 0;
		for (int i = 1; i <= N; i++) {
			int n = i;

			while (n > 0) {
				int m = n % 10;
				if (m == 3 || m == 6 || m == 9)
					count++;
				n /= 10;
			}
		}

		System.out.println(count);
	}
}