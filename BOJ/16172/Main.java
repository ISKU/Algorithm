/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16172
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String target = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < origin.length(); i++) {
			if ('a' <= origin.charAt(i) && origin.charAt(i) <= 'z')
				sb.append(origin.charAt(i));
			if ('A' <= origin.charAt(i) && origin.charAt(i) <= 'Z')
				sb.append(origin.charAt(i));
		}

		origin = sb.toString();
		System.out.print(kmp(origin, target) ? "1" : "0");
	}

	private static boolean kmp(String origin, String target) {
		int N = origin.length();
		int M = target.length();

		int[] failed = new int[M];
		for (int i = 1, j = 0; i < M; i++) {
			while (j > 0 && target.charAt(i) != target.charAt(j))
				j = failed[j - 1];
			if (target.charAt(i) == target.charAt(j))
				failed[i] = ++j;
		}

		for (int i = 0, j = 0; i < N; i++) {
			while (j > 0 && origin.charAt(i) != target.charAt(j))
				j = failed[j - 1];
			if (origin.charAt(i) == target.charAt(j)) {
				if (j == M - 1)
					return true;
				j++;
			}
		}

		return false;
	}
}