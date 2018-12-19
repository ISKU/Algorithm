/*
 * Author: Minho Kim (ISKU)
 * Date: December 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14595
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N + 1];

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			room[x]++;
			room[y]--;
		}

		int count = N;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += room[i];
			if (sum > 0)
				count--;
		}

		System.out.print(count);
	}
}
