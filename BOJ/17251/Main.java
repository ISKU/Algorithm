/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17251
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] participants = new int[N + 1];
		for (int i = 1; i <= N; i++)
			participants[i] = Integer.parseInt(st.nextToken());

		int[] pmax = new int[N + 1];
		pmax[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++)
			pmax[i] = Math.max(pmax[i - 1], participants[i]);

		int[] smax = new int[N + 2];
		smax[N + 1] = Integer.MIN_VALUE;
		for (int i = N; i >= 1; i--)
			smax[i] = Math.max(smax[i + 1], participants[i]);

		int R = 0;
		int B = 0;
		for (int i = 1; i < N; i++) {
			if (pmax[i] < smax[i + 1])
				B++;
			else if (pmax[i] > smax[i + 1])
				R++;
		}

		System.out.print((R == B) ? "X" : (R < B) ? "B" : "R");
	}
}