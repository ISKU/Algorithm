/*
 * Author: Minho Kim (ISKU)
 * Date: May 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/981/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int element = Integer.parseInt(st.nextToken());
			int income = Integer.parseInt(st.nextToken());
			map.put(element, income);
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int element = Integer.parseInt(st.nextToken());
			int income = Integer.parseInt(st.nextToken());
			map.put(element, map.containsKey(element) ? Math.max(map.get(element), income) : income);
		}

		long total = 0;
		for (Integer key : map.keySet())
			total += map.get(key);

		System.out.print(total);
	}
}