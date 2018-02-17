/*
 * Author: Minho Kim (ISKU)
 * Date: February 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/938/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] line = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-- > 0)
			line[Integer.parseInt(st.nextToken())] = true;

		int first = 1, second = 1;
		for (int i = 2, j = 999999, a = 1, b = 1; i < j; i++, j--, a++, b++) {
			if (line[i])
				first = a;
			if (line[j])
				second = b;
		}

		System.out.print(Math.max(first, second));
	}
}