/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15511
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer> first = new HashSet<Integer>();
		HashSet<Integer> second = new HashSet<Integer>();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (first.contains(u)) {
				if (first.contains(v))
					finish();
				second.add(v);
			} 
			else if (second.contains(u)) {
				if (second.contains(v))
					finish();
				first.add(v);
			}
			else if (first.contains(v)) {
				if (first.contains(u))
					finish();
				second.add(u);
			}
			else if (second.contains(v)) {
				if (second.contains(u))
					finish();
				first.add(u);
			}
			else {
				first.add(u);
				second.add(v);
			}
		}

		System.out.print("POSSIBLE");
	}

	private static void finish() {
		System.out.print("IMPOSSIBLE");
		System.exit(0);
	}
}