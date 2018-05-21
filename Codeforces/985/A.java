/*
 * Author: Minho Kim (ISKU)
 * Date: May 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/985/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] chess = new boolean[N + 1];
		for (int i = N / 2; i < N; i++)
			chess[Integer.parseInt(st.nextToken())] = true;

		int oddSum = 0;
		int evenSum = 0;
		for (int i = N, gap = N; i >= 1; i--) {
			if (!chess[i])
				continue;

			oddSum += Math.abs(i - gap + 1);
			evenSum += Math.abs(i - gap);
			gap -= 2;
		}

		System.out.print(Math.min(oddSum, evenSum));
	}
}