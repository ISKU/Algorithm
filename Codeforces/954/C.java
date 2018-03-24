/*
 * Author: Minho Kim (ISKU)
 * Date: March 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/954/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int X = 0;
		for (int i = 1; i < N; i++) {
			int diff = Math.abs(array[i] - array[i - 1]);

			if (diff == 0)
				finish();
			if (diff > 1) {
				if (X != 0 && diff != X)
					finish();
				X = diff;
			}
		}

		if (X != 0) {
			for (int i = 1; i < N; i++)
				if (Math.abs(array[i] - array[i - 1]) == 1 && Math.min(array[i], array[i - 1]) % X == 0)
					finish();
		}

		System.out.printf("YES\n%d %d", (int) 1e9, (X == 0) ? (int) 1e9 : X);
	}

	private static void finish() {
		System.out.print("NO");
		System.exit(0);
	}
}