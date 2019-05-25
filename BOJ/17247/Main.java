/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17247
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]> candidate = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					candidate.add(new int[] { i, j });
		}

		int[] A = candidate.get(0);
		int[] B = candidate.get(1);
		System.out.print(Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]));
	}
}