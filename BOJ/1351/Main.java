/*
 * Author: Minho Kim (ISKU)
 * Date: April 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1351
 */

import java.io.*;
import java.util.*;

public class Main {

	private static Map<Long, Long> map;
	private static long N, P, Q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());

		map = new HashMap<Long, Long>();
		map.put(0l, 1l);
		System.out.print((N == 0) ? 1 : dfs(N));
	}

	private static long dfs(long i) {
		Long first = map.get(i / P);
		if (first == null) {
			first = dfs(i / P);
			map.put(i / P, first);
		}

		Long second = map.get(i / Q);
		if (second == null) {
			second = dfs(i / Q);
			map.put(i / Q, second);
		}

		return first + second;
	}
}