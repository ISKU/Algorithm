/*
 * Author: Minho Kim (ISKU)
 * Date: March 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1302
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		while (N-- > 0) {
			String book = br.readLine();
			map.put(book, map.containsKey(book) ? map.get(book) + 1 : 1);
		}

		int max = 0;
		String answer = null;
		for (String key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				answer = key;
			}
		}

		System.out.print(answer);
	}
}