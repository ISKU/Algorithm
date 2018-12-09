/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4158
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;

			Set<Integer> set = new HashSet<>();
			int count = 0;

			for (int i = 0; i < N; i++)
				set.add(Integer.parseInt(br.readLine()));
			for (int i = 0; i < M; i++)
				if (set.contains(Integer.parseInt(br.readLine())))
					count++;

			bw.write(String.valueOf(count));
			bw.write('\n');
		}

		bw.close();
	}
}
