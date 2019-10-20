/*
 * Author: Minho Kim (ISKU)
 * Date: October 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17502
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] word = br.readLine().toCharArray();
		for (int i = 0, j = N - 1; i <= j; i++, j--) {
			if (word[i] == '?' && word[j] == '?') {
				word[i] = 'a';
				word[j] = 'a';
				continue;
			}
			if (word[i] == '?')
				word[i] = word[j];
			if (word[j] == '?')
				word[j] = word[i];
		}

		System.out.println(word);
	}
}