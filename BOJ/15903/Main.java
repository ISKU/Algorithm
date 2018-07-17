/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15903
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Long> pq = new PriorityQueue<>();
		while (N-- > 0)
			pq.add(Long.parseLong(st.nextToken()));

		while (M-- > 0) {
			long result = pq.poll() + pq.poll();
			pq.add(result);
			pq.add(result);
		}

		long sum = 0;
		for (long l : pq)
			sum += l;

		System.out.print(sum);
	}
}