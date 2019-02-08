/*
 * Author: Minho Kim (ISKU)
 * Date: February 7, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14438
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int SQRT = (int) Math.sqrt(N);
		int[] array = new int[N + 1];
		int[] min = new int[SQRT + 1];
		Arrays.fill(min, Integer.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			min[i / SQRT] = Math.min(min[i / SQRT], array[i]);
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				int index = i / SQRT;
				int l = index * SQRT;
				int r = l + SQRT;
				min[index] = Integer.MAX_VALUE;
				array[i] = v;
				while (l < r && l <= N)
					min[index] = Math.min(min[index], array[l++]);
			}
			if (cmd == 2) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				int answer = Integer.MAX_VALUE;
				while (l % SQRT != 0 && l <= r)
					answer = Math.min(answer, array[l++]);
				while (l + SQRT < r) {
					answer = Math.min(answer, min[l / SQRT]);
					l += SQRT;
				}
				while (l <= r)
					answer = Math.min(answer, array[l++]);

				bw.write(String.valueOf(answer));
				bw.write('\n');
			}
		}

		bw.close();
	}
}