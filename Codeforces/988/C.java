/*
 * Author: Minho Kim (ISKU)
 * Date: June 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/988/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		HashMap<Integer, Node> map = new HashMap<>();
		for (int k = 1; k <= K; k++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] array = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				sum += array[i];
			}

			for (int i = 0; i < N; i++) {
				int candidate = sum - array[i];

				if (map.containsKey(candidate)) {
					Node temp = map.get(candidate);
					if (temp.k != k) {
						System.out.println("YES");
						System.out.printf("%d %d\n", k, i + 1);
						System.out.printf("%d %d\n", temp.k, temp.i);
						System.exit(0);
					}
				}

				map.put(candidate, new Node(k, i + 1));
			}
		}

		System.out.print("NO");
	}

	private static class Node {
		public int k, i;

		public Node(int i, int x) {
			this.k = i;
			this.i = x;
		}
	}
}