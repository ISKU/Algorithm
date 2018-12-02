/*
 * Author: Minho Kim (ISKU)
 * Date: December 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1107
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Set<Integer> set = new HashSet<>();
		while (M-- > 0)
			set.add(sc.nextInt());

		int answer = Math.abs(N - 100);
		if (!set.contains(0)) {
			answer = Math.min(answer, N + 1);
		}

		for (int i = 1; i <= 999999; i++) {
			int n = i;
			int count = 0;
			boolean check = true;
			while (n > 0) {
				if (set.contains(n % 10)) {
					check = false;
					break;
				}
				n /= 10;
				count++;
			}

			if (check)
				answer = Math.min(answer, Math.abs(N - i) + count);
			answer = Math.min(answer, Math.abs(N - 100));
		}

		System.out.print(answer);
	}
}