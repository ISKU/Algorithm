/*
 * Author: Minho Kim (ISKU)
 * Date: June 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/988/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			map.put(Integer.parseInt(st.nextToken()), i);

		System.out.println((map.size() >= K) ? "YES" : "NO");
		if (map.size() >= K) {
			for (Integer key : map.keySet()) {
				if (K-- == 0)
					break;
				System.out.print(map.get(key) + " ");
			}
		}
	}
}