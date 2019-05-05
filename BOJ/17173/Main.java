/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17173
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int K = Integer.parseInt(st.nextToken());
			for (int j = K; j <= N; j += K)
				check[j] = true;
		}

		int sum = 0;
		for (int i = 0; i <= N; i++)
			if (check[i])
				sum += i;

		System.out.print(sum);
	}
}