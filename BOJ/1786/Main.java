/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1786
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String T = br.readLine();
		String P = br.readLine();

		List<Integer> matched = kmp(T, P);
		bw.write(matched.size() + "\n");
		for (int i : matched) {
			bw.write(String.valueOf(i + 1));
			bw.write("\n");
		}
		bw.close();
	}

	private static List<Integer> kmp(String origin, String target) {
		int N = origin.length();
		int M = target.length();

		int[] failed = new int[M];
		for (int i = 1, j = 0; i < M; i++) {
			while (j > 0 && target.charAt(i) != target.charAt(j))
				j = failed[j - 1];
			if (target.charAt(i) == target.charAt(j))
				failed[i] = ++j;
		}

		List<Integer> matched = new ArrayList<>();
		for (int i = 0, j = 0; i < N; i++) {
			while (j > 0 && origin.charAt(i) != target.charAt(j))
				j = failed[j - 1];
			if (origin.charAt(i) == target.charAt(j)) {
				if (j == M - 1) {
					matched.add(i - M + 1);
					j = failed[j];
					continue;
				}
				j++;
			}
		}

		return matched;
	}
}