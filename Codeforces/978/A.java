/*
 * Author: Minho Kim (ISKU)
 * Date: May 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/978/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++)
			map.put(Integer.parseInt(st.nextToken()), i);

		TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
		for (int key : map.keySet())
			sortedMap.put(map.get(key), key);

		bw.write(sortedMap.size() + "\n");
		for (int key : sortedMap.keySet())
			bw.write(sortedMap.get(key) + " ");

		bw.close();
	}
}