/*
 * Author: Minho Kim (ISKU)
 * Date: December 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7453
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] array = new long[N][4];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)
				array[i][j] = Long.parseLong(st.nextToken());
		}

		int size = N * N;
		long[] first = new long[size];
		long[] second = new long[size];
		for (int i = 0, index = 0; i < N; i++) {
			for (int j = 0; j < N; j++, index++) {
				first[index] = array[i][0] + array[j][1];
				second[index] = array[i][2] + array[j][3];
			}
		}

		Map<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++)
			map.put(second[i], map.containsKey(second[i]) ? map.get(second[i]) + 1 : 1);

		long count = 0;
		for (int i = 0; i < size; i++)
			if (map.containsKey(-first[i]))
				count += map.get(-first[i]);

		System.out.print(count);
	}
}