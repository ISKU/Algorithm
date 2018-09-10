/*
 * Author: Minho Kim (ISKU)
 * Date: September 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16112
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] array = new long[N];
		for (int i = 0; i < N; i++)
			array[i] = Long.parseLong(st.nextToken());
		Arrays.sort(array);

		long sum = 0;
		for (int i = 0, k = 0; i < N; i++) {
			sum += array[i] * k;
			if (k < K)
				k++;
		}

		System.out.print(sum);
	}
}