/*
 * Author: Minho Kim (ISKU)
 * Date: February 10, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5525
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		boolean poss = (S.charAt(0) == 'I');
		int count = 0;
		int sum = 0;

		for (int i = 1; i < M; i++) {
			char cur = S.charAt(i);

			if (S.charAt(i - 1) == cur) {
				if (poss && count != 0 && count >= N)
					sum += count - N + 1;
				poss = false;
				count = 0;
			}
			if (cur == 'I') {
				if (poss)
					count++;
				poss = true;
			}
		}
		if (count != 0 && count >= N)
			sum += count - N + 1;

		System.out.println(sum);
	}
}