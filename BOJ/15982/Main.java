/*
 * Author: Minho Kim (ISKU)
 * Date: August 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15982
 */

import java.util.*;
import java.io.*;

public class Main {

	private static TreeSet<Integer>[] map;
	private static TreeMap<Integer, Integer> max;
	private static int[] psum;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] cows = new int[N + 1];
		for (int i = 1; i <= N; i++)
			cows[i] = (st.nextToken().equals("1")) ? 1 : -1;

		psum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			psum[i] = psum[i - 1] + cows[i];

		map = new TreeSet[N * 2 + 1];
		for (int i = 0; i < map.length; i++)
			map[i] = new TreeSet<Integer>();

		max = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i <= N; i++)
			update(i, true);
		bw.write(max.firstKey() + "\n");

		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int m = Integer.parseInt(st.nextToken());
			int temp = cows[m];
			cows[m] = cows[m + 1];
			cows[m + 1] = temp;

			update(m, false);
			psum[m] = psum[m - 1] + cows[m];
			update(m, true);

			bw.write(max.firstKey() + "\n");
		}

		bw.close();
	}

	private static void update(int i, boolean add) {
		TreeSet<Integer> p = map[psum[i] + N];

		if (p.size() >= 1) {
			int key = p.last() - p.first();
			int count = max.get(key) - 1;

			if (count <= 0)
				max.remove(key);
			else
				max.put(key, count);
		}

		if (add)
			p.add(i);
		else
			p.remove(i);

		if (p.size() >= 1) {
			int key = p.last() - p.first();
			max.put(key, max.containsKey(key) ? max.get(key) + 1 : 1);
		}
	}
}