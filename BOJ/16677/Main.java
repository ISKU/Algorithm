/*
 * Author: Minho Kim (ISKU)
 * Date: December 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16677
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		char[] m = sc.next().toCharArray();

		int N = sc.nextInt();
		String answer = "No Jam";
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			String w = sc.next();
			double g = sc.nextDouble();

			int index = 0;
			for (int j = 0; j < w.length(); j++) {
				if (m[index] == w.charAt(j))
					index++;
				if (index == m.length) {
					if (max < g / (w.length() - m.length)) {
						max = g / (w.length() - m.length);
						answer = w;
					}
					break;
				}
			}
		}

		System.out.print(answer);
	}
}