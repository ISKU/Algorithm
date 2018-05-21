/*
 * Author: Minho Kim (ISKU)
 * Date: May 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15729
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] array = new boolean[N + 2];
		for (int i = 0; i < N; i++)
			array[i] = (Integer.parseInt(st.nextToken()) == 0) ? false : true;

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (!array[i])
				continue;

			array[i] = !array[i];
			array[i + 1] = !array[i + 1];
			array[i + 2] = !array[i + 2];
			count++;
		}

		System.out.print(count);
	}
}