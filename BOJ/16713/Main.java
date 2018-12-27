/*
 * Author: Minho Kim (ISKU)
 * Date: December 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16713
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] pxor = new int[N + 1];
		for (int i = 1; i <= N; i++)
			pxor[i] = pxor[i - 1] ^ Integer.parseInt(st.nextToken());

		int answer = 0;
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			answer ^= pxor[e] ^ pxor[s - 1];
		}

		System.out.print(answer);
	}
}