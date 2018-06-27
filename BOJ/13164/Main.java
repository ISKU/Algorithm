/*
 * Author: Minho Kim (ISKU)
 * Date: June 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13164
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
		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 1; i < N; i++)
			pq.add(array[i] - array[i - 1]);

		long cost = array[N - 1] - array[0];
		for (int i = 1; i < K; i++)
			cost -= pq.poll();

		System.out.print(cost);
	}
}