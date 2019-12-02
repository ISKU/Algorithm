/*
 * Author: Minho Kim (ISKU)
 * Date: December 3, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18110
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int limit = (int) Math.round((N * 15) / 100.0);

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());
		Arrays.sort(array);

		int sum = 0;
		for (int i = limit; i < N - limit; i++)
			sum += array[i];

		System.out.println((int) Math.round(sum / (N - (limit * 2.0))));
	}
}
