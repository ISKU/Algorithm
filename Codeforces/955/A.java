/*
 * Author: Minho Kim (ISKU)
 * Date: March 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/955/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int HH = sc.nextInt();
		int MM = sc.nextInt();
		int H = sc.nextInt();
		int D = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();

		double answer = Double.MAX_VALUE;
		for (; HH != 24; H += D) {
			if (HH >= 20)
				answer = Math.min(answer, ((H % N == 0) ? H / N : H / N + 1) * (C * 0.8));
			else
				answer = Math.min(answer, ((H % N == 0) ? H / N : H / N + 1) * C);

			if (++MM == 60) {
				HH++;
				MM = 0;
			}
		}

		System.out.printf("%.4f", answer);
	}
}