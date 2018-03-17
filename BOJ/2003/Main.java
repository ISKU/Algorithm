/*
 * Author: Minho Kim (ISKU)
 * Date: March 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2003
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int count = 0;
		int i = 0, j = 0, sum = 0;
		while (true) {
			if (sum >= M)
				sum -= array[i++];
			else if (j == N)
				break;
			else
				sum += array[j++];

			if (sum == M)
				count++;
		}

		System.out.print(count);
	}
}