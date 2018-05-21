/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15732
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Rule[] rules;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long D = Long.parseLong(st.nextToken());

		rules = new Rule[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			rules[i] = new Rule(A, B, C);
		}

		int l = 1;
		int r = N;
		while (l < r) {
			int mid = (l + r) / 2;

			if (D <= sum(mid))
				r = mid;
			else
				l = mid + 1;
		}

		System.out.print(l);
	}

	private static long sum(int X) {
		long sum = 0;

		for (Rule rule : rules) {
			if (rule.A <= X && X <= rule.B)
				sum += ((X - rule.A) / rule.C) + 1;
			else if (rule.B <= X)
				sum += ((rule.B - rule.A) / rule.C) + 1;
		}

		return sum;
	}

	private static class Rule {
		public int A, B, C;

		public Rule(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
}