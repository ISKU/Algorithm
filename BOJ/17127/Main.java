/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17127
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(st.nextToken());

		int max = N - 3;
		int answer = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (i + max - 1 >= N)
				break;

			int candidate = 1;
			for (int j = 0; j < max; j++)
				candidate *= tree[i + j];

			if (answer < candidate) {
				answer = candidate;
				idx = i;
			}
		}

		for (int i = 0; i < N; i++) {
			if (idx <= i && i <= idx + max - 1)
				continue;
			answer += tree[i];
		}

		System.out.println(answer);
	}
}