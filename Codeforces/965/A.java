/*
 * Author: Minho Kim (ISKU)
 * Date: April 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/965/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int i = 1;
		for (int s = S; N > s; i++)
			s += S;

		int total = i * K;
		i = 1;
		for (int p = P; total > p; i++)
			p += P;

		System.out.println(i);
	}
}