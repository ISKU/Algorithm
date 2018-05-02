/*
 * Author: Minho Kim (ISKU)
 * Date: May 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/975/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] original = new long[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++)
			original[i] = Long.parseLong(st.nextToken());

		long answer = 0;
		for (int i = 0; i < 14; i++) {
			if (original[i] == 0)
				continue;

			long[] hole = Arrays.copyOf(original, original.length);
			long quotient = hole[i] / 14;
			long remainder = hole[i] % 14;
			hole[i] = 0;

			for (int j = 1; j <= 14; j++)
				hole[(i + j) % 14] += quotient;
			for (int j = 1; j <= remainder; j++)
				hole[(i + j) % 14]++;

			long sum = 0;
			for (int j = 0; j < 14; j++)
				if (hole[j] % 2 == 0)
					sum += hole[j];
			answer = Math.max(answer, sum);
		}

		bw.write(String.valueOf(answer));
		bw.close();
	}
}