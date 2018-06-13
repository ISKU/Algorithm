/*
 * Author: Minho Kim (ISKU)
 * Date: June 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15708
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int sum = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (T < P * i)
				break;

			int K = Integer.parseInt(st.nextToken());
			sum += K;
			pq.add(K);

			while (!pq.isEmpty() && sum > T)
				sum -= pq.poll();

			sum += P;
			count = Math.max(count, pq.size());
		}

		System.out.print(count);
	}
}