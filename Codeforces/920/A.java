/*
 * Author: Minho Kim (ISKU)
 * Date: February 02, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/920/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Queue<Integer> q = new LinkedList<Integer>();
			int[] map = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			while (K-- > 0) {
				int x = Integer.parseInt(st.nextToken());
				q.add(x);
				map[x] = 1;
			}

			while (!q.isEmpty()) {
				int x = q.poll();

				if (x - 1 >= 1 && map[x - 1] == 0) {
					q.add(x - 1);
					map[x - 1] = map[x] + 1;
				}
				if (x + 1 <= N && map[x + 1] == 0) {
					q.add(x + 1);
					map[x + 1] = map[x] + 1;
				}
			}

			int answer = 0;
			for (int i : map)
				answer = Math.max(answer, i);
			bw.write(String.valueOf(answer));
			bw.newLine();
		}

		bw.close();
	}
}