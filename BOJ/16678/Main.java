/*
 * Author: Minho Kim (ISKU)
 * Date: December 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16678
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] array = new long[N];
		for (int i = 0; i < N; i++)
			array[i] = Long.parseLong(br.readLine());
		Arrays.sort(array);

		long answer = 0;
		for (int i = 0, t = 1; i < N; i++) {
			if (array[i] >= t) {
				answer += array[i] - t;
				t++;
			}
		}

		System.out.print(answer);
	}
}