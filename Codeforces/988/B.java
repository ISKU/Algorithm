/*
 * Author: Minho Kim (ISKU)
 * Date: June 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/988/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] lines = new String[N];
		for (int i = 0; i < N; i++)
			lines[i] = br.readLine();

		Arrays.sort(lines, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = i + 1; j < N; j++) {
				if (!lines[j].contains(lines[i]))
					check = false;
			}

			if (!check) {
				System.out.println("NO");
				System.exit(0);
			}
		}

		System.out.println("YES");
		for (int i = 0; i < N; i++)
			System.out.println(lines[i]);
	}
}