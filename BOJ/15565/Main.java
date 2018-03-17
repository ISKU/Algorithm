/*
 * Author: Minho Kim (ISKU)
 * Date: March 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15565
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			if (Integer.parseInt(st.nextToken()) == 1)
				array[i] = 1;

		int answer = Integer.MAX_VALUE;
		for (int i = 0, j = 0, sum = 0; j < N && i < N;) {
			if (sum >= K || array[i] == 0)
				sum -= array[i++];
			else
				sum += array[j++];

			if (sum == K)
				answer = Math.min(answer, j - i);
		}

		System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
}