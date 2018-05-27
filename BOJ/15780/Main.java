/*
 * Author: Minho Kim (ISKU)
 * Date: May 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15780
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int sum = 0;
		for (int i = 0; i < K; i++)
			sum += (sc.nextInt() + 1) / 2;

		System.out.print((N <= sum) ? "YES" : "NO");
	}
}