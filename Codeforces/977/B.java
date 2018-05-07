/*
 * Author: Minho Kim (ISKU)
 * Date: May 6, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/977/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N - 1; i++) {
			String s = line.substring(i, i + 2);
			map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
		}

		String answer = "";
		int count = 0;
		for (String key : map.keySet()) {
			if (count < map.get(key)) {
				count = map.get(key);
				answer = key;
			}
		}

		bw.write(answer);
		bw.close();
	}
}