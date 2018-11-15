/*
 * Author: Minho Kim (ISKU)
 * Date: November 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16435
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] fruit = new int[10001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			fruit[Integer.parseInt(st.nextToken())]++;

		for (int i = 1; i <= 10000; i++)
			if (i <= L)
				L += fruit[i];

		System.out.print(L);
	}
}