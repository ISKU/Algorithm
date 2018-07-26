/*
 * Author: Minho Kim (ISKU)
 * Date: July 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1712
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		if (B >= C) {
			System.out.print(-1);
			System.exit(0);
		}

		long profit = C - B;
		long sum = profit;
		int count = 1;
		while (A >= sum) {
			sum += profit;
			count++;
		}

		System.out.print(count);
	}
}